
package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class Start {
    public static void main(String[] data) {
        ApplicationContext context;
        context = SpringApplication.run(Setup.class);
    }
}

@SpringBootApplication
class Setup {
    String connectionString = "jdbc:mysql://127.0.0.1/platform?user=bob&password=bob$8513";
    
    @Bean
    DriverManagerDataSource create() {
        return new DriverManagerDataSource(connectionString);
    }
}

@RestController
class Sample {
    @RequestMapping("/check")
    String showCheck() {
        return "OK";
    }
}

