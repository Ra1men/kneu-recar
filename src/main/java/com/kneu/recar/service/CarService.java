package com.kneu.recar.service;

import com.kneu.recar.entity.Car;
import com.kneu.recar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CarService {

    private final CarRepository carRepository;

    public Flux<Car> listCars () {
        return carRepository.findAll();
    }

    public Mono<Car> addNewCar(Car car) {
        car.setId(null);
        return carRepository.save(car);
    }

    public Mono<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }

    public Mono<Car> updateCar(Long id, Car car) {
        return carRepository.findById(id).
                flatMap(s -> {
                    car.setId(s.getId());
                    return carRepository.save(car);
                });
    }

    public Mono<Void> deleteCar(Car car) {
        return carRepository.delete(car);
    }
}
