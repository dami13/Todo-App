package io.github.dami.aspect;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogicAspect {
    private final Timer createTaskGroupTimer;

    LogicAspect(final MeterRegistry registry) {
        createTaskGroupTimer = registry.timer("logic.taskgroup.create");
    }

    @Pointcut("execution(* io.github.dami.controller.taskgroup.TaskGroupService.createTaskGroup(..))")
    void taskServiceCreateGroup() {}

    @Before("taskServiceCreateGroup()")
    void beforeCreateTaskGroup(JoinPoint jp) {
        log.info("before {} with {}", jp.getSignature().getName(), jp.getArgs());
    }

    @Around("taskServiceCreateGroup()")
    Object aroundCreateTaskGroup(ProceedingJoinPoint jp) {
        return createTaskGroupTimer.record(() -> {
            try {
                return jp.proceed();
            } catch (Throwable e) {
                if(e instanceof RuntimeException) {
                    throw (RuntimeException) e;
                }
                throw new RuntimeException(e);
            }
        });
    }
}
