package com.kneu.recar.repository;

import com.kneu.recar.entity.Administrator;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AdministratorRepository extends ReactiveCrudRepository<Administrator, Long> {
}
