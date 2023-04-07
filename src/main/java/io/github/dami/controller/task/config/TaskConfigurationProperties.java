package io.github.dami.controller.task.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "task.template")
public class TaskConfigurationProperties {
    private boolean allowMultipleTasks;
}
