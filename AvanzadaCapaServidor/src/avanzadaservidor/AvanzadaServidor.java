/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avanzadaservidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import avanzadacapanegocio.*;
import java.net.MalformedURLException;

/**
 *
 * @author EDWIN
 */
public class AvanzadaServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException,MalformedURLException {
        // TODO code application logic here
         Registry reg = LocateRegistry.createRegistry(1099);
        reg.rebind("ServerReservas",(InGestor) Gestor.getGestor());
        System.out.println("Servidor ON");
        System.out.println("Atendiendo las peticiones...");
        System.out.println("Pulse Enter para salir...");

        
    }
    
}
