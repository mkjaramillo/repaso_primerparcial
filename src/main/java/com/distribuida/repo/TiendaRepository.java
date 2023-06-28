package com.distribuida.repo;

import com.distribuida.dao.TiendaDao;
import com.distribuida.db.almacen.Lapto;
import com.distribuida.db.tienda.Computadora;
import com.google.gson.Gson;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TiendaRepository {
    @Inject
    RedisClient redisClient;

    @Inject
    LaptoRepository laptoRepo;

    @Inject
    ComputadoraRepository computadoraRepo;

    public List<TiendaDao> findByMarcaCache(String marca){


        //validar coneccion
        try(StatefulRedisConnection<String, String> conn=redisClient.connect())
        {
            RedisCommands<String, String> syncCommands = conn.sync();
            String value = syncCommands.get(marca);

            var gson = new Gson();
            if (value != null) {
                System.out.println("Registro con marca encontrado en memoria");
                List<TiendaDao> lapoCompuCACHE = gson.fromJson(value,List.class);
                return lapoCompuCACHE;
                /*
                Persona ret = new Persona();
                ret.id  = id;
                ret.setName(value);

                String personaJSON = gson.toJson(ret);
                System.out.println("Registro con id encontrado en memoria");
                */
            }
            System.out.println("Registro con marca ese no encontrado en memoria");

            List<TiendaDao> laptoCompuDB= new ArrayList<>();
            List<Lapto>laptoLits=laptoRepo.listLapto(marca);
            List<Computadora>computadoraLits=computadoraRepo.listComputadoras(marca);
            System.out.println(laptoLits.size() +" "+ computadoraLits.size());
            laptoLits.stream().forEach(x->{
                laptoCompuDB.add(new TiendaDao(x.getMarca(),x.getPrecio()));
            });

            computadoraLits.stream().forEach(x->{
                laptoCompuDB.add(new TiendaDao(x.getMarca(),x.getPrecio()));
            });



            syncCommands.set(marca, gson.toJson(laptoCompuDB));


            return laptoCompuDB;

        } catch (Exception e){
            e.printStackTrace();

        }

        return null;
        //return this.findByIdOptional(id);
    }
}
