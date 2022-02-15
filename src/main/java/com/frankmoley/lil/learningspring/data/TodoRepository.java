package com.frankmoley.lil.learningspring.data;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public class TodoRepository {
    private final WebClient webClient;

    public TodoRepository(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public String getTodos() {
        Todo todo = this.webClient.get()
                .uri("/todos/{id}", 1)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Todo.class)
                .block();
        System.out.println("Title: " + todo.getTitle());
        return todo.toString();
    }
}
