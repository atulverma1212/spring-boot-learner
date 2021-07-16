package com.airtel.ytl.dto;


/**
 * pojo class for Health response
 */
public class HealthResponse {

    private String response;

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String response) {
        System.out.println("Setting response to : " + response);
        this.response = response;
    }

}


