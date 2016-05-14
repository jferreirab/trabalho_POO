/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.domain;

import java.math.BigDecimal;

/**
 *
 * @author Aurel
 */
public interface CalculoEstadia {
    
     public BigDecimal calculaPreco(EstadiaDTO estadiaDTO);
     
}
