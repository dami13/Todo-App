package io.github.dami.reports;

import io.github.dami.controller.task.model.event.TaskDone;
import io.github.dami.controller.task.model.event.TaskEvent;
import io.github.dami.controller.task.model.event.TaskUndone;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChangedTaskEventListener {
    private final PersistedTaskEventRepository taskEventRepository;

    @Async
    @EventListener
    public void on(TaskDone event) {
        onChanged(event);
    }

    @Async
    @EventListener
    public void on(TaskUndone event) {
        onChanged(event);
    }

    private void onChanged(TaskEvent event) {
        log.info("Got " + event);
        taskEventRepository.save(new PersistedTaskEvent(event));
    }
}
