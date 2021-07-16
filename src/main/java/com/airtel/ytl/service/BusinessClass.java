package com.airtel.ytl.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class BusinessClass {

    public List<Integer> sortAsc(List<Integer> arr) {
        arr.sort(Comparator.comparingInt(a -> a));
        return arr;
    }

}
