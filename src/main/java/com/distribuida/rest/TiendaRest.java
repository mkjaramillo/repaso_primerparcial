package com.distribuida.rest;

import com.distribuida.dao.TiendaDao;
import com.distribuida.repo.LaptoRepository;
import com.distribuida.repo.TiendaRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/tienda")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class TiendaRest {
    @Inject
    TiendaRepository repo;
    @GET
    @Path("/{marca}")
    public List<TiendaDao> findTienda(@PathParam("marca") String marca) {
        return repo.findByMarcaCache(marca);
    }
}
