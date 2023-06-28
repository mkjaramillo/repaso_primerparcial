package com.distribuida.rest;

import com.distribuida.db.tienda.Computadora;
import com.distribuida.repo.ComputadoraRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/computadoras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class ComputadoraRest {
    @Inject
    ComputadoraRepository repo;

    @POST
    //@Path("/crear")

    public Response crearComputadora(Computadora computadora) {

        repo.persist(computadora);
        return Response.status(Response.Status.CREATED)
                .entity("computadora creada exitosamente")
                .build();
    }

}
