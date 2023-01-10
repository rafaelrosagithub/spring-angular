package io.github.rafaelrosagithub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SalesApplication {

    @Value("${application.name}")
    private String applicationName;

    @Qualifier("${profileDev}")
    private String profile;

    @GetMapping("/hello")
    public String helloWorld() {
        return applicationName + ", Profile: " + profile;
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }
}
