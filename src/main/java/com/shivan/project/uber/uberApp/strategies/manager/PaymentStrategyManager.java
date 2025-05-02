package com.shivan.project.uber.uberApp.strategies.manager;

import com.shivan.project.uber.uberApp.entities.enums.PaymentMethod;
import com.shivan.project.uber.uberApp.strategies.PaymentStrategy;
import com.shivan.project.uber.uberApp.strategies.impl.payment.CashPaymentStrategy;
import com.shivan.project.uber.uberApp.strategies.impl.payment.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {

    private final WalletPaymentStrategy walletPaymentStrategy;
    private final CashPaymentStrategy cashPaymentStrategy;

    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod) {
        return switch (paymentMethod) {
            case WALLET -> walletPaymentStrategy;
            case CASH -> cashPaymentStrategy;
            default -> throw new RuntimeException("Invalid Payment method");
        };
    }

}
