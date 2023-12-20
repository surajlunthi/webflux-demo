package com.learnwebflux.webfluxdemo.dto;

import lombok.Data;

import java.util.Date;

@Data

public class Response {
    private Date data = new Date();
    private int output;

    public Response(int output){
        this.output = output;
    }
}
