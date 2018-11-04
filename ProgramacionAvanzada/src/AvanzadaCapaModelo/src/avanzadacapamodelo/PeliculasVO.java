/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avanzadacapamodelo;

import java.util.Date;

/**
 *
 * @author Santi
 */
public class PeliculasVO {
    private int cod_pelicula;
    private int cod_cliente;
    private float precio;

    public PeliculasVO() {
    }

    
    public PeliculasVO(int cod_pelicula, int cod_cliente, float precio) {
        this.cod_pelicula = cod_pelicula;
        this.cod_cliente = cod_cliente;
        this.precio = precio;
    }

    public int getCod_pelicula() {
        return cod_pelicula;
    }

    public void setCod_pelicula(int cod_pelicula) {
        this.cod_pelicula = cod_pelicula;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "PeliculasVO{" + "cod_pelicula=" + cod_pelicula + ", cod_cliente=" + cod_cliente + ", precio=" + precio + '}';
    }
    
    
}
