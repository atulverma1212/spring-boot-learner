package com.airtel.ytl.controller;

import com.airtel.ytl.dto.*;
import com.airtel.ytl.service.BusinessClass;
import com.airtel.ytl.service.FileWriterClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;




@RestController
@Slf4j
public class HomeController {

    // TODO: Understand this
    // TODO: Exception handling in APIs
    @Autowired
    private BusinessClass businessClass;

    @Autowired
    FileWriterClass fileWriterClass;

    /**
     * A simple Health GET API, ping-pong
     */

    @RequestMapping(value = "/ytl/ping", method = RequestMethod.GET)
    public ResponseEntity<HealthResponse> getHealth() {
        HealthResponse response = new HealthResponse();
        response.setResponse("pong");
        return ResponseEntity.ok(response);
    }

    /**
     * API to sort the Array
     */
    @RequestMapping(value = "/ytl/sortAsc", method = RequestMethod.POST)
    public ResponseEntity<SortArrayResponse> sortAscending(@RequestBody SortArrayRequest request) {
        SortArrayResponse response = new SortArrayResponse();
        List<Integer> sortedArray = businessClass.sortAsc(request.getArray());
        response.setSortedArray(sortedArray);
        return ResponseEntity.ok(response);
    }

    // TODO: Make an API for transforming Matrix into List
    // List<List<Integer>> to List<Integer>
    @RequestMapping(value = "/ytl/matrixToList", method = RequestMethod.POST)
    public ResponseEntity<MatrixToListResponse> matrixToList(@RequestBody MatrixToListRequest request) {
        MatrixToListResponse response = new MatrixToListResponse();
        List<Integer> list = businessClass.matrixToList(request.getMatrix());
        response.setList(list);
        return ResponseEntity.ok(response);
    }

    // TODO: List<String> : ["My", "NAme","is","Ankush"]
    // return "My Name is Ankush"

    @RequestMapping(value = "/ytl/listToString", method = RequestMethod.POST)
    public ResponseEntity<ListToStringResponse> listToString(@RequestBody ListToStringRequest request) {
        ListToStringResponse response = new ListToStringResponse();
        String string = businessClass.listToString(request.getList());
        response.setConcatenatedString(string);
        return ResponseEntity.ok(response);
    }

    // TODO: convert List<List<String>> to separate list of strings and append them in a file
    // i/p:[["My", "Name","is","Name1"],["My", "Name","is","Name2"],["My", "Name","is","Name3"]]
    // o/p: My Name is Name1\nMy Name is Name2\nMy Name is Name3\n


    @RequestMapping(value = "/ytl/writeInfile", method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"})
    public ResponseEntity<SaveInFileResponse> writeInFile(@RequestBody SaveInFileRequest request,
                                                          @RequestParam String fileName) {
        SaveInFileResponse response = new SaveInFileResponse();
        String replyFromFileWriter = fileWriterClass.writeFile(request.getMatrix(), fileName);
        response.setResponse(replyFromFileWriter);
        return ResponseEntity.ok(response);
    }

    // TODO: return ResponseFile.txt as JSON

    @GetMapping(value = "/ytl/printResponseText")
    public ResponseEntity<RetrieveFileResponse> retrieveFile(@RequestParam String fileName) throws IOException {
        RetrieveFileResponse response = new RetrieveFileResponse();
        List<String> lines = businessClass.setResponseToList(fileName);
        response.setResponse(lines);
        return ResponseEntity.ok(response);
    }

    // TODO: Appending Two Files Thread Safe

    @GetMapping(value = "/ytl/retrieveAppendedFiles")
    public ResponseEntity<RetrieveAppendedFilesResponse> retrieveAppendedFiles(@RequestParam String file1,
                                                                               @RequestParam String file2) throws IOException {
        //RetrieveAppendedFilesResponse response = new RetrieveAppendedFilesResponse();
        Thread thread1 = new Thread(new ThreadClass(file1, file2));
        Thread thread2 = new Thread(new ThreadClass(file1,file2));
        thread1.start();
        thread2.start();
        //List<String> lines = businessClass.appendFiles(file1,file2);
        //response.setResponse(lines);
        return ResponseEntity.ok(globalResponse);
    }

    static RetrieveAppendedFilesResponse globalResponse = new RetrieveAppendedFilesResponse();

    // Tryout method
/*

    @GetMapping(value = "ytl/appendAndReturnWithThread")
    public ResponseEntity<RetrieveAppendedFilesResponse> retrieveWithThread() {
        //static RetrieveAppendedFilesResponse response = new RetrieveAppendedFilesResponse();
        Thread thread1 = new Thread(new ThreadClass());
        Thread thread2 = new Thread(new ThreadClass());
        thread1.start();
        thread2.start();
        return ResponseEntity.ok(globalResponse);
    }
*/

    class ThreadClass implements Runnable {

        String file1,file2;

        public ThreadClass(String file1, String file2) {
            this.file1 = file1;
            this.file2 = file2;
        }

        @Override
        public void run() {
            try {
                List<String> lines = businessClass.appendFiles(file1,file2);
                globalResponse.setResponse(lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}






