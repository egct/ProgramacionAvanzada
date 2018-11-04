/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avanzadacapamodelo;


import java.beans.*;
import java.io.Serializable;
import java.rmi.Remote;

/**
 *
 * @author Santi
 */
public class ReservarAsientoVO implements Remote, Serializable {
    private int cod_reserva;
    private int cod_cliente;
    private int numero_asiento;

    public ReservarAsientoVO() {
    }
    
    
    public ReservarAsientoVO(int cod_reserva, int cod_cliente, int numero_asiento) {
        this.cod_reserva = cod_reserva;
        this.cod_cliente = cod_cliente;
        this.numero_asiento = numero_asiento;
    }

    public int getCod_reserva() {
        return cod_reserva;
    }

    public void setCod_reserva(int cod_reserva) {
        this.cod_reserva = cod_reserva;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getNumero_asiento() {
        return numero_asiento;
    }

    public void setNumero_asiento(int numero_asiento) {
        this.numero_asiento = numero_asiento;
    }
    
}
