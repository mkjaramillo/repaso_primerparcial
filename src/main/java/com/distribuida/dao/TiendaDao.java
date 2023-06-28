package com.distribuida.dao;

import com.distribuida.db.almacen.Lapto;
import com.distribuida.db.tienda.Computadora;

import java.util.List;

public class TiendaDao {

    private String marca;
    private Double precio;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public TiendaDao(String marca, Double precio) {
        this.marca = marca;
        this.precio = precio;
    }

    public TiendaDao() {
    }
}
