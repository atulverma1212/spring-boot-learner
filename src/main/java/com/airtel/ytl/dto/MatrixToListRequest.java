package com.airtel.ytl.dto;

import java.util.List;

public class MatrixToListRequest {

    private List<List<Integer>> matrix;

    public List<List<Integer>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Integer>> matrix) {
        this.matrix = matrix;
    }
}
