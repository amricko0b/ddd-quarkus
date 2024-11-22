package xyz.amricko0b.ddd.infra.repository.mapper;

import org.mapstruct.Mapper;
import xyz.amricko0b.ddd.domain.payment.Payment;
import xyz.amricko0b.ddd.domain.payment.PaymentAccount;
import xyz.amricko0b.ddd.infra.jpa.JpaAccount;
import xyz.amricko0b.ddd.infra.jpa.JpaPayment;

@Mapper(componentModel = "jakarta-cdi")
public interface JpaPaymentMapper {

  JpaPayment mapToJpa(Payment entity);

  JpaAccount mapToJpa(PaymentAccount object);

  Payment mapToDomain(JpaPayment jpa);

  PaymentAccount mapToDomain(JpaAccount jpa);
}
