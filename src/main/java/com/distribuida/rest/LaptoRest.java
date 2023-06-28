package com.distribuida.rest;

import com.distribuida.db.almacen.Lapto;
import com.distribuida.db.tienda.Computadora;
import com.distribuida.repo.ComputadoraRepository;
import com.distribuida.repo.LaptoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/laptos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class LaptoRest {
    @Inject
    LaptoRepository repo;
    @POST
    public Response crearLapto(Lapto lapto) {

        repo.persist(lapto);
        return Response.status(Response.Status.CREATED)
                .entity("lapto creada exitosamente")
                .build();
    }

}
