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
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Santi
 */
public class PeliculasDAO {
    
    public void InsertarPeliculas(PeliculasVO peli) {
        //Primero creamos la conexion
     Conexion conex=new Conexion();
       try {
           Statement orden=conex.getConexion().createStatement();
           orden.executeUpdate("INSERT INTO pelicula (cod_pelicula,cod_cliente,precio) VALUES( "
                   +peli.getCod_pelicula()+","
                   +peli.getCod_cliente()+","
                   +peli.getPrecio()+")");
           JOptionPane.showMessageDialog(null, "Se ha registrado una nueva pelicula");
           orden.close();
           conex.desconectar();
            } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
   }
    public List obtenerpeliculas() {
        
        Conexion conex = new Conexion();
           List<PeliculasVO>vuelos=new ArrayList<>();
              
        try {
            java.sql.Statement stmt = conex.getConexion().createStatement();      
            ResultSet rs = stmt.executeQuery("SELECT * from pelicula ");                     
            while (rs.next()) {  
                PeliculasVO peli=new PeliculasVO();
                peli.setCod_pelicula(rs.getInt("cod_pelicula"));
                peli.setCod_cliente(rs.getInt("cod_cliente"));
                peli.setPrecio(rs.getFloat("precio"));
                vuelos.add(peli);
            }
            rs.close();                        
            stmt.close();                           
            conex.desconectar();
            return vuelos;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
