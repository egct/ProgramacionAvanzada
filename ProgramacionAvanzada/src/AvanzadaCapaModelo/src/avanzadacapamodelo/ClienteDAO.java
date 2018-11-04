/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avanzadacapamodelo;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Santi
 */
public class ClienteDAO {
    
    public void InsertarClientes(ClienteVO cliente) {
        //Primero creamos la conexion
     Conexion conex=new Conexion();
       try {
           Statement orden=conex.getConexion().createStatement();
           orden.executeUpdate("INSERT INTO cliente (nombre,apellido,usuario,contraseña) VALUES( "
                   +cliente.getNombre()+","
                   +cliente.getApellido()+","
                   +cliente.getUsuario()+","
                   +cliente.getContraseña()+")");
           JOptionPane.showMessageDialog(null, "Se ha registrado el nuevo cliente");
           orden.close();
           conex.desconectar();
            } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
   }
}
