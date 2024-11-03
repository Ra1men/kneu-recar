package com.kneu.recar.controller;

import com.kneu.recar.entity.Message;
import com.kneu.recar.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/controller")
@RequiredArgsConstructor(onConstructor_ = @Autowired)

public class MainController {

    public final MessageService messageService;

    @GetMapping
    public Flux<Message> list(
        @RequestParam(defaultValue = "0") Long start,
        @RequestParam(defaultValue = "3") Long count) {
        return messageService.list();
    }

    @PostMapping
    public Mono<Message> create(@RequestBody Message message) {
        return messageService.addOne(message);
    }
}
