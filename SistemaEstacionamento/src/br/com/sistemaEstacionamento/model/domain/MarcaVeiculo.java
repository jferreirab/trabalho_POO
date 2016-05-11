/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.domain;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jferr
 */
@Entity
@Table(name = "TB_MARCA_VEICULO")
public class MarcaVeiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_MARCA")
    private Integer codigo;
    
    @Column(name="DS_MARCA")
    private String marca;
    
    @OneToMany(mappedBy = "marcaVeiculo", targetEntity = ModeloVeiculo.class, fetch = FetchType.LAZY)
    private List<ModeloVeiculo> modeloVeiculos;
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<ModeloVeiculo> getModeloVeiculos() {
        return modeloVeiculos;
    }

    public void setModeloVeiculos(List<ModeloVeiculo> modeloVeiculos) {
        this.modeloVeiculos = modeloVeiculos;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MarcaVeiculo other = (MarcaVeiculo) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
}
