/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avanzadacapamodelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Santi
 */
public class ReservarAsientoDAO {
    
    public void InsertarReserva(ReservarAsientoVO reserva) {
        //Primero creamos la conexion
     Conexion conex=new Conexion();
       try {
           Statement orden=conex.getConexion().createStatement();
           orden.executeUpdate("INSERT INTO reserva (cod_reserva,numero_asiento,cod_cliente,cod_pelicula) VALUES("
                   +obtenerCodigoReserva()+","
                   +reserva.getNumero_asiento()+","
                    +reserva.getCod_cliente()+","
                     + reserva.getCod_pelicula()+")");
           JOptionPane.showMessageDialog(null, "Se ha registrado la reserva de asiento");
           orden.close();
           conex.desconectar();
            } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
   }
    public  int obtenerCodigoReserva(){
        
          List<Integer>codigos=obtenerCodigos();
           Collections.sort(codigos,Collections.reverseOrder() );
           System.out.println(codigos.get(0));
          return (codigos.get(0)+1);
        
    }
    public List obtenerAsientosOcupados(int cod_pelicula){
        Conexion conex=new Conexion();
           List<Integer>asientosOcupados=new ArrayList<>();
               
        try {
            java.sql.Statement stmt = conex.getConexion().createStatement();      
            ResultSet rs = stmt.executeQuery("SELECT numero_asiento from reserva where cod_pelicula="+cod_pelicula);                     
            while (rs.next()) {                         
                 asientosOcupados.add(rs.getInt(1));        
            }
            rs.close();                        
            stmt.close();                           
            conex.desconectar();
            return asientosOcupados;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public List obtenerCodigos(){
        Conexion conex=new Conexion();
           List<Integer>codigos=new ArrayList<>();
               
        try {
            java.sql.Statement stmt = conex.getConexion().createStatement();      
            ResultSet rs = stmt.executeQuery("SELECT cod_reserva from reserva");                     
            while (rs.next()) {                         
                 codigos.add(rs.getInt(1));        
            }
            rs.close();                        
            stmt.close();                           
            conex.desconectar();
            return codigos;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
