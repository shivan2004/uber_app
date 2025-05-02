package com.shivan.project.uber.uberApp.strategies.impl.payment;

import com.shivan.project.uber.uberApp.entities.Driver;
import com.shivan.project.uber.uberApp.entities.Payment;
import com.shivan.project.uber.uberApp.entities.Rider;
import com.shivan.project.uber.uberApp.entities.enums.PaymentStatus;
import com.shivan.project.uber.uberApp.entities.enums.TransactionMethod;
import com.shivan.project.uber.uberApp.repositories.PaymentRepository;
import com.shivan.project.uber.uberApp.services.PaymentService;
import com.shivan.project.uber.uberApp.services.WalletService;
import com.shivan.project.uber.uberApp.strategies.PaymentStrategy;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;


    @Override
    @Transactional
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(), payment.getAmount(), null, payment.getRide(), TransactionMethod.RIDE);

        double driversCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);

        walletService.addMoneyToWallet(driver.getUser(), driversCut, null, payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);

    }
}
