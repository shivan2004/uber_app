package com.shivan.project.uber.uberApp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.DETACH)
    private User user;

    private Double balance = 0.0;

    @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY)
    private List<WalletTransaction> transactions;

}
