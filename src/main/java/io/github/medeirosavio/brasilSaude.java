package io.github.medeirosavio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class brasilSaude {
    public static void main(String[] args) {
        SpringApplication.run(brasilSaude.class,args);
    }

    @Bean
    public CommandLineRunner initialization(){
        return args -> {
            System.out.println("API OK");
        };
    }


}
