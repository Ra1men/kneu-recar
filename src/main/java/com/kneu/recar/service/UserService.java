package com.kneu.recar.service;

import com.kneu.recar.entity.User;
import com.kneu.recar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class UserService implements ReactiveUserDetailsService {

    private final UserRepository userRepository;

    public Mono<User> findUserById(Long id){
        return userRepository.findById(id);
    }

    public Mono<User> addNewUser(User user) {
        return userRepository
                .save(user)
                .cast(User.class);
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .cast(UserDetails.class);
    }
}
