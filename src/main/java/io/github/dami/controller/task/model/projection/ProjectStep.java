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
@Table(name = "project_steps")
public class ProjectStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Project step's description must not be blank")
    private String description;

    private Integer daysToDeadline;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "step")
    private Set<Project> group;

    @Embedded
    private Audit audit = new Audit();

    public void updateFrom(final ProjectStep source) {
        description = source.description;
        daysToDeadline = source.daysToDeadline;
        group = source.group;
    }
}
