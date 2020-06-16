package cointwo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"cointwo"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "cointwo.*Config"))
public class ControllerConfig {



}