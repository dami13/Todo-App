package io.github.dami.controller.task.mapper;

import io.github.dami.controller.task.model.dto.TaskDto;
import io.github.dami.controller.task.model.projection.Task;

import java.util.Optional;

public class TaskMapper {
    public static TaskDto map(Task task) {
        return Optional.ofNullable(task)
                .map(entity ->
                        new TaskDto()
                                .setId(entity.getId())
                                .setDescription(entity.getDescription())
                                .setDone(entity.isDone())
                                .setDeadline(entity.getDeadline()))
                .orElse(null);
    }
}
