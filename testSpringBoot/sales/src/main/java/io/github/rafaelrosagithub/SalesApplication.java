package io.github.rafaelrosagithub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Development
public class SalesApplication {

    @Autowired
    @Qualifier("profileDev")
    private String applicationName;

    @Dog
    private Animal animal;

    @Bean
    public CommandLineRunner execute() {
        return args -> {
            this.animal.makeNoise();
        };
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return applicationName;
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }
}
