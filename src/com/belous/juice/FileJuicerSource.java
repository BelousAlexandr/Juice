package com.belous.juice;

import com.belous.fruit.Fruit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by s.belous on 18.02.15.
 */
public class FileJuicerSource implements JuicerSource {

    private String fileName;

    public FileJuicerSource(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Juice> getJuices() {
        File file = new File(fileName);
        checkFileExist(file);
        return readFile(fileName);
    }

    private void checkFileExist(File file) {
        if (!file.exists()) {
            throw new RuntimeException(String.format("File %s does not exist", file.getName()));
        }
    }

    private List<Juice> readFile(String fileName) {
        List<Juice> resultList = new ArrayList<Juice>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                String[] fruits = line.split(" ");
                resultList.add(new Juice(convertStringToFruit(fruits)));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    private static Fruit[] convertStringToFruit(String[] fruits) {
        Fruit[] resultFruits = new Fruit[fruits.length];
        for (int i = 0; i < fruits.length; i++) {
            resultFruits[i] = new Fruit(fruits[i]);
        }
        return resultFruits;
    }
}
