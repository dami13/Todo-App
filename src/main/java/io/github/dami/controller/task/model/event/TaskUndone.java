package io.github.dami.controller.task.model.event;

import io.github.dami.controller.task.model.projection.Task;

import java.time.Clock;

public class TaskUndone extends TaskEvent {
    TaskUndone(Task source) {
        super(source.getId(), Clock.systemDefaultZone());
    }
}
