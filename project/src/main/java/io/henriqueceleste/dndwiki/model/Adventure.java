package io.henriqueceleste.dndwiki.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
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
