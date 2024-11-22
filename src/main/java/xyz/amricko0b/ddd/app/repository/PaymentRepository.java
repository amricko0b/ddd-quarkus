package xyz.amricko0b.ddd.app.repository;

import org.jmolecules.ddd.annotation.Repository;
import xyz.amricko0b.ddd.domain.payment.Payment;
import xyz.amricko0b.ddd.domain.payment.PaymentAccount;

@Repository
public interface PaymentRepository {
  Payment add(Payment payment);

  PaymentAccount getAccount(String number);
}
