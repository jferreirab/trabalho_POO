/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.control;

import br.com.sistemaEstacionamento.model.dao.IMarcaVeiculoDao;
import br.com.sistemaEstacionamento.model.dao.MarcaVeiculoDao;
import br.com.sistemaEstacionamento.model.domain.MarcaVeiculo;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author jferr
 */
public class MarcaVeiculoControl {
    
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private MarcaVeiculo marcaVeiculo;
    
    private MarcaVeiculo marcaVeiculoSelecionado;
    
    private List<MarcaVeiculo> marcaVeiculosTabela;
    
    private final IMarcaVeiculoDao marcaVeiculoDao;
    
    public MarcaVeiculoControl(){
        
        this.marcaVeiculoDao = new MarcaVeiculoDao();
        marcaVeiculosTabela = ObservableCollections.observableList(
                      new ArrayList<MarcaVeiculo>());
        this.novo();
        this.pesquisar();
    }
    public void novo() {
        setMarcaVeiculo(new MarcaVeiculo());
    }
    public void salvar()  {
        marcaVeiculoDao.salvarAtualizar(marcaVeiculo);        
        novo();
        pesquisar();
    }

    public void excluir(){
        marcaVeiculoDao.excluir(marcaVeiculo);
        novo();
        pesquisar();
    }

    
    public void pesquisar() {
        marcaVeiculosTabela.clear();
        marcaVeiculosTabela.addAll(marcaVeiculoDao.pesquisar(marcaVeiculo));

    }

    public MarcaVeiculo getMarcaVeiculo() {
        return marcaVeiculo;
    }
    
    public void setMarcaVeiculo(MarcaVeiculo marcaVeiculo) {
        MarcaVeiculo oldMarcaVeiculo = this.marcaVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        propertyChangeSupport.firePropertyChange(
                "marcaVeiculo", oldMarcaVeiculo, marcaVeiculo);
    }
    
     public void setMarcaVeiculoSelecionado(MarcaVeiculo 
            marcaVeiculoSelecionado) {
        this.marcaVeiculoSelecionado = marcaVeiculoSelecionado;
        if (this.marcaVeiculoSelecionado != null) {
            setMarcaVeiculo(marcaVeiculoSelecionado);
        }
    }
    
    public List<MarcaVeiculo> getMarcaVeiculosTabela() {
        return marcaVeiculosTabela;
    }
    
    public void setMarcaVeiculosTabela(List<MarcaVeiculo> marcaVeiculosTabela) {
        this.marcaVeiculosTabela = marcaVeiculosTabela;
    }
    
    public MarcaVeiculo getMarcaVeiculoSelecionado() {
        return marcaVeiculoSelecionado;
    }
    
     public void addPropertyChangeListener(
            PropertyChangeListener e) {
        propertyChangeSupport.
                addPropertyChangeListener(e);
    }
    public void removePropertyChangeListener(
            PropertyChangeListener e) {
        propertyChangeSupport.
                removePropertyChangeListener(e);
    }
}
