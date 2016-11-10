package com.example.jpa;
import com.example.model.Message;
import com.example.repository.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by hrushikeshp on 11/10/2016.
 */
@ComponentScan(basePackages = "com.example")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
    @Bean
    public CommandLineRunner demo(final MessageRepository repository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                repository.save(new Message("Hi"));
                repository.save(new Message("Hi2"));
                repository.save(new Message("Hi3"));
                repository.save(new Message("Hi4"));
                repository.save(new Message("Hi5"));

                for(Message message: repository.findAll()){
                    System.out.println(message);
                }

            }
        };



    }

}
