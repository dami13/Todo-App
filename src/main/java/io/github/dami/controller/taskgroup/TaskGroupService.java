package io.github.dami.controller.taskgroup;

import io.github.dami.controller.taskgroup.repository.TaskGroupRepository;
import io.github.dami.controller.task.model.projection.TaskGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TaskGroupService {

    private TaskGroupRepository taskGroupRepository;

    @Transactional
    TaskGroup createTaskGroup(TaskGroup tg) {
        return taskGroupRepository.save(tg);
    }
}
