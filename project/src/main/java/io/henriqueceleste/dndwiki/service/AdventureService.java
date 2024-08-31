package io.henriqueceleste.dndwiki.service;

import io.henriqueceleste.dndwiki.command.AdventureDTO;
import io.henriqueceleste.dndwiki.converter.AdventureToAdventureDto;
import io.henriqueceleste.dndwiki.dao.AdventureDao;
import io.henriqueceleste.dndwiki.model.Adventure;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@org.springframework.stereotype.Service
public class AdventureService implements Service<Adventure> {

    @Autowired
    private AdventureDao adventureDao;

    @Autowired
    private AdventureToAdventureDto adventureToAdventureDto;

    @Override
    public Adventure get(Integer id) {
        return adventureDao.findById(id);
    }

    public List<AdventureDTO> list() {
        return adventureToAdventureDto.convert(adventureDao.findAll());
    }
}
