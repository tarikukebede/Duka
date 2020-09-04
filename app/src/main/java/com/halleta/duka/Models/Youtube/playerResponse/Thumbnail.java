package com.halleta.duka.Models.Youtube.playerResponse;

import java.io.Serializable;
import java.util.List;

public class Thumbnail implements Serializable {
    private List<ThumbnailsItem> thumbnails;

    public List<ThumbnailsItem> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(List<ThumbnailsItem> thumbnails) {
        this.thumbnails = thumbnails;
    }

    @Override
    public String toString() {
        return
                "Thumbnail{" +
                        "thumbnails = '" + thumbnails + '\'' +
                        "}";
    }
}