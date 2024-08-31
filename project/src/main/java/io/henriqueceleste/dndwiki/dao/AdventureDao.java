package io.henriqueceleste.dndwiki.dao;

import io.henriqueceleste.dndwiki.model.Adventure;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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

    @Override
    public List<Adventure> findAll() {
        CriteriaQuery<Adventure> criteriaQuery = em.getCriteriaBuilder().createQuery(Adventure.class);
        Root<Adventure> root = criteriaQuery.from(Adventure.class);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
