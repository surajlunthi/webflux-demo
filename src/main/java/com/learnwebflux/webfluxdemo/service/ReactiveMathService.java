package com.learnwebflux.webfluxdemo.service;

import com.learnwebflux.webfluxdemo.dto.MultiplyRequestDto;
import com.learnwebflux.webfluxdemo.dto.Response;
import com.learnwebflux.webfluxdemo.util.SleepUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ReactiveMathService {
    public Mono<Response> findSquare(int input){
        return Mono.fromSupplier(()->input*input).map(Response::new);
    }

    public Flux<Response> table(int input){
        return Flux.range(1,10)
                .doOnNext(i-> SleepUtil.sleep(1 ))
                .doOnNext(i->System.out.println("Reactive processing "+i))
                .map(i->new Response(i*input));
    }

    public Mono<Response> multiply(Mono<MultiplyRequestDto> dtoMono){
        return dtoMono
                .map(dto->dto.getFirst()*dto.getSecond())
                .map(Response::new);
    }
}
