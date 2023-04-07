package io.github.dami.controller.task.service;

import io.github.dami.controller.task.repository.TaskRepository;
import io.github.dami.controller.task.mapper.TaskMapper;
import io.github.dami.controller.task.model.dto.TaskDto;
import io.github.dami.controller.task.model.projection.Task;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Timed(value = "task.service.getAll", histogram = true, percentiles = {0.5, 0.95, 0.99})
    public List<TaskDto> getAll(Pageable page) {
        return taskRepository.findAll(page.getSort())
                .stream().map(TaskMapper::map).collect(Collectors.toList());
    }

    public Optional<Task> getTask(int taskId) {
        return taskRepository.findById(taskId);
    }

    @Transactional
    public void updateTask(int taskId, Task updatedTask) {
        taskRepository.findById(taskId)
                .ifPresentOrElse(
                        task -> task.updateFrom(updatedTask),
                        EntityNotFoundException::new);
    }

    @Transactional
    @Timed(value = "task.service.create", histogram = true, percentiles = {0.5, 0.95, 0.99})
    public void createTask(Task task) {
        taskRepository.save(task);
    }

    @Transactional
    public void toggleTask(int taskId) {
        taskRepository.findById(taskId)
                .map(Task::toggle)
                .ifPresent(eventPublisher::publishEvent);
    }

    @Transactional
    public void deleteTask(int taskId) {
        taskRepository.deleteById(taskId);
    }
}
