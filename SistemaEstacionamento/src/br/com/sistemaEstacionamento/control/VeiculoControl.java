/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.control;

import br.com.sistemaEstacionamento.model.dao.IVeiculoDao;
import br.com.sistemaEstacionamento.model.dao.VeiculoDao;
import br.com.sistemaEstacionamento.model.domain.Cliente;
import br.com.sistemaEstacionamento.model.domain.CorVeiculo;
import br.com.sistemaEstacionamento.model.domain.ModeloVeiculo;
import br.com.sistemaEstacionamento.model.domain.Veiculo;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author jferr
 */
public class VeiculoControl {
    
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private Veiculo veiculo;
    
    private Veiculo veiculoSelecionado;
    
    private List<Veiculo> veiculosTabela;
    
    private final IVeiculoDao veiculoDao;
    
    private Cliente clienteSelecionado;
    
    private  boolean  bloqueiaCampos = false;
    
    private List<ModeloVeiculo> modeloVeiculosTabela;
    
    private List<CorVeiculo> corVeiculosTabela;
    
    private final ModeloVeiculoControl modeloVeiculoControl;
    
    private final CorVeiculoControl corVeiculoControl;
    
    public VeiculoControl(){
        
        this.veiculoDao = new VeiculoDao();
        this.modeloVeiculoControl = new ModeloVeiculoControl();
        this.corVeiculoControl = new CorVeiculoControl();
        veiculosTabela = ObservableCollections.observableList(
                      new ArrayList<Veiculo>());
        this.modeloVeiculosTabela = modeloVeiculoControl.getModeloVeiculosTabela();
        this.corVeiculosTabela = corVeiculoControl.getCorVeiculosTabela();
        this.novo();
        //this.pesquisar();
    }
    public void novo() {
        setVeiculo(new Veiculo());
        this.veiculo.setCliente(clienteSelecionado);
    }
    public void limpaTela() {
        setVeiculo(new Veiculo());
        veiculosTabela.clear();
    }
    public void salvar()  {
        
        veiculoDao.salvarAtualizar(veiculo);        
        novo();
        pesquisar();
    }

    public void excluir(){
        veiculoDao.excluir(veiculo);
        novo();
        pesquisar();
    }

    
    public void pesquisar() {
        veiculosTabela.clear();
        veiculosTabela.addAll(veiculoDao.pesquisar(veiculo));

    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    
    public void setVeiculo(Veiculo veiculo) {
        Veiculo oldVeiculo = this.veiculo;
        this.veiculo = veiculo;
        propertyChangeSupport.firePropertyChange(
                "veiculo", oldVeiculo, veiculo);
    }
    
     public void setVeiculoSelecionado(Veiculo 
            veiculoSelecionado) {
        this.veiculoSelecionado = veiculoSelecionado;
        if (this.veiculoSelecionado != null) {
            setVeiculo(veiculoSelecionado);
        }
    }
    
    public List<Veiculo> getVeiculosTabela() {
        return veiculosTabela;
    }
    
    public void setVeiculosTabela(List<Veiculo> veiculosTabela) {
        this.veiculosTabela = veiculosTabela;
    }
    
    public Veiculo getVeiculoSelecionado() {
        return veiculoSelecionado;
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

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
        setBloqueiaCampos(true);
    }

    public boolean isBloqueiaCampos() {
        return bloqueiaCampos;
    }

    public void setBloqueiaCampos(boolean bloqueiaCampos) {
        this.bloqueiaCampos = bloqueiaCampos;
    }

    public List<ModeloVeiculo> getModeloVeiculosTabela() {
        return modeloVeiculosTabela;
    }

    public void setModeloVeiculosTabela(List<ModeloVeiculo> modeloVeiculosTabela) {
        this.modeloVeiculosTabela = modeloVeiculosTabela;
    }

    public List<CorVeiculo> getCorVeiculosTabela() {
        return corVeiculosTabela;
    }

    public void setCorVeiculosTabela(List<CorVeiculo> corVeiculosTabela) {
        this.corVeiculosTabela = corVeiculosTabela;
    }
    
    
    
    
}