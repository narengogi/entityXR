package com.XR.nodeXR.repository;

import com.XR.nodeXR.model.User;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface UserRepository extends ReactiveNeo4jRepository<User, String> {
    Mono<User> findOneByUserName(String userName);
}
