package xyz.amricko0b.ddd.infra.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Payment")
@Table(name = "payment")
public class JpaPayment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "debit_account_id", nullable = false)
  private JpaAccount debitAccount;

  @ManyToOne
  @JoinColumn(name = "credit_account_id", nullable = false)
  private JpaAccount creditAccount;

  @Column(nullable = false)
  private BigDecimal sum;
}
