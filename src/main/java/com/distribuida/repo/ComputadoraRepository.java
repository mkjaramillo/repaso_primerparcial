package com.distribuida.repo;

import com.distribuida.db.Computadora;
import io.quarkus.hibernate.orm.PersistenceUnit;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class ComputadoraRepository implements PanacheRepositoryBase<Computadora,Long> {
    @Inject
    @PersistenceUnit("computadora")
    EntityManager entityManager;
}
