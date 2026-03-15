package com.startup.mvp.api;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.startup.mvp.entity.User;
import com.startup.mvp.repo.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://storage.googleapis.com"
})
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Flux<User> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Mono<User> getById(@PathVariable String id) {
        return repo.findById(id);
    }

    @PostMapping("/test")
    public Mono<String> test() {
        return Mono.just("Firestore connected ✅");
    }

    @PostMapping
    public Mono<User> save(@RequestBody User user) {
        return repo.save(user);
    }

}
