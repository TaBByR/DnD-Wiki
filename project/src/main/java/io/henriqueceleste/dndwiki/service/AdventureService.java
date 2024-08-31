package io.henriqueceleste.dndwiki.service;

import io.henriqueceleste.dndwiki.command.AdventureDTO;
import io.henriqueceleste.dndwiki.dao.AdventureDao;
import io.henriqueceleste.dndwiki.model.Adventure;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class AdventureService implements Service<Adventure> {

    private final String BASE_DIR_PATH = "WEB-INF/classes/";

    @Autowired
    ServletContext servletContext;

    @Autowired
    private AdventureDao adventureDao;


    @Override
    public Adventure get(Integer id) {
        return adventureDao.findById(id);
    }

    public List<AdventureDTO> list() {
        return convertAdventures(adventureDao.findAll());
    }

    private List<AdventureDTO> convertAdventures(List<Adventure> adventureList){
        return adventureList.stream().map(this::loadAdventureResources)
                .collect(Collectors.toList());
    }

    private AdventureDTO loadAdventureResources(Adventure adventure) {

        AdventureDTO result = new AdventureDTO();

        result.setTitle(adventure.getTitle());
        result.setAuthor(adventure.getAuthor());
        result.setDescription(getDescription(adventure));
        result.setImages(getImages(adventure));
        result.setType(adventure.getType());
        result.setStock(adventure.getStock());

        return result;
    }

    private List<String> getImages(Adventure adventure){

        List<String> result = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(servletContext.getRealPath(BASE_DIR_PATH + adventure.getImages())));

            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error closing reader: " + e.getMessage());
        }

        return result;
    }

    private String getDescription(Adventure adventure) {

        String result = "";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(servletContext.getRealPath(BASE_DIR_PATH + adventure.getDescription())));

            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error closing reader: " + e.getMessage());
        }

        return result;
    }


}
