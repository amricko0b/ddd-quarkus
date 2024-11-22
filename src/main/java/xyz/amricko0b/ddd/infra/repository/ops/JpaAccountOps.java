package xyz.amricko0b.ddd.infra.repository.ops;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import xyz.amricko0b.ddd.infra.jpa.JpaAccount;

@ApplicationScoped
public class JpaAccountOps implements PanacheRepositoryBase<JpaAccount, String> {}
