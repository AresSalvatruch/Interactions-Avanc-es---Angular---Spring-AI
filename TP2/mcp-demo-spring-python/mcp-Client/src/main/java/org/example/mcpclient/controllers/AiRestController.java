package org.example.mcpclient.controllers;

import org.example.mcpclient.agents.AIAgent;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class AiRestController {
    private AIAgent agent;

    public AiRestController(AIAgent agent) {
        this.agent = agent;
    }
    @GetMapping("/chat")
    public String askAgent(String query) {
        return agent.askLLM(query);
    }
}
