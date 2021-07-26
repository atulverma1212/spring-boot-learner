package com.airtel.ytl.service;

import org.springframework.stereotype.Service;

import java.io.*;

import  java.util.List;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class FileWriterClass {
     BusinessClass businessClass=new BusinessClass();

     public String writeFile(List<List<String>> matrix) {
         {
             try {
                 BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true));

                 for (List<String> list : matrix) {
                     String fileName = businessClass.ListofStringToString(list);
                     writer.append(fileName);
                     writer.newLine();
                 }
                 writer.close();
                 return "Data Saved successfully";
             } catch (IOException e) {
                 return "Some fault occured";
             }
         }
     }
}
