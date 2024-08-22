package io.henriqueceleste.dndwiki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/adventures")
public class AdventureController {

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public String listAdventures(Model model) {
        return "adventures";
    }

}
