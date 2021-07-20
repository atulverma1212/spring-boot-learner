package com.airtel.ytl.dto;

import java.util.List;

public class SaveInFileRequest {

    private List<List<String>> matrix;

    public List<List<String>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<String>> matrix) {
        this.matrix = matrix;
    }
}
