package io.github.dami.controller.task.model.event;

import io.github.dami.controller.task.model.projection.Task;
import lombok.Getter;
import lombok.ToString;

import java.time.Clock;
import java.time.Instant;

@Getter
@ToString
public class TaskEvent {
    public static TaskEvent changed(Task source) {
        return source.isDone() ? new TaskDone(source) : new TaskUndone(source);
    }

    private int taskId;
    private Instant occurrence;

    TaskEvent(int taskId, Clock clock) {
        this.taskId = taskId;
        this.occurrence = Instant.now(clock);
    }
}
