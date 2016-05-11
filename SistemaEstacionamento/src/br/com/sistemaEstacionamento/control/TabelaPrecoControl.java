/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.control;

import br.com.sistemaEstacionamento.model.dao.ITabelaPrecoDao;
import br.com.sistemaEstacionamento.model.dao.TabelaPrecoDao;
import br.com.sistemaEstacionamento.model.domain.TabelaPreco;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author jferr
 */
public class TabelaPrecoControl {
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private TabelaPreco tabelaPreco;
    
    private TabelaPreco tabelaPrecoSelecionado;
    
    private List<TabelaPreco> tabelaPrecosTabela;
    
    private final ITabelaPrecoDao tabelaPrecoDao;
    
    public TabelaPrecoControl(){
        
        this.tabelaPrecoDao = new TabelaPrecoDao();
        tabelaPrecosTabela = ObservableCollections.observableList(
                      new ArrayList<TabelaPreco>());
        this.novo();
        this.pesquisar();
    }
    public void novo() {
        setTabelaPreco(new TabelaPreco());
    }
    public void salvar()  {
        
        tabelaPrecoDao.salvarAtualizar(tabelaPreco);        
        novo();
        pesquisar();
    }

    public void excluir(){
        tabelaPrecoDao.excluir(tabelaPreco);
        novo();
        pesquisar();
    }

    
    public void pesquisar() {
        tabelaPrecosTabela.clear();
        tabelaPrecosTabela.addAll(tabelaPrecoDao.pesquisar(tabelaPreco));

    }

    public TabelaPreco getTabelaPreco() {
        return tabelaPreco;
    }
    
    public void setTabelaPreco(TabelaPreco tabelaPreco) {
        TabelaPreco oldTabelaPreco = this.tabelaPreco;
        this.tabelaPreco = tabelaPreco;
        propertyChangeSupport.firePropertyChange(
                "tabelaPreco", oldTabelaPreco, tabelaPreco);
    }
    
     public void setTabelaPrecoSelecionado(TabelaPreco 
            tabelaPrecoSelecionado) {
        this.tabelaPrecoSelecionado = tabelaPrecoSelecionado;
        if (this.tabelaPrecoSelecionado != null) {
            setTabelaPreco(tabelaPrecoSelecionado);
        }
    }
    
    public List<TabelaPreco> getTabelaPrecosTabela() {
        return tabelaPrecosTabela;
    }
    
    public void setTabelaPrecosTabela(List<TabelaPreco> tabelaPrecosTabela) {
        this.tabelaPrecosTabela = tabelaPrecosTabela;
    }
    
    public TabelaPreco getTabelaPrecoSelecionado() {
        return tabelaPrecoSelecionado;
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
