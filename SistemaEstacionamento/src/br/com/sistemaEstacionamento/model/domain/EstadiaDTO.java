/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.domain;

import java.util.Date;

/**
 *
 * @author Aurel
 */
public class EstadiaDTO {
    
    private Date dtInicio;
    private Date dtFim;

    public EstadiaDTO(Date dtInicio,Date dtFim) {
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public Date getDtInicio() {
        return dtInicio;
    }
}
