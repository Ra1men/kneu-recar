package com.kneu.recar.controller;

import com.kneu.recar.entity.Client;
import com.kneu.recar.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})

public class ClientController {

    public final ClientService clientService;

    @GetMapping("/get_all")
    public Flux<Client> list() {
        return clientService.list();
    }

    @GetMapping("/find_by_id/{id}")
    public Mono<ResponseEntity<Client>> getClient(@PathVariable("id") Long id) {
        return clientService.findClientById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Mono<Client> addNewClient(@RequestBody Client client) {
        return clientService.addNewClient(client);
    }

    @PutMapping("/update_by_id/{id}")
    public Mono<ResponseEntity<Client>> updateClient(@PathVariable("id") Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete_by_id/{id}")
    public Mono<ResponseEntity<Void>> deleteClient(@PathVariable("id") Long id) {
        return clientService.findClientById(id)
                .flatMap(s ->
                        clientService.deleteClient(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

}
