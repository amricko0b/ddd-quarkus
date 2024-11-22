package xyz.amricko0b.ddd.domain.account;

import java.math.BigDecimal;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

@Entity
@AggregateRoot
@RequiredArgsConstructor
public class Account {

  @NonNull @Identity private String accountNumber;

  @NonNull private BigDecimal balance;
}
