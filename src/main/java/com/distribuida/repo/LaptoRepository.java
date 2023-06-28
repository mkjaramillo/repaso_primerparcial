package com.distribuida.repo;

import com.distribuida.db.Lapto;
import io.quarkus.hibernate.orm.PersistenceUnit;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class LaptoRepository implements PanacheRepositoryBase<Lapto,Long> {
    @Inject
    EntityManager entityManager;

}
