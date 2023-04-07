package io.github.dami.controller.info;

import io.github.dami.controller.task.config.TaskConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class InfoController {
    private final TaskConfigurationProperties appProp;

    @GetMapping("/info/prop")
    public boolean getConfigurationProperties() {
        return appProp.isAllowMultipleTasks();
    }
}