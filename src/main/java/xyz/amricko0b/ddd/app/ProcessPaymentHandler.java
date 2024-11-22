package xyz.amricko0b.ddd.app;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.cqrs.CommandHandler;
import xyz.amricko0b.ddd.app.repository.PaymentRepository;
import xyz.amricko0b.ddd.domain.payment.Payment;

/**
 * No Args Constructor here is an inevitable abstraction leakage due to Quarkus demands.
 */
@NoArgsConstructor
@RequiredArgsConstructor
public class ProcessPaymentHandler {

  @NonNull private PaymentRepository transactions;

  @CommandHandler(name = "transaction_process")
  public void handle(ProcessPayment command) {

    var debitAccount = transactions.getAccount(command.getDebitAccountNumber());
    var creditAccount = transactions.getAccount(command.getCreditAccountNumber());

    transactions.add(new Payment(debitAccount, creditAccount, command.getSum()));
  }
}
