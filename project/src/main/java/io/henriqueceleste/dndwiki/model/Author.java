package io.henriqueceleste.dndwiki.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "author")
public class Author extends AbstractModel {
    private String name;
    private String description;
    private String images;

    @OneToMany(cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "author",
            fetch = FetchType.EAGER
    )
    private List<Adventure> adventures = new ArrayList<>();

    public String getName() {
        return name;
    }

    @Override
    public String getImages() {
        return this.images;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
