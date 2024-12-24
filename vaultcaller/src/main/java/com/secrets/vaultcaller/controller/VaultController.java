package com.secrets.vaultcaller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secrets.vaultcaller.service.VaultService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class VaultController {

    @Autowired
    private VaultService vaultService;

    @GetMapping("/secret")
    public Mono<String> getSecret() {
        return vaultService.getSecret();
    }
}