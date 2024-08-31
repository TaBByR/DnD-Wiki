package io.henriqueceleste.dndwiki.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adventure")
public class Adventure extends AbstractModel{
    private String title;
    private String description;
    private String images;
    private String type;
    private Integer stock;

    @ManyToOne
    private Author author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Adventure{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", images='" + images + '\'' +
                ", type='" + type + '\'' +
                ", stock=" + stock +
                ", author=" + author +
                '}';
    }
}
