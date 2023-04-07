package io.github.dami.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Order
@Slf4j
@Component
public class LoggerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request instanceof HttpServletRequest) {
            var servletRequest = (HttpServletRequest) request;
            log.info("[LoggerFilter] " + servletRequest.getMethod() + " " + servletRequest.getRequestURI());
        }
        chain.doFilter(request, response);
    }
}
