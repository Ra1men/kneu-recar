package com.kneu.recar.service;

import com.kneu.recar.entity.Client;
import com.kneu.recar.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ClientService {

    public final ClientRepository clientRepository;

    public Flux<Client> list() {
        return clientRepository.findAll();
    }

    public Mono<Client> addNewClient(Client client) {
        client.setId(null);
        return clientRepository.save(client);
    }

    public Mono<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Mono<Client> updateClient(Long id, Client client) {
        return clientRepository.findById(id)
                .flatMap(s -> {
                    client.setId(s.getId());
                    return clientRepository.save(client);
                });
    }

    public Mono<Void> deleteClient(Client client) {
        return clientRepository.delete(client);
    }
}
