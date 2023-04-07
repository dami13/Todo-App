package io.github.dami.task.controller;

import io.github.dami.controller.task.TaskController;
import io.github.dami.controller.task.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Test
    void isValid_readAllTasks_returnOk() throws Exception {
        // given
        
        // when
        var response =
                this.mockMvc.perform(get("/"))
                        .andDo(print());

        // then
        response.andExpect(status().isOk());
    }

    @Test
    void testReadAllTasks() throws Exception {
        // given

        // when
        var response =
                this.mockMvc.perform(get("/")) // TODO and [page]
                        .andDo(print());

        // then
        response.andExpect(status().isOk());
    }

    @Test
    void getTaskById() throws Exception {
        // given

        // when
        var response =
                this.mockMvc.perform(get("/"))
                        .andDo(print());

        // then
        response.andExpect(status().isOk());
    }

    @Test
    void createTask() throws Exception {
        // given

        // when
        var response =
                this.mockMvc.perform(post("/"))
                        .andDo(print());

        // then
        response.andExpect(status().isOk());
    }

    @Test
    void updateTask() throws Exception {
        // given

        // when
        var response =
                this.mockMvc.perform(put("/"))
                        .andDo(print());

        // then
        response.andExpect(status().isOk());
    }

    @Test
    void toggleTask() throws Exception {
        // given

        // when
        var response =
                this.mockMvc.perform(patch("/"))
                        .andDo(print());

        // then
        response.andExpect(status().isOk());
    }

    @Test
    void deleteTask() throws Exception {
        // given

        // when
        var response =
                this.mockMvc.perform(delete("/"))
                        .andDo(print());

        // then
        response.andExpect(status().isOk());
    }
}