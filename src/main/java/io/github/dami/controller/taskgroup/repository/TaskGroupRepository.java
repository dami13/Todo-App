package io.github.dami.controller.taskgroup.repository;

import io.github.dami.controller.task.model.projection.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskGroupRepository extends JpaRepository<TaskGroup, Integer> {
    boolean existsByDescription(String description);
}
