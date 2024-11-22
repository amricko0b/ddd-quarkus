package xyz.amricko0b.ddd.infra.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.amricko0b.ddd.app.repository.PaymentRepository;
import xyz.amricko0b.ddd.domain.payment.Payment;
import xyz.amricko0b.ddd.domain.payment.PaymentAccount;
import xyz.amricko0b.ddd.infra.repository.mapper.JpaAccountMapper;
import xyz.amricko0b.ddd.infra.repository.mapper.JpaPaymentMapper;
import xyz.amricko0b.ddd.infra.repository.ops.JpaAccountOps;
import xyz.amricko0b.ddd.infra.repository.ops.JpaPaymentOps;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class PaymentRepositoryImpl implements PaymentRepository {

  private final JpaAccountMapper accountMapper;
  private final JpaPaymentMapper paymentMapper;

  private final JpaAccountOps accountOps;
  private final JpaPaymentOps paymentOps;

  @Override
  @Transactional
  public Payment add(Payment aggregate) {

    // Yes, a chance of deadlock.
    // Tell them you didn't see anything...
    accountOps.update(
        "balance = ?1 where number = ?2",
        aggregate.getCreditAccount().balance(),
        aggregate.getCreditAccount().number());
    accountOps.update(
        "balance = ?1 where number = ?2",
        aggregate.getDebitAccount().balance(),
        aggregate.getDebitAccount().number());

    var payment = paymentMapper.mapToJpa(aggregate);
    paymentOps.persist(payment);

    return paymentMapper.mapToDomain(payment);
  }

  @Override
  public PaymentAccount getAccount(String number) {
    return paymentMapper.mapToDomain(accountOps.findById(number));
  }
}
