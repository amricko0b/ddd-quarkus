package xyz.amricko0b.ddd.infra.command;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import xyz.amricko0b.ddd.app.ProcessPayment;
import xyz.amricko0b.ddd.app.ProcessPaymentHandler;
import xyz.amricko0b.ddd.app.repository.PaymentRepository;

@ApplicationScoped
public class CdiProcessPaymentHandler extends ProcessPaymentHandler {

  @Inject
  public CdiProcessPaymentHandler(@NonNull PaymentRepository transactions) {
    super(transactions);
  }

  @Override
  @Transactional
  public void handle(ProcessPayment command) {
    super.handle(command);
  }
}
