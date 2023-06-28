package com.distribuida.repo;

import com.distribuida.db.tienda.Computadora;
import io.quarkus.hibernate.orm.PersistenceUnit;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
@ApplicationScoped
public class ComputadoraRepository implements PanacheRepositoryBase<Computadora,Long> {
    @Inject
    @PersistenceUnit("computadora")
    EntityManager entityManager;
    public List<Computadora> listComputadoras(String marca){
        TypedQuery<Computadora> qry=entityManager.createQuery("select o from Computadora o where o.marca=:marcaParam", Computadora.class);
        qry.setParameter("marcaParam", marca);

        return  qry.getResultList();

    }
}
