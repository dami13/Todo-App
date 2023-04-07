package io.github.dami.controller.task.model.projection;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Embeddable
class Audit {
    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    @PrePersist
    void prePersists() {
        this.createdOn = LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate() {
        this.updatedOn = LocalDateTime.now();
    }
}
