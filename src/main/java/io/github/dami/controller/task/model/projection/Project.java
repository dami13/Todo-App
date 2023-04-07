package io.github.dami.controller.task.model.projection;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Project's description must not be blank")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    Set<TaskGroup> groups;

    @ManyToOne
    @JoinColumn(name = "project_step_id")
    private ProjectStep step;

    @Embedded
    private Audit audit = new Audit();

    public void updateFrom(final Project source) {
        description = source.description;
        groups = source.groups;
        step = source.step;
    }
}
