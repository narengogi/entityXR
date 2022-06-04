package com.XR.nodeXR.controller;

import com.XR.nodeXR.model.User;
import com.XR.nodeXR.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/test")
    boolean testApi() {
        return true;
    }

    @PutMapping
    Mono<User> createUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping(value = {"","/", "/getAll"}, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<User> getPeople() {
        return userRepository.findAll();
    }

    @DeleteMapping("/{id}")
    Mono<Void> deleteUser(@PathVariable String id) {
        return userRepository.deleteById(id);
    }
}
