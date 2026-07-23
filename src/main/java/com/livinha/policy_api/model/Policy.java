package com.livinha.policy_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;

    private String customerName;

    @Enumerated(EnumType.STRING)
    private PolicyStatus status;

    private LocalDateTime createdAt;


}
