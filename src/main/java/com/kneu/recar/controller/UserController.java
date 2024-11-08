package com.kneu.recar.controller;

import com.kneu.recar.entity.RoleUser;
import com.kneu.recar.entity.User;
import com.kneu.recar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController {

    public final UserService userService;

    @GetMapping("/find_by_user_id/{id}")
    public Mono<ResponseEntity<User>> findByUserId(@PathVariable Long id) {
        return userService.findUserById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/registration")
    public Mono<User> addNewUser(@RequestBody User user) {
        user.setRole(RoleUser.ROLE_USER);
        return userService.addNewUser(user);
    }

}
