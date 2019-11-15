package ubb.uni10.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;

@Configuration
public class WebConfiguration {

    @Autowired
    public WebConfiguration() {
        System.out.println("WebConfiguration created");
    }

    public WebConfiguration(String s){
        System.out.println(s);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        System.out.println("CommandLineRunner created");
        return str -> {
            System.out.println("CommandLineRunner executes");
        };
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("After construction of the component, this method will be called");
        // do some config
        System.out.println("Bean of type: " + WebConfiguration.class + " finished building");
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("Before destruction of the component, this method will be called");
        System.out.println("Bean of type: " + WebConfiguration.class + " destroyed");
    }

    @Scheduled(fixedDelay = 60000, initialDelay = 1000)
    private void print() {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(String.format("Hello, it is %d:%d", time.getHour(), time.getMinute()));
    }
}
