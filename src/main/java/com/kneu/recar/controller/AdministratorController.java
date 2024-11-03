package com.kneu.recar.controller;

import com.kneu.recar.entity.Administrator;
import com.kneu.recar.service.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/administrators")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})

public class AdministratorController {

    public final AdministratorService administratorService;

    @GetMapping("/get_all")
    public Flux<Administrator> listAdministrators() {
        return administratorService.listAdministrators();
    }

    @GetMapping("/find_by_id/{id}")
    public Mono<Administrator> findAdministratorsById(@PathVariable("id") Long id) {
        return administratorService.findAdministratorById(id);
    }

    @PostMapping("/create")
    public Mono<Administrator> addNewAdministrators(@RequestBody Administrator administrator) {
        return administratorService.addNewAdministrator(administrator);
    }

    @PutMapping("/update_by_id/{id}")
    public Mono<ResponseEntity<Administrator>> updateAdministrator(@PathVariable("id") Long id, @RequestBody Administrator administrator) {
        return administratorService.updateAdministrator(id, administrator)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete_by_id/{id}")
    public Mono<ResponseEntity<Void>> deleteAdministrator(@PathVariable("id") Long id) {
        return administratorService.findAdministratorById(id)
                .flatMap(s ->
                        administratorService.deleteAdministrator(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
