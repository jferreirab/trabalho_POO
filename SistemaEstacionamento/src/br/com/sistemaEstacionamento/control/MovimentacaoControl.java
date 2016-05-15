/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.control;

import br.com.sistemaEstacionamento.model.dao.IMovimentacaoDao;
import br.com.sistemaEstacionamento.model.dao.ITabelaPrecoDao;
import br.com.sistemaEstacionamento.model.dao.MovimentacaoDao;
import br.com.sistemaEstacionamento.model.dao.TabelaPrecoDao;
import br.com.sistemaEstacionamento.model.domain.Movimentacao;
import br.com.sistemaEstacionamento.model.domain.TabelaPreco;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Aurel
 */
public class MovimentacaoControl {

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private Movimentacao movimentacao;

    private Movimentacao movimentacaoSelecionada;

    private List<Movimentacao> movimentacoesTabela;

    private final IMovimentacaoDao movimentacaoDao;
    private final ITabelaPrecoDao tabelaPrecoDao;

    public MovimentacaoControl() {
        this.movimentacaoDao = new MovimentacaoDao();
        this.tabelaPrecoDao = new TabelaPrecoDao();
        movimentacoesTabela = ObservableCollections.observableList(new ArrayList<Movimentacao>());
        this.novo();
        this.pesquisar();
    }

    public void novo() {
        setMovimentacao(new Movimentacao());
    }

    public void salvar() {
        //cliente.validar();
        movimentacaoDao.salvarAtualizar(movimentacao);
        novo();
        pesquisar();
    }

    public void excluir() {
        movimentacaoDao.excluir(movimentacao);
        novo();
        pesquisar();
    }

    public void pesquisar() {
        movimentacoesTabela.clear();
        movimentacoesTabela.addAll(movimentacaoDao.pesquisar(movimentacao));

    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        Movimentacao oldMovimentacao = this.movimentacao;
        this.movimentacao = movimentacao;
        propertyChangeSupport.firePropertyChange("movimentacao", oldMovimentacao, movimentacao);
    }

    public void setMovimentacaoSelecionada(Movimentacao clienteSelecionado) {
        this.movimentacaoSelecionada = clienteSelecionado;
        if (this.movimentacaoSelecionada != null) {
            List<TabelaPreco> tabelaprecos = this.tabelaPrecoDao.pesquisar(new TabelaPreco());
            this.movimentacaoSelecionada.setTabelaPreco(tabelaprecos);      
            this.movimentacaoSelecionada.setDtSaida(new Date());
            this.movimentacaoSelecionada.getPreco();
            setMovimentacao(movimentacaoSelecionada);
        }
    }

    public List<Movimentacao> getMovimentacoesTabela() {
        return movimentacoesTabela;
    }

    public void setMovimentacoesTabela(List<Movimentacao> clientesTabela) {
        this.movimentacoesTabela = clientesTabela;
    }

    public Movimentacao getMovimentacaoSelecionada() {
        return movimentacaoSelecionada;
    }

    public void addPropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.addPropertyChangeListener(e);
    }

    public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }

}
