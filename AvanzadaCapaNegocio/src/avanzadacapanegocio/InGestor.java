/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avanzadacapanegocio;
 
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import avanzadacapamodelo.*;
/**
 *
 * @author Santi
 */
public interface InGestor extends Remote {
    public void reservar(ReservarAsientoVO reserva) throws RemoteException;
    public List actualizar(int cod_vuelo) throws RemoteException;
    public List obtenerPeliculas() throws RemoteException;
    public List obtenerClientes() throws RemoteException;

}
