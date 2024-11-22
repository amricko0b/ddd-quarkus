package xyz.amricko0b.ddd.infra.repository.ops;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import xyz.amricko0b.ddd.infra.jpa.JpaAccount;
import xyz.amricko0b.ddd.infra.jpa.JpaPayment;

@ApplicationScoped
public class JpaPaymentOps implements PanacheRepository<JpaPayment> {}
