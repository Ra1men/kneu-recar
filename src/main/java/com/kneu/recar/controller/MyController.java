package com.kneu.recar.controller;

import com.kneu.recar.entity.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class MyController {
    @GetMapping("/clients")

    public Flux<Client> getClients() {
        Flux<Client> clients = Flux.just(
                        new Client(1L, "Ihor", "Stefanishyn", 26, "67-753-45-84", "ihor.stef@gmail.com", "649139652"),
                        new Client(2L, "Olha", "Sytnyk", 32, "68-125-77-96", "olha.syt@gmail.com", "6343677895"),
                        new Client(3L, "Sergey", "Kovalev", 27,"93-763-23-56", "sergey.kov@gmail.com", "EP153567")
                )
                .skip(0)
                .take(3);

        return clients;
    }
}
