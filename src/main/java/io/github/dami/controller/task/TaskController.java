package io.github.dami.controller.task;

import io.github.dami.config.IllegalExceptionProcessing;
import io.github.dami.controller.task.service.TaskService;
import io.github.dami.controller.task.model.dto.TaskDto;
import io.github.dami.controller.task.model.projection.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
@IllegalExceptionProcessing
@RequiredArgsConstructor
@RestController("/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    ResponseEntity<List<TaskDto>> readAllTasks(Pageable page) {
        return Optional.of(page)
                .map(taskService::getAll)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("{id}")
    ResponseEntity<Task> getTaskById(@PathVariable int id) {
        return taskService.getTask(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createTask(@RequestBody @Valid Task task) {
        taskService.createTask(task);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateTask(@PathVariable int id, @RequestBody @Valid Task task) {
        taskService.updateTask(id, task);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void toggleTask(@PathVariable int id) {
        taskService.toggleTask(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }
}
