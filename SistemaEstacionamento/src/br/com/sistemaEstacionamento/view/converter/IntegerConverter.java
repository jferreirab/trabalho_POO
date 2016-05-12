/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.view.converter;

import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author jferr
 */
public class IntegerConverter extends Converter<Integer,String> {

    @Override
    public Integer convertReverse(String value) {
        if (value == null || value.equals("")) {
            return null;
        }            
        return Integer.parseInt(value);
    }

    @Override
    public String convertForward(Integer value) {
        return value.toString();
    }

}
