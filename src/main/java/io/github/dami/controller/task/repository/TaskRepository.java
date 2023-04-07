package io.github.dami.controller.task.repository;

import io.github.dami.controller.task.model.projection.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Override
    @Query(nativeQuery = true, value =
            " SELECT COUNT(*) > 0 "
            + " FROM task "
            + " WHERE id = :id ")
    boolean existsById(@Param("id") Integer id);

    List<Task> findByDone(@Param("state") boolean done);

    boolean existsByGroup_Id(Integer groupId);

    boolean existsByDoneIsFalseAndGroup_Id(Integer groupId);
}
