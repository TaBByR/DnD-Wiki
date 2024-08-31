package io.henriqueceleste.dndwiki.converter;

import io.henriqueceleste.dndwiki.command.AdventureDTO;
import io.henriqueceleste.dndwiki.model.Adventure;
import io.henriqueceleste.dndwiki.utility.DataReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdventureToAdventureDto implements Converter<AdventureDTO, Adventure> {

    @Autowired
    private DataReader dataReader;

    @Override
    public List<AdventureDTO> convert(List<Adventure> adventureList) {
        return adventureList.stream().map(this::loadResources)
                .collect(Collectors.toList());
    }

    @Override
    public AdventureDTO loadResources(Adventure adventure) {

        AdventureDTO result = new AdventureDTO();

        result.setTitle(adventure.getTitle());
        result.setAuthor(adventure.getAuthor());
        result.setDescription(dataReader.getDescription(adventure));
        result.setImages(dataReader.getImages(adventure));
        result.setType(adventure.getType());
        result.setStock(adventure.getStock());

        return result;
    }
}
