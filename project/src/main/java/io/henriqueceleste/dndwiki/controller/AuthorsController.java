package io.henriqueceleste.dndwiki.controller;

import io.henriqueceleste.dndwiki.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.list());
        return "authors";
    }

}
