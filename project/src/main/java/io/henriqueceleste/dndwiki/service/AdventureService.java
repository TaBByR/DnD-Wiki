package io.henriqueceleste.dndwiki.service;

import io.henriqueceleste.dndwiki.dao.AdventureDao;
import io.henriqueceleste.dndwiki.model.Adventure;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class AdventureService implements Service<Adventure> {

    @Autowired
    private AdventureDao adventureDao;

    @Override
    public Adventure get(Integer id) {
        return adventureDao.findById(id);
    }
}
