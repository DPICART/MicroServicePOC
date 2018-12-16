package fr.pisur4.galleryservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import fr.pisur4.galleryservice.model.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment environment;

    @RequestMapping("/")
    public String home() {
        return "GalleryService from port: " + environment.getProperty("local.server.port");
    }

    @RequestMapping("/admin")
    public String homeAdmin()
    {
        return "GalleryService from port: "+environment.getProperty("local.server.port")+" restricted to admin.";
    }

    // Cette méthode est appelée lorsqu'une exception est remontée.
    // ex: Exception levée lors du chargement des images
    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping( value = "/{id}")
    public Gallery getGallery(@PathVariable final String id)
    {
        Gallery gallery = new Gallery();
        gallery.setId(id);

        // Etant donné que l'on utilise Eureka pour nommer les services et Ribbon pour le loadbalancing,
        // on peut utiliser "service-image" (définit dans application.properties) au lieu de "localhost:port"
        List<Object> images = restTemplate.getForObject("http://service-image/images/", List.class);
        gallery.setImages(images);
        return gallery;
    }


    public Gallery fallback(String galleryId, Throwable hystrixCommand) {
        return new Gallery(galleryId);
    }

}
