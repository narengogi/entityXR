package com.XR.nodeXR.repository;

import com.XR.nodeXR.model.History;
import com.XR.nodeXR.model.User;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.reactivestreams.Publisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.repository.query.FluentQuery;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public interface HistoryRepository extends ReactiveNeo4jRepository<History, String> {
}
