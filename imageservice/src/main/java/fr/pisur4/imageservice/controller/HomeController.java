package fr.pisur4.imageservice.controller;

import fr.pisur4.imageservice.model.Image;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private Environment environment;

    final List<Image> images = Arrays.asList(
            new Image("1", "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
            new Image("2", "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"),
            new Image("3", "The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112")
    );

    @RequestMapping(value = "/images")
    public List<Image> getImages()
    {
        return images;
    }

    @RequestMapping(value = "/image/{id}")
    public Optional<Image> getImage(final @PathVariable("id") String id)
    {
        return images.stream().filter(im -> {
            return im.getId().equalsIgnoreCase(id);
        }).findFirst();
    }

}
