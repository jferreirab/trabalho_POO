/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Aurel
 */
public class DataConverter extends Converter<Date,String> {
  
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    @Override
    public String convertForward(Date arg) {
        return (arg != null) ? sdf.format(arg) : "";
    }
    
    @Override
    public Date convertReverse(String arg) {
        
        Date value;
        try {
            value = (arg == null) ? null : sdf.parse(arg);
        } catch (ParseException ex) {
            value = null;
        }
        return value;
    }     
}
