package com.shivan.project.uber.uberApp.services.impl;

import com.shivan.project.uber.uberApp.dto.RideDTO;
import com.shivan.project.uber.uberApp.dto.WalletDTO;
import com.shivan.project.uber.uberApp.dto.WalletTransactionDTO;
import com.shivan.project.uber.uberApp.entities.Ride;
import com.shivan.project.uber.uberApp.entities.User;
import com.shivan.project.uber.uberApp.entities.Wallet;
import com.shivan.project.uber.uberApp.entities.WalletTransaction;
import com.shivan.project.uber.uberApp.entities.enums.TransactionMethod;
import com.shivan.project.uber.uberApp.entities.enums.TransactionType;
import com.shivan.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.shivan.project.uber.uberApp.repositories.WalletRepository;
import com.shivan.project.uber.uberApp.services.WalletService;
import com.shivan.project.uber.uberApp.services.WalletTransactionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final ModelMapper modelMapper;
    private final WalletTransactionService walletTransactionService;

    @Override
    @Transactional
    public Wallet addMoneyToWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod) {
        Wallet wallet = findWalletByUser(user);
        wallet.setBalance(wallet.getBalance() + amount);

        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactionMethod(transactionMethod)
                .transactionType(TransactionType.CREDIT)
                .build();

        walletTransactionService.createNewWalletTransaction(walletTransaction);

//        wallet.getTransactions().add(walletTransaction);

        return walletRepository.save(wallet);
    }

    @Override
    @Transactional
    public Wallet deductMoneyFromWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod) {
        log.info("Inside deduct money from wallet");
        Wallet wallet = findWalletByUser(user);
        wallet.setBalance(wallet.getBalance() - amount);

        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactionMethod(transactionMethod)
                .transactionType(TransactionType.DEBIT)
                .build();

        walletTransactionService.createNewWalletTransaction(walletTransaction);

//        wallet.getTransactions().add(walletTransaction);

        return walletRepository.save(wallet);

    }

    @Override
    public void withdrawAllMyMoneyFromWallet() {

    }

    @Override
    public Wallet findWalletById(Long walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found with id : " + walletId));
    }

    @Override
    public Wallet createNewWallet(User user) {
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet findWalletByUser(User user) {
        return walletRepository.findByUser(user)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found for user with id : " + user.getId()));
    }
}
