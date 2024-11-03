package com.kneu.recar.service;

import com.kneu.recar.entity.Administrator;
import com.kneu.recar.repository.AdministratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class AdministratorService {

    public final AdministratorRepository administratorRepository;

    public Flux<Administrator> listAdministrators() {
        return administratorRepository.findAll();
    }

    public Mono<Administrator> findAdministratorById(Long id) {
        return administratorRepository.findById(id);
    }

    public Mono<Administrator> addNewAdministrator(Administrator administrator){
        administrator.setId(null);
        return administratorRepository.save(administrator);
    }

    public Mono<Administrator> updateAdministrator(Long id, Administrator administrator) {
        return administratorRepository.findById(id).
                flatMap(s -> {
                    administrator.setId(s.getId());
                    return administratorRepository.save(administrator);
                });
    }

    public Mono<Void> deleteAdministrator(Administrator administrator) {
        return administratorRepository.delete(administrator);
    }
}
