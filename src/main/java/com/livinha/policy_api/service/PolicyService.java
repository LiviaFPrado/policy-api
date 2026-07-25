package com.livinha.policy_api.service;

import com.livinha.policy_api.model.Policy;
import com.livinha.policy_api.model.PolicyStatus;
import com.livinha.policy_api.repository.PolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PolicyService {

    private final PolicyRepository repository;


    public Policy create(Policy policy) {
        policy.setCreatedAt(LocalDateTime.now());
        policy.setStatus(PolicyStatus.ACTIVE);

        return repository.save(policy);
    }

    public List<Policy> findAll() {
        return repository.findAll();
    }

    public Policy findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Policy not found with id: " + id
                ));
    }

    public Policy update(Long id, Policy updatedPolicy) {
        Policy existingPolicy = findById(id);

        existingPolicy.setPolicyNumber(updatedPolicy.getPolicyNumber());
        existingPolicy.setCustomerName(updatedPolicy.getCustomerName());

        return repository.save(existingPolicy);
    }

    public Policy cancel(Long id) {
        Policy existingPolicy = findById(id);

        existingPolicy.setStatus(PolicyStatus.CANCELLED);

        return repository.save(existingPolicy);
    }


}
