package com.airtel.ytl.service;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class FileWriterClass {

    BusinessClass businessClass = new BusinessClass();

    public String writeFile(List<List<String>> matrix) {

        List<String> list = businessClass.matrixToList(matrix);

        {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("ResponseFileOfAPI.txt", true));

                for (String line : list) {
                    writer.append(line);
                    writer.newLine();
                }
                writer.close();
                return "Data Saved in File Successfully";
            } catch (IOException e) {
                e.printStackTrace();
                return "Some Error Occurred";
            }
        }
    }

}
