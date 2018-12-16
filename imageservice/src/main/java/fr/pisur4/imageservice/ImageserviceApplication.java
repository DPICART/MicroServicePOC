package fr.pisur4.imageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ImageserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageserviceApplication.class, args);
    }

}

