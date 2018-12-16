package fr.pisur4.galleryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GalleryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GalleryserviceApplication.class, args);
    }

}

