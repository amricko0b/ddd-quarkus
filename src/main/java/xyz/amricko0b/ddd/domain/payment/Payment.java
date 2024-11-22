package xyz.amricko0b.ddd.domain.payment;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

@Entity
@Getter
@AggregateRoot
@RequiredArgsConstructor
public class Payment {

  @NonNull private PaymentAccount debitAccount;
  @NonNull private PaymentAccount creditAccount;
  @NonNull private BigDecimal sum;

  @Identity private Long id;
}
