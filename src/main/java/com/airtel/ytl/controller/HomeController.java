package com.airtel.ytl.controller;

import com.airtel.ytl.dto.*;
import com.airtel.ytl.service.BusinessClass;
import  com.airtel.ytl.service.FileWriterClass;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.omg.CORBA.PUBLIC_MEMBER;
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
    private FileWriterClass fileWriterClass;
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
    public ResponseEntity<MatrixToListResponse> toList(@RequestBody MatrixToListRequest request){
        MatrixToListResponse response =new MatrixToListResponse();
        List<Integer> transformedArray= businessClass.matrixToList(request.getMatrix());
        response.setArr(transformedArray);
        return ResponseEntity.ok(response);
    }

    /**
     *  TODO: List<String> : ["My", "NAme","is","Ankush"]
      *  return "My Name is Ankush"
     */
      @RequestMapping(value = "/ytl/listToString", method = RequestMethod.POST)
      public ResponseEntity<ListofStringResponse> listToString(@RequestBody ListofStringRequest request){
          ListofStringResponse response=new ListofStringResponse();
          String returnString= businessClass.ListofStringToString(request.getStringList());
          response.setStringResponse(returnString);
          return ResponseEntity.ok(response);
      }

      @RequestMapping(value = "/ytl/fileWriter",method = RequestMethod.POST)
      public ResponseEntity<SaveToFileResponse> fileToString(@RequestBody SaveToFileRequest request){
          SaveToFileResponse response= new SaveToFileResponse();
          String output=fileWriterClass.writeFile(request.getList());
          response.setOutputFile(output);
          return ResponseEntity.ok(response);
      }

      @RequestMapping(value = "ytl/divideUsingInput",method = RequestMethod.POST)
      public ResponseEntity<OutputToInput> divideThroughInput(@RequestBody InputRequest request){
          OutputToInput response= new OutputToInput();
          int value= businessClass.InputDivideOutput(request.getList());
          response.setValue(value);
          return ResponseEntity.ok(response);
      }
}
