package io.henriqueceleste.dndwiki.controller;

import io.henriqueceleste.dndwiki.service.AdventureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
@RequestMapping("/adventures")
public class AdventureController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdventureService adventureService;

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public String listAdventures(Model model) {

        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db/test-data.sql"));

        try (Connection conn = dataSource.getConnection()) {
            populator.populate(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(adventureService.get(1));

        return "adventures";
    }

}
