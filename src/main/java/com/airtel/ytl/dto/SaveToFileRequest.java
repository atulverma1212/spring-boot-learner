package com.airtel.ytl.dto;

import java.util.ArrayList;
import java.util.List;

public class SaveToFileRequest {

    private List<List<String>> list;

    public List<List<String>> getList() {
        return list;
    }

    public void setList(List<List<String>> list) {
        this.list = list;
    }
}
