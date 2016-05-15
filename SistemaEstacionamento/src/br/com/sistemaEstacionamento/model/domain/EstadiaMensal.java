/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Aurel
 */
public class EstadiaMensal implements CalculoEstadia {

    @Override
    public BigDecimal calculaPreco(EstadiaDTO estadiaDTO) {
        BigDecimal preco = BigDecimal.ZERO;
        if(estadiaDTO != null && estadiaDTO.getDtInicio() != null 
                && estadiaDTO.getDtFim() != null && estadiaDTO.getTabelaPreco() != null){
            
           Long tot = (long) (estadiaDTO.getDtInicio().getTime() - estadiaDTO.getDtFim().getTime());		
           Integer tempoMinutos = (int) ((tot/1000.0d)/60.0d) * -1; 
           
           for(TabelaPreco tabelaPreco : estadiaDTO.getTabelaPreco()){
               if(tabelaPreco.getTempo() * 60 >= tempoMinutos){
                   preco = tabelaPreco.getValor();
               }
           }
        } 
        return preco;
    }
    
}
