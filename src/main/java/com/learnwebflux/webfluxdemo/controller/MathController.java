package com.learnwebflux.webfluxdemo.controller;

import com.learnwebflux.webfluxdemo.dto.MultiplyRequestDto;
import com.learnwebflux.webfluxdemo.dto.Response;
import com.learnwebflux.webfluxdemo.service.MathService;
import com.learnwebflux.webfluxdemo.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("math")
public class MathController {

    @Autowired
    private MathService mathService;

    @Autowired
    private ReactiveMathService reactiveMathService;

    @GetMapping("square/{input}")
    public Response findSquare(@PathVariable int input){
       return mathService.findSquare(input);
    }
    @GetMapping("table/{input}")
    public List<Response> multiplicationTable(@PathVariable int input){
        return mathService.multiplicationTable(input);
    }

    @GetMapping("reactive/square/{input}")
    public Mono<Response> findSquareReactive(@PathVariable int input){
        return reactiveMathService.findSquare(input);
    }
    @GetMapping("reactive/table/{input}")
    public Flux<Response> multiplicationTableReactive(@PathVariable int input){
        return reactiveMathService.table(input);
    }
    @GetMapping(value = "reactive/table/{input}/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> multiplicationTableReactiveStream(@PathVariable int input){
        return reactiveMathService.table(input);
    }
    @PostMapping("multiply")
    public Mono<Response> multiply(@RequestBody Mono<MultiplyRequestDto> dto,@RequestHeader Map<String,String> headers){
       System.out.println(headers);
      return this.reactiveMathService.multiply(dto);
    }

}
