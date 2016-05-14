/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.domain;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Aurel
 */
public enum TipoEstadia {
    
    HORA(new EstadiaHora()),
    DIARIA(new EstadiaDiaria()),
    MENSAL(new EstadiaMensal());
    
    private CalculoEstadia calculoEstadia;

    private TipoEstadia(CalculoEstadia calculoEstadia) {
        this.calculoEstadia = calculoEstadia;
    }
    
    public static TipoEstadia fromString(String tpEstadia){
        if(tpEstadia == null) return null;
        for(TipoEstadia enumeration : TipoEstadia.values()){
            if(enumeration.toString().equals(tpEstadia)){
                return enumeration;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if(this.equals(HORA)){
            return "Hora";
        } else if(this.equals(DIARIA)){
            return "Diária";
        } else {
            return "Mensal";
        }
    }

    public CalculoEstadia getCalculoEstadia() {
        return calculoEstadia;
    }
}
