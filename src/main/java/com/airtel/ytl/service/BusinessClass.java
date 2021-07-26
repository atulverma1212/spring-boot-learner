package com.airtel.ytl.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class BusinessClass {

    public List<Integer> sortAsc(List<Integer> arr) {
        arr.sort(Comparator.comparingInt(a -> a));
        return arr;
    }

    public List<Integer> matrixToList(List<List<Integer>> input){
        int rowSize= input.size();
        // int colSize=input[0].length;

        List<Integer> ans= new ArrayList<>();
        // int k=0;
        for(List<Integer> list: input){
                       ans.addAll(list);
        }
        return ans;
    }


    public String ListofStringToString(List<String > list){
        String output="";
        for(String value : list)
             output=output+value;

        return output;
    }
}

