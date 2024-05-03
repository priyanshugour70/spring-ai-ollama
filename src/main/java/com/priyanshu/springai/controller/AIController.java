package com.priyanshu.springai.controller;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AIController {

    private OllamaChatClient client;

    public static final String prompt = "what is Java Language?";

    public AIController(OllamaChatClient client) {
        this.client = client;
    }

    @GetMapping("/prompt")
    public Flux<String> promptResponse(
            @RequestParam("prompt") String prompt
    ) {
        Flux<String> response = client.stream(prompt);
        return response;
    }
}
