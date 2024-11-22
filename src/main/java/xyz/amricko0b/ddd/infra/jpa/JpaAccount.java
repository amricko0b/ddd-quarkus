package xyz.amricko0b.ddd.infra.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Account")
@Table(name = "account")
public class JpaAccount {

  @Id
  @Column(updatable = false)
  private String number;

  @Column(name = "balance", nullable = false)
  private BigDecimal balance;
}
