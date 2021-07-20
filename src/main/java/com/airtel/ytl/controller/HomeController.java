package com.airtel.ytl.controller;

import com.airtel.ytl.dto.*;
import com.airtel.ytl.service.BusinessClass;
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
}
