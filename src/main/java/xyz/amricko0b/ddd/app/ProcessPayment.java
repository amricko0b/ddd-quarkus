package xyz.amricko0b.ddd.app;

import java.math.BigDecimal;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.Command;

@Getter
@Command(name = "transaction_process")
public class ProcessPayment {

  private String debitAccountNumber;
  private String creditAccountNumber;

  private BigDecimal sum;
}
