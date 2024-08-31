package io.henriqueceleste.dndwiki.command;

import io.henriqueceleste.dndwiki.model.Author;

import java.util.ArrayList;
import java.util.List;

public class AdventureDTO {
    private String title;
    private String type;
    private Integer stock;
    private List<String> images = new ArrayList<>();
    private String description;
    private Author author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "AdventureDTO{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", stock=" + stock +
                ", images=" + images +
                ", description='" + description + '\'' +
                ", author=" + author +
                '}';
    }
}
