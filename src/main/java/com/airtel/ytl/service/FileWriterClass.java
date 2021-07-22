package com.airtel.ytl.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class FileWriterClass {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    BusinessClass businessClass = new BusinessClass();

    public String writeFile(List<List<String>> matrix) {

        //List<String> list = businessClass.matrixToList(matrix);
        {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("ResponseFile.txt", true));
                for (List<String> list : matrix) {
                    String line = businessClass.listToString(list);
                    writer.append(line);
                    writer.newLine();
                }
                writer.close();
                logger.info("Data is saved successfully");
                return "Data Saved in File Successfully";
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("In catch block, some error occurred");
                return "Some Error Occurred";
            }
        }
    }


}
