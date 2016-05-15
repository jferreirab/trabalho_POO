/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.domain;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Aurel
 */
public class EstadiaDTO {
    
    private List<TabelaPreco> tabelaPreco;
    private Date dtInicio;
    private Date dtFim;

    public EstadiaDTO(Date dtInicio,Date dtFim,List<TabelaPreco> tabelaPreco) {
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.tabelaPreco = tabelaPreco;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public List<TabelaPreco> getTabelaPreco() {
        return tabelaPreco;
    }
    
    
}
