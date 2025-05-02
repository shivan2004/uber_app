package com.shivan.project.uber.uberApp.dto;

import com.shivan.project.uber.uberApp.entities.User;
import lombok.Data;


import java.util.List;
@Data
public class WalletDTO {

    private Long id;

    private User user;

    private Double balance;

    private List<WalletTransactionDTO> transactions;

}
