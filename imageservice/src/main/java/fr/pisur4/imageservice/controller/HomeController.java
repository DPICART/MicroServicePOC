package fr.pisur4.imageservice.controller;

import fr.pisur4.imageservice.model.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private Environment environment;

    final List<Image> images = Arrays.asList(
            new Image("1", "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
            new Image("2", "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"),
            new Image("3", "The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112")
    );

    @RequestMapping(value = "/images")
    public List<Image> getImages() throws Exception {
//        throw new Exception("Images can't be fetched");
        log.info("Chargement des images");
        return images;
    }

    @RequestMapping(value = "/image/{id}")
    public Image getImage(final @PathVariable("id") String id) throws Exception {
        log.info("Récupération de l'image d'id :"+id);
        Image image = images.stream().filter(im -> {
            return im.getId().equalsIgnoreCase(id);
        }).findFirst().get();

        if(null == image)
        {
            log.warn("Pas d'image d'id: "+id);
            throw new Exception("Image can't be fetched");
        }
        return image;

    }

}
