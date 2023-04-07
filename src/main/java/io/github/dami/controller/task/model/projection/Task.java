package io.github.dami.controller.task.model.projection;

import io.github.dami.controller.task.model.event.TaskEvent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Task's description must not be blank")
    private String description;

    @Setter(AccessLevel.PRIVATE) private boolean done;

    private LocalDateTime deadline;

    @ManyToOne
    @JoinColumn(name = "task_group_id")
    private TaskGroup group;

    @Embedded
    private Audit audit = new Audit();

    public void updateFrom(final Task source) {
        description = source.getDescription();
        done = source.isDone();
        deadline = source.getDeadline();
        group = source.group;
    }

    public TaskEvent toggle() {
        this.done = !this.done;
        return TaskEvent.changed(this);
    }
}
