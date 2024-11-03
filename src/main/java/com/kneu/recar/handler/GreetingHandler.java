package com.kneu.recar.handler;

import com.kneu.recar.entity.Client;
import com.kneu.recar.entity.Greeting;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {
    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello, Spring")));
    }

    public Mono<ServerResponse> home(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Main page!"));
    }
//
//    public Mono<ServerResponse> getClients(ServerRequest request) {
//        String start = request
//                .queryParam("start")
//                .orElse("0");
//
//        Flux<Client> clients = Flux.just(
//                new Client(1L, "Ihor", "Stefanishyn", 26, "67-753-45-84", "ihor.stef@gmail.com", "649139652"),
//                new Client(2L, "Olha", "Sytnyk", 32, "68-125-77-96", "olha.syt@gmail.com", "6343677895"),
//                new Client(3L, "Sergey", "Kovalev", 27,"93-763-23-56", "sergey.kov@gmail.com", "EP153567")
//                )
//                    .skip(Long.valueOf(start))
//                    .take(3);
//
//        return ServerResponse
//                .ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(clients, Client.class);
//    }
}
