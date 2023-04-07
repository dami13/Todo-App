package io.github.dami.config;

import io.github.dami.controller.task.model.projection.Task;
import io.github.dami.controller.task.model.projection.TaskGroup;
import io.github.dami.controller.taskgroup.repository.TaskGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Component
public class ApplicationListener implements org.springframework.context.ApplicationListener<ContextRefreshedEvent> {
    private final TaskGroupRepository taskGroupRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Application warmup after context refreshed");
        String description = "ApplicationContextEvent";

        if (!taskGroupRepository.existsByDescription(description)) {
            log.info("No required task group found! Adding!");

            var group = new TaskGroup();
            var task = new Task();

            task.setGroup(group);
            task.setDescription("ContextStartedEvent");

            group.setDescription(description);
            group.setTaskList(Set.of(task));

            taskGroupRepository.save(group);
        }
    }
}
