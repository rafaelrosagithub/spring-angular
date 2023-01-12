package io.github.rafaelrosagithub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfiguration {

    @Bean(name = "dog")
    public Animal dog() {
        return new Animal() {
            @Override
            public void makeNoise() {
                System.out.println("Au Au");
            }
        };
    }

    @Bean(name = "chicken")
    public Animal chicken() {
        return new Animal() {
            @Override
            public void makeNoise() {
                System.out.println("Có Có");
            }
        };
    }
}
