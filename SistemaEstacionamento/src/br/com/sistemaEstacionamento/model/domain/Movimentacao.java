/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Aurel
 */
@Entity
@Table(name = "TB_MOVIMENTACAO")
public class Movimentacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_MOVIMENTACAO", length = 9)
    private Integer codigo;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "TP_ESTADIA",nullable = false, length = 10)
    private TipoEstadia tipoEstadia = TipoEstadia.HORA;
    
    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name = "DT_ENTRADA",nullable = false)
    private Date dtEntrada;
   
    @Temporal(value=TemporalType.TIMESTAMP)    
    @Column(name = "DT_SAIDA",nullable = true)
    private Date dtSaida;
    
    @Column(name = "DS_PLACA",nullable = false)
    private String dsPlaca;
    
    @Column(name = "VR_PRECO",nullable = true, length = 6, precision = 6, scale = 2)
    private BigDecimal preco;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public Date getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public Date getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(Date dtSaida) {
        this.dtSaida = dtSaida;
    }

    public String getDsPlaca() {
        return dsPlaca;
    }

    public void setDsPlaca(String dsPlaca) {
        this.dsPlaca = dsPlaca;
    }

    public TipoEstadia getTipoEstadia() {
        return tipoEstadia;
    }

    public void setTipoEstadia(TipoEstadia tipoEstadia) {
        this.tipoEstadia = tipoEstadia;
    }

    public BigDecimal getPreco() {
        return tipoEstadia.getCalculoEstadia().calculaPreco(new EstadiaDTO(dtSaida, dtSaida));
    }    
}
