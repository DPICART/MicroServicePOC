package fr.pisur4.imageservice.model;

import lombok.Getter;
import lombok.Setter;

public class Image {

    @Getter
    private String id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String url;

    public Image()
    {
        super();
    }

    public Image(String id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }


}
