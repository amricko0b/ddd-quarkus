package xyz.amricko0b.ddd.domain.payment;

import java.math.BigDecimal;
import org.jmolecules.ddd.annotation.Association;
import org.jmolecules.ddd.annotation.ValueObject;
import xyz.amricko0b.ddd.domain.account.Account;

@ValueObject
public record PaymentAccount(
    @Association(aggregateType = Account.class) String number, BigDecimal balance) {}
