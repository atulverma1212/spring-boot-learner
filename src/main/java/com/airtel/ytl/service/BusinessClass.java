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

    public List<Integer> matrixToList(List<List<Integer>> mat) {
        List<Integer> out = new ArrayList<>() ;
        for(List<Integer> list : mat) {
            out.addAll(list);
        }
        return out;
    }

    public String listToString(List<String> list) {
        String out = "" ;
        for(String str: list) {
            out+= str;
        }
        return out;
    }

}
