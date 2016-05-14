/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "TB_PERFIL")
public class Perfil implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_PERFIL")
    private Integer codigoPerfil;
    
    @Column(name = "NM_PERFIL")
    private String DescricaoPerfil;

    /**
     * @return the codigoPerfil
     */
    public Integer getCodigoPerfil() {
        return codigoPerfil;
    }

    /**
     * @return the DescricaoPerfil
     */
    public String getDescricaoPerfil() {
        return DescricaoPerfil;
    }

    /**
     * @param codigoPerfil the codigoPerfil to set
     */
    public void setCodigoPerfil(Integer codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    /**
     * @param DescricaoPerfil the DescricaoPerfil to set
     */
    public void setDescricaoPerfil(String DescricaoPerfil) {
        this.DescricaoPerfil = DescricaoPerfil;
    }
}
