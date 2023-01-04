package io.github.rafaelrosagithub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean(name = "applicationName")
    public String applicationName() {
        return "Sales System";
    }

    @Bean(name = "anotherConfiguration")
    public String applicationName2() {
        return "Sales System 2 teste";
    }

}
