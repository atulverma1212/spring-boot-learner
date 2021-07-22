package com.airtel.ytl.controller;

import com.airtel.ytl.dto.*;
import com.airtel.ytl.service.BusinessClass;
import com.airtel.ytl.service.FileWriterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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



    @RequestMapping(value = "/ytl/writeInfile", method = RequestMethod.POST)
    public ResponseEntity<SaveInFileResponse> writeInFile(@RequestBody SaveInFileRequest request) {
        SaveInFileResponse response = new SaveInFileResponse();
        String replyFromFileWriter = fileWriterClass.writeFile(request.getMatrix());
        response.setResponse(replyFromFileWriter);
        return ResponseEntity.ok(response);
    }
}
