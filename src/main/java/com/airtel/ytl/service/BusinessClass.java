package com.airtel.ytl.service;

import com.airtel.ytl.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class BusinessClass {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public List<Integer> sortAsc(List<Integer> arr) {
        arr.sort(Comparator.comparingInt(a -> a));
        return arr;
    }

    public <T> List<T> matrixToList(List<List<T>> mat) {
        List<T> out = new ArrayList<>() ;
        for(List<T> list : mat) {
            out.addAll(list);
        }
        return out;
    }

    public String listToString(List<String> list) {
        String out = "" ;
        for(String str: list) {
            out+= str;
            out+=" ";
        }
        return out;
    }

    public List<String> setResponseToList() throws IOException {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(Constants.filename));
            logger.info("file retrieved successfully");
        }
        catch (NoSuchFileException e) {
            lines.add("File doesn't exist");
            //logger.error("File doesn't exist",e);
            throw e;
        }
        catch (IOException e) {
           //logger.error("Some exception occurred",e);
            throw e;
        }
        return lines;
    }

}
