package io.henriqueceleste.dndwiki.dao;

import io.henriqueceleste.dndwiki.model.Adventure;
import io.henriqueceleste.dndwiki.model.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AuthorDao implements Dao<Author>{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Author findById(Integer id) {
        return em.find(Author.class, id);
    }

    @Override
    public List<Author> findAll() {
        CriteriaQuery<Author> criteriaQuery = em.getCriteriaBuilder().createQuery(Author.class);
        Root<Author> root = criteriaQuery.from(Author.class);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
