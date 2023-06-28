package com.distribuida.repo;

import com.distribuida.db.almacen.Lapto;
import com.distribuida.db.tienda.Computadora;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
@ApplicationScoped
public class LaptoRepository implements PanacheRepositoryBase<Lapto,Long> {
    @Inject
    EntityManager entityManager;
    public List<Lapto> listLapto(String marca){
        TypedQuery<Lapto> qry=entityManager.createQuery("select o from Lapto o where o.marca=:marcaParam", Lapto.class);
        qry.setParameter("marcaParam", marca);

        return  qry.getResultList();

    }

}
