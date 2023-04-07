package io.github.dami.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Set;

@Component
public class Configuration implements WebMvcConfigurer {
    private Set<HandlerInterceptor> interceptors;

    Configuration(final Set<HandlerInterceptor> interceptors) {
        this.interceptors = interceptors;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        interceptors.stream().forEach(registry::addInterceptor);
    }
}
