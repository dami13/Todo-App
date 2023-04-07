package io.github.dami.controller.task.model.event;

import io.github.dami.controller.task.model.projection.Task;

import java.time.Clock;

public class TaskDone extends TaskEvent {
    TaskDone(Task source) {
        super(source.getId(), Clock.systemDefaultZone());
    }
}
