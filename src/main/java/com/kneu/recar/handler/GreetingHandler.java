package com.kneu.recar.handler;

import com.kneu.recar.entity.Client;
import com.kneu.recar.entity.User;
import com.kneu.recar.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
public class GreetingHandler {
    private final UserService userService;

    public GreetingHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromValue("Hello from the recar service!"));
    }

    public Mono<ServerResponse> home(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(fromValue("Main page of recar service!"));
    }
    public Mono<ServerResponse> users(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromValue("Recar service user page"));
    }

    public Mono<ServerResponse> admin(ServerRequest request) {

        Flux<Client> clients = Flux.just(
                new Client(1L, "Ihor", "Stefanishyn", 26, "67-753-45-84", "ihor.stef@gmail.com", "649139652"),
                new Client(2L, "Olha", "Sytnyk", 32, "68-125-77-96", "olha.syt@gmail.com", "6343677895"),
                new Client(3L, "Sergey", "Kovalev", 27,"93-763-23-56", "sergey.kov@gmail.com", "EP153567")
                );

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(clients, Client.class);
    }

    public Mono<ServerResponse> registration(ServerRequest request) {
        return ServerResponse
                .ok()
                .render("registration");
    }

    public Mono<ServerResponse> findUserById(ServerRequest request) {
        Mono<User> userMono = userService.findUserById(
                Long.parseLong(request.pathVariable("id")));
        return userMono.flatMap(users -> ServerResponse.ok()
                        .body(fromValue(users)))
                        .switchIfEmpty(ServerResponse.notFound().build());
    }
}
