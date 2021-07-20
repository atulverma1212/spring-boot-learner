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

    public <T> List<T> matrixToList(List<List<T>> mat) {
        List<T> out = new ArrayList<>() ;
        for(List<T> list : mat) {
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

/*
    public List<String> matrixToListOfString(List<List<String>> matrix) {
        List<String> out = new ArrayList<>() ;
        for(List<String> list : matrix) {
            out.addAll(list);
        }
        return out;
    }

*/




}
