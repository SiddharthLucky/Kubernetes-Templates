package com.secrets.vaultcaller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;

import reactor.core.publisher.Mono;

@Service
public class VaultService {
    
    @Autowired
    private WebClient webClient;

    public Mono<String> getSecret() {
        return webClient
                .get()
                .uri("/v1/secret/data/sample")
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(jsonNode -> jsonNode.path("data").path("data").path("base-secret").asText());
    }

    
}
