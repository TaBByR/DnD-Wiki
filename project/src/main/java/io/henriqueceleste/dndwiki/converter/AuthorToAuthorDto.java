package io.henriqueceleste.dndwiki.converter;

import io.henriqueceleste.dndwiki.command.AdventureDTO;
import io.henriqueceleste.dndwiki.command.AuthorDTO;
import io.henriqueceleste.dndwiki.model.Adventure;
import io.henriqueceleste.dndwiki.model.Author;
import io.henriqueceleste.dndwiki.utility.DataReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorToAuthorDto implements Converter<AuthorDTO, Author> {

    @Autowired
    private DataReader dataReader;

    @Override
    public List<AuthorDTO> convert(List<Author> authorList){
        return authorList.stream().map(this::loadResources)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDTO loadResources(Author author) {

        AuthorDTO result = new AuthorDTO();

        result.setId(author.getId());
        result.setDescription(dataReader.getDescription(author));
        result.setImages(dataReader.getImages(author));
        result.setName(author.getName());

        return result;
    }

}
