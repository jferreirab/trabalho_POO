/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.control;

import br.com.sistemaEstacionamento.model.dao.CorVeiculoDao;
import br.com.sistemaEstacionamento.model.dao.ICorVeiculoDao;
import br.com.sistemaEstacionamento.model.domain.CorVeiculo;
import br.com.sistemaEstacionamento.util.ValidacaoCampoException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author jferr
 */
public class CorVeiculoControl {
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private CorVeiculo corVeiculo;
    
    private CorVeiculo corVeiculoSelecionado;
    
    private List<CorVeiculo> corVeiculosTabela;
    
    private final ICorVeiculoDao corVeiculoDao;
    
    public CorVeiculoControl(){
        
        this.corVeiculoDao = new CorVeiculoDao();
        corVeiculosTabela = ObservableCollections.observableList(
                      new ArrayList<CorVeiculo>());
        this.novo();
        this.pesquisar();
    }
    public void novo() {
        setCorVeiculo(new CorVeiculo());
    }
    public void salvar() throws ValidacaoCampoException{
        corVeiculo.validar();
        corVeiculoDao.salvarAtualizar(corVeiculo);        
        novo();
        pesquisar();
    }

    public void excluir(){
        corVeiculoDao.excluir(corVeiculo);
        novo();
        pesquisar();
    }

    
    public void pesquisar() {
        corVeiculosTabela.clear();
        corVeiculosTabela.addAll(corVeiculoDao.pesquisar(corVeiculo));

    }

    public CorVeiculo getCorVeiculo() {
        return corVeiculo;
    }
    
    public void setCorVeiculo(CorVeiculo corVeiculo) {
        CorVeiculo oldCorVeiculo = this.corVeiculo;
        this.corVeiculo = corVeiculo;
        propertyChangeSupport.firePropertyChange(
                "corVeiculo", oldCorVeiculo, corVeiculo);
    }
    
     public void setCorVeiculoSelecionado(CorVeiculo 
            corVeiculoSelecionado) {
        this.corVeiculoSelecionado = corVeiculoSelecionado;
        if (this.corVeiculoSelecionado != null) {
            setCorVeiculo(corVeiculoSelecionado);
        }
    }
    
    public List<CorVeiculo> getCorVeiculosTabela() {
        return corVeiculosTabela;
    }
    
    public void setCorVeiculosTabela(List<CorVeiculo> corVeiculosTabela) {
        this.corVeiculosTabela = corVeiculosTabela;
    }
    
    public CorVeiculo getCorVeiculoSelecionado() {
        return corVeiculoSelecionado;
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
