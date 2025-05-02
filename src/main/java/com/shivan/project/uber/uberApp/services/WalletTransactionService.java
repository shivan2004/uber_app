package com.shivan.project.uber.uberApp.services;

import com.shivan.project.uber.uberApp.dto.WalletTransactionDTO;
import com.shivan.project.uber.uberApp.entities.WalletTransaction;

public interface WalletTransactionService {

    void createNewWalletTransaction(WalletTransaction walletTransaction);
}
