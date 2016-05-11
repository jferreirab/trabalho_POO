/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.control;

import br.com.sistemaEstacionamento.model.dao.IMarcaVeiculoDao;
import br.com.sistemaEstacionamento.model.dao.IModeloVeiculoDao;
import br.com.sistemaEstacionamento.model.dao.ModeloVeiculoDao;
import br.com.sistemaEstacionamento.model.domain.MarcaVeiculo;
import br.com.sistemaEstacionamento.model.domain.ModeloVeiculo;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author jferr
 */
public class ModeloVeiculoControl {
    
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private ModeloVeiculo modeloVeiculo;
    
    private ModeloVeiculo modeloVeiculoSelecionado;
    
    private List<ModeloVeiculo> modeloVeiculosTabela;
    
    private List<MarcaVeiculo> marcaVeiculosTabela;
    
    private final IModeloVeiculoDao modeloVeiculoDao;
    private final MarcaVeiculoControl marcaVeiculoControl;
    
    public ModeloVeiculoControl(){
        
        this.modeloVeiculoDao = new ModeloVeiculoDao();
        this.marcaVeiculoControl = new MarcaVeiculoControl();
        modeloVeiculosTabela = ObservableCollections.observableList(
                      new ArrayList<ModeloVeiculo>());
        marcaVeiculosTabela=  marcaVeiculoControl.getMarcaVeiculosTabela();
        this.novo();
        this.pesquisar();
    }
    public void novo() {
        setModeloVeiculo(new ModeloVeiculo());
    }
    public void salvar()  {
       
        modeloVeiculoDao.salvarAtualizar(modeloVeiculo);        
        novo();
        pesquisar();
    }

    public void excluir(){
        modeloVeiculoDao.excluir(modeloVeiculo);
        novo();
        pesquisar();
    }

    
    public void pesquisar() {
        modeloVeiculosTabela.clear();
//        modeloVeiculosTabela.addAll(modeloVeiculoDao.pesquisar(modeloVeiculo));

    }

    public ModeloVeiculo getModeloVeiculo() {
        return modeloVeiculo;
    }
    
    public void setModeloVeiculo(ModeloVeiculo modeloVeiculo) {
        ModeloVeiculo oldModeloVeiculo = this.modeloVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        propertyChangeSupport.firePropertyChange(
                "modeloVeiculo", oldModeloVeiculo, modeloVeiculo);
    }
    
     public void setModeloVeiculoSelecionado(ModeloVeiculo 
            modeloVeiculoSelecionado) {
        this.modeloVeiculoSelecionado = modeloVeiculoSelecionado;
        if (this.modeloVeiculoSelecionado != null) {
            setModeloVeiculo(modeloVeiculoSelecionado);
        }
    }
    
    public List<ModeloVeiculo> getModeloVeiculosTabela() {
        return modeloVeiculosTabela;
    }
    
    public void setModeloVeiculosTabela(List<ModeloVeiculo> modeloVeiculosTabela) {
        this.modeloVeiculosTabela = modeloVeiculosTabela;
    }
    
    public ModeloVeiculo getModeloVeiculoSelecionado() {
        return modeloVeiculoSelecionado;
    }

    public List<MarcaVeiculo> getMarcaVeiculosTabela() {
        return marcaVeiculosTabela;
    }

    public void setMarcaVeiculosTabela(List<MarcaVeiculo> marcaVeiculosComboBox) {
        this.marcaVeiculosTabela = marcaVeiculosComboBox;
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
