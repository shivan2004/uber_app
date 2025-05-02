package com.shivan.project.uber.uberApp.dto;

import com.shivan.project.uber.uberApp.entities.enums.TransactionMethod;
import com.shivan.project.uber.uberApp.entities.enums.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class WalletTransactionDTO {

    private Long id;

    private Double amount;

    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    private RideDTO ride;

    private String transactionId;

    private LocalDateTime timeStamp;


    private WalletDTO wallet;

}
