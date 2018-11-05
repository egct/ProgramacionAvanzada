/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import avanzadacapanegocio.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Mela
 */
public class HiloActualizarAsientos extends Thread{
    int cod_pelicula;

    public HiloActualizarAsientos(int cod_vuelo) {
        this.cod_pelicula = cod_vuelo;
    }
    
    @Override
    public void run(){
        try {
            Registry registro = LocateRegistry.getRegistry();
            InGestor gestor= (InGestor) registro.lookup("ServerReservas");
            gestor.actualizar(cod_pelicula);
           
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getCod_vuelo() {
        return cod_pelicula;
    }

    public void setCod_vuelo(int cod_peli) {
        this.cod_pelicula = cod_peli;
    }
    
    
}
