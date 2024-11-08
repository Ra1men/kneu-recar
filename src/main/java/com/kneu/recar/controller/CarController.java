package com.kneu.recar.controller;

import com.kneu.recar.entity.Car;
import com.kneu.recar.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})

public class CarController {

    public final CarService carService;

    @GetMapping("/get_all")
    public Flux<Car> listCars() {
        return carService.listCars();
    }

    @GetMapping("/find_by_id/{id}")
    public Mono<ResponseEntity<Car>> getCar(@PathVariable("id") Long id) {
        return carService.findCarById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Mono<Car> addNewCar(@RequestBody Car car) {
        return carService.addNewCar(car);
    }

    @PutMapping("/update_by_id/{id}")
    public Mono<ResponseEntity<Car>> updateCar(@PathVariable("id") Long id, @RequestBody Car car) {
        return carService.updateCar(id, car)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete_by_id/{id}")
    public Mono<ResponseEntity<Void>> deleteCar(@PathVariable("id") Long id) {
        return carService.findCarById(id)
                .flatMap(s ->
                        carService.deleteCar(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
