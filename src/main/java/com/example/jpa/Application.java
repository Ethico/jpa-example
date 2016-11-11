package com.example.jpa;
import com.example.model.Message;
import com.example.repository.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/* This is Application class. Spring boot executes main method directly*/
@ComponentScan(basePackages = "com.example")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
    /*
    CommandLineRunner is a callback interface which gets called when main executes
    */
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
