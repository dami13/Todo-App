package io.github.dami.controller.task.model.dto;

import io.github.dami.controller.task.model.projection.TaskGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class TaskDto {
    private int id;

    private String description;

    private boolean done;

    private LocalDateTime deadline;

    private TaskGroup group;
}
