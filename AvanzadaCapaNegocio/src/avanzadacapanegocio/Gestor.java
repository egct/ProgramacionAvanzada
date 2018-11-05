/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avanzadacapanegocio;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import avanzadacapamodelo.*;

/**
 *
 * @author Santi
 */
public class Gestor extends UnicastRemoteObject implements Serializable,InGestor{
    ReservarAsientoDAO opReserva=new ReservarAsientoDAO();
    
    public static Gestor gesReserva;
    public Gestor() throws RemoteException{
      
    }
    public  static Gestor getGestor() throws RemoteException {
        if (gesReserva == null) {
            gesReserva = new Gestor();
        }

        return gesReserva;
    }

    @Override
    public void reservar(ReservarAsientoVO reserva) {
        opReserva.InsertarReserva(reserva);
    }

    @Override
    public List actualizar(int cod_pelicula) throws RemoteException {
        return opReserva.obtenerAsientosOcupados(cod_pelicula);
    }

    @Override
    public List obtenerPeliculas() throws RemoteException {
        PeliculasDAO vuelos=new PeliculasDAO();
     return vuelos.obtenerpeliculas();
     
    }

    @Override
    public List obtenerClientes() throws RemoteException {
        return null;
        
    }
}
