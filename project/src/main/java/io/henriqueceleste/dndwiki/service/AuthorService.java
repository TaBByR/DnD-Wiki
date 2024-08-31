package io.henriqueceleste.dndwiki.service;

import io.henriqueceleste.dndwiki.command.AuthorDTO;
import io.henriqueceleste.dndwiki.converter.AuthorToAuthorDto;
import io.henriqueceleste.dndwiki.dao.AuthorDao;
import io.henriqueceleste.dndwiki.model.Author;
import io.henriqueceleste.dndwiki.utility.DataReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements io.henriqueceleste.dndwiki.service.Service<Author> {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private AuthorToAuthorDto authorToAuthorDto;

    @Override
    public Author get(Integer id) {
        return authorDao.findById(id);
    }

    public List<AuthorDTO> list() {
        return authorToAuthorDto.convert(authorDao.findAll());
    }
}
