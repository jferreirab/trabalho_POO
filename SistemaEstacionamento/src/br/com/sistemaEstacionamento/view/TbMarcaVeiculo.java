/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author jferr
 */
@Entity
@Table(name = "tb_marca_veiculo", catalog = "dbestacionamento", schema = "")
@NamedQueries({
    @NamedQuery(name = "TbMarcaVeiculo.findAll", query = "SELECT t FROM TbMarcaVeiculo t"),
    @NamedQuery(name = "TbMarcaVeiculo.findByCdMarca", query = "SELECT t FROM TbMarcaVeiculo t WHERE t.cdMarca = :cdMarca"),
    @NamedQuery(name = "TbMarcaVeiculo.findByDsMarca", query = "SELECT t FROM TbMarcaVeiculo t WHERE t.dsMarca = :dsMarca")})
public class TbMarcaVeiculo implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_MARCA")
    private Integer cdMarca;
    @Column(name = "DS_MARCA")
    private String dsMarca;

    public TbMarcaVeiculo() {
    }

    public TbMarcaVeiculo(Integer cdMarca) {
        this.cdMarca = cdMarca;
    }

    public Integer getCdMarca() {
        return cdMarca;
    }

    public void setCdMarca(Integer cdMarca) {
        Integer oldCdMarca = this.cdMarca;
        this.cdMarca = cdMarca;
        changeSupport.firePropertyChange("cdMarca", oldCdMarca, cdMarca);
    }

    public String getDsMarca() {
        return dsMarca;
    }

    public void setDsMarca(String dsMarca) {
        String oldDsMarca = this.dsMarca;
        this.dsMarca = dsMarca;
        changeSupport.firePropertyChange("dsMarca", oldDsMarca, dsMarca);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdMarca != null ? cdMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMarcaVeiculo)) {
            return false;
        }
        TbMarcaVeiculo other = (TbMarcaVeiculo) object;
        if ((this.cdMarca == null && other.cdMarca != null) || (this.cdMarca != null && !this.cdMarca.equals(other.cdMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sistemaEstacionamento.view.TbMarcaVeiculo[ cdMarca=" + cdMarca + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
