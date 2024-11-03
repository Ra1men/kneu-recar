package com.kneu.recar.repository;

import com.kneu.recar.entity.Car;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CarRepository extends ReactiveCrudRepository<Car, Long> {
}
