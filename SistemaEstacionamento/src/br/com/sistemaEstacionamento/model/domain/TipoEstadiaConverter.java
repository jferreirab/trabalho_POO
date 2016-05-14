/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.domain;

import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Aurel
 */
public class TipoEstadiaConverter extends Converter<TipoEstadia, String> {
  
    @Override
    public String convertForward(TipoEstadia value) {
        return value.toString();
    }
    
    @Override
    public TipoEstadia convertReverse(String value) {
        return value != null ? TipoEstadia.fromString(value) : null;
    }
}
