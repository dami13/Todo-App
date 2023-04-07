package io.github.dami.task.controller;

import io.github.dami.controller.task.model.projection.Task;
import io.github.dami.controller.task.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskControllerE2ETest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TaskService taskService;

    @Test
    void httpGet_readAllTasks_returnAllTasks() throws Exception {
        // given
        var newTask = new Task();
        newTask.setDone(true);
        newTask.setDescription("test");
        taskService.createTask(newTask);
        var initialSize = taskService.getAll(null).size();
        
        // when
        var result = restTemplate.getForObject("http://localhost:" + port + "/tasks", Task[].class);

        // then
        assertThat(result).hasSize(initialSize + 1);
    }
}