package io.github.dami.controller.task.model.projection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "task_groups")
public class TaskGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Task group's description must not be empty")
    private String description;

    private boolean done;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<Task> taskList;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Embedded
    private Audit audit = new Audit();

    public void updateFrom(final TaskGroup source) {
        description = source.description;
        done = source.done;
        taskList = source.taskList;
        project = source.project;
    }
}
