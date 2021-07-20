package com.airtel.ytl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class FileWriterClass {

    BusinessClass businessClass = new BusinessClass();

    public String writeFile(List<List<String>> matrix) {

        List<String> list = businessClass.matrixToListOfString(matrix);

        File file;
        {
            try {
                file = new File("C:ResponseFileOfAPI.txt");
                System.out.println(file.getName());
                BufferedWriter writer = new BufferedWriter(new FileWriter("ResponseFileOfAPI.txt", true));
                if (file.length() != 0) {
                    writer.newLine();
                }
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
