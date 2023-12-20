package com.learnwebflux.webfluxdemo.controller;

import com.learnwebflux.webfluxdemo.dto.Response;
import com.learnwebflux.webfluxdemo.exception.InputValidationException;
import com.learnwebflux.webfluxdemo.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("reactive-math")
public class ReactiveMathValidationController {

    @Autowired
    private ReactiveMathService reactiveMathService;

    @GetMapping("square/{input}")
    public Mono<Response> findSquareReactive(@PathVariable int input){

        if(input<10 || input>20)
            throw new InputValidationException(input);

        return reactiveMathService.findSquare(input);
    }



}
