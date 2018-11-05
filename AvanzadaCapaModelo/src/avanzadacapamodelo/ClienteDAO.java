/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avanzadacapamodelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Santi
 */
public class ClienteDAO {
    Conexion conex=new Conexion();
    Connection con;
    PreparedStatement pst=null;     // sentencias sql precompiladas FRAMEWORK JAVA
    ResultSet rs=null; 
    
    public void InsertarClientes(ClienteVO cliente) {
        //Primero creamos la conexion
   //  Conexion conex=new Conexion();
       try {
           Statement orden=conex.getConexion().createStatement();
           orden.executeUpdate("INSERT INTO cliente (nombre,apellido,usuario,contraseña,cod_cliente) VALUES( '"
                   +cliente.getNombre()+"','"
                   +cliente.getApellido()+"','"
                   +cliente.getUsuario()+"','"
                   +cliente.getContraseña()+"',NULL)");
           JOptionPane.showMessageDialog(null, "Se ha registrado el nuevo cliente");
           orden.close();
           conex.desconectar();
            } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
   }
    
    public boolean buscarPersona(ClienteVO Vo){
            int bandera=-1;
            String cadena;
            try{
                    //nombre q pondremos enla tabla
                cadena="SELECT * FROM cliente WHERE '"+Vo.getUsuario()+"' LIKE USUARIO AND '"+Vo.getContraseña()+"' LIKE CONTRASEÑA"; //CONTROL C, CARGA TODO DE LA BASE D EDATOS
                con=conex.getConexion();
                pst=con.prepareStatement(cadena);
                rs=pst.executeQuery(cadena); //CARGADO EN LA MEMORIA RAM
                
                while(rs.next()) { //RECOORE LA BASE DE DATOS cada registro=persona
                    bandera=Integer.parseInt(rs.getString("cod_cliente"));
                }
                rs.close();
            } catch(SQLException exsql) {
                JOptionPane.showMessageDialog(null,exsql.getMessage(),"mensaje>>",JOptionPane.ERROR_MESSAGE);
            }
                if(bandera==-1){
                    return false;
                }
                else{
                    return true;
                }
        }
    public ClienteVO buscarCodPersona(ClienteVO Vo){
            int bandera=-1;
            String cadena;
            try{
                    //nombre q pondremos enla tabla
                cadena="SELECT * FROM cliente WHERE '"+Vo.getUsuario()+"' LIKE USUARIO AND '"+Vo.getContraseña()+"' LIKE CONTRASEÑA"; //CONTROL C, CARGA TODO DE LA BASE D EDATOS
                con=conex.getConexion();
                pst=con.prepareStatement(cadena);
                rs=pst.executeQuery(cadena); //CARGADO EN LA MEMORIA RAM
                
                while(rs.next()) { //RECOORE LA BASE DE DATOS cada registro=persona
                    bandera=Integer.parseInt(rs.getString("cod_cliente"));
                }
                rs.close();
            } catch(SQLException exsql) {
                JOptionPane.showMessageDialog(null,exsql.getMessage(),"mensaje>>",JOptionPane.ERROR_MESSAGE);
            }
            
             if(bandera==-1){
                    return null;
                }
                else{
                    Vo.setCod_cliente(bandera);
                    return Vo;
                }
        }

}
