package com.livinha.policy_api.controller;

import com.livinha.policy_api.model.Policy;
import com.livinha.policy_api.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
@RequiredArgsConstructor
public class PolicyController {

    private final PolicyService service;

    @GetMapping
    public List<Policy> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Policy findById(@PathVariable Long id) {
        return service.findById(id);

    }

    @PostMapping
    public Policy create(@RequestBody Policy policy) {
        return service.create(policy);
    }

    @PutMapping("/{id}")
    public Policy uptade(
            @PathVariable Long id,
            @RequestBody Policy policy
    ) {
        return service.update(id, policy);
    }

    @PatchMapping("/{id}/cancel")
    public Policy cancel(@PathVariable Long id) {
        return service.cancel(id);
    }



}
