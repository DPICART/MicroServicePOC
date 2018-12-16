package fr.pisur4.galleryservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Gallery {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private List<Object> images;

    public Gallery() {
        super();
    }

    public Gallery(String id) {
        this.id = id;
    }
}
