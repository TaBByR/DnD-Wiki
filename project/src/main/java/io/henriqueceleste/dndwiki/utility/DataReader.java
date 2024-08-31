package io.henriqueceleste.dndwiki.utility;

import io.henriqueceleste.dndwiki.model.Adventure;
import io.henriqueceleste.dndwiki.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataReader {

    private final String BASE_DIR_PATH = "WEB-INF/classes/";

    @Autowired
    ServletContext servletContext;

    public List<String> getImages(Model data) {

        List<String> result = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(servletContext.getRealPath(BASE_DIR_PATH + data.getImages())));

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

    public String getDescription(Model data) {

        String result = "";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(servletContext.getRealPath(BASE_DIR_PATH + data.getDescription())));

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
