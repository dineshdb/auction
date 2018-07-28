package com.sankalpa.auction.model;

public class StringResponse {

    private String response;

    public StringResponse(){}

    public StringResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        str.append("\"response\":");
        str.append("\"" + response + "\"");
        str.append("}");
        return str.toString();
    }
}
