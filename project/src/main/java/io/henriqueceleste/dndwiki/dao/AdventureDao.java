package io.henriqueceleste.dndwiki.dao;

import io.henriqueceleste.dndwiki.model.Adventure;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AdventureDao implements Dao<Adventure>{

    @PersistenceContext
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public Adventure findById(Integer id) {
        return em.find(Adventure.class, id);
    }
}
