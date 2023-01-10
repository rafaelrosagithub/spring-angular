package io.github.rafaelrosagithub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class MyConfiguration {

    @Bean(name = "profileDev")
    public String profile() {
        return "Development";
    }

    @Bean
    public CommandLineRunner excute() {
        return args -> {
            System.out.println("Running the development environment");
        };
    }

}
