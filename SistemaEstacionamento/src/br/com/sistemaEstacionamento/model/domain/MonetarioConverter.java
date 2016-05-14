/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Aurel
 */
public class MonetarioConverter extends Converter<BigDecimal,String> {
  
    DecimalFormat format = new DecimalFormat("#,###,##0.00");
    
    @Override
    public String convertForward(BigDecimal arg) {
        return (arg != null) ? format.format(arg) : "";
    }
    
    @Override
    public BigDecimal convertReverse(String arg) {
        
        BigDecimal value;
        try {
            value = arg == null ? null : (BigDecimal) format.parse(arg);
        } catch (ParseException ex) {
            value = null;
        }
        return value;
    }    
}
