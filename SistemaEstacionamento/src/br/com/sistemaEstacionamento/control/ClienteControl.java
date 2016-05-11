/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.control;

import br.com.sistemaEstacionamento.model.dao.ClienteDao;
import br.com.sistemaEstacionamento.model.dao.IClienteDao;
import br.com.sistemaEstacionamento.model.domain.Cliente;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author jferr
 */
public class ClienteControl {
    
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private Cliente cliente;
    
    private Cliente clienteSelecionado;
    
    private List<Cliente> clientesTabela;
    
    private final IClienteDao clienteDao;
    
    private VeiculoControl veiculoControl;
    
    public ClienteControl(){
        
        this.clienteDao = new ClienteDao();
        this.veiculoControl = new VeiculoControl();
        clientesTabela = ObservableCollections.observableList(
                      new ArrayList<Cliente>());
        this.novo();
        this.pesquisar();
    }
    public void novo() {
        setCliente(new Cliente());
    }
    public void salvar()  {
        //cliente.validar();
        clienteDao.salvarAtualizar(cliente);        
        novo();
        pesquisar();
    }

    public void excluir(){
        clienteDao.excluir(cliente);
        novo();
        pesquisar();
    }

    
    public void pesquisar() {
        clientesTabela.clear();
        clientesTabela.addAll(clienteDao.pesquisar(cliente));

    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        Cliente oldCliente = this.cliente;
        this.cliente = cliente;
        propertyChangeSupport.firePropertyChange(
                "cliente", oldCliente, cliente);
    }
    
     public void setClienteSelecionado(Cliente 
            clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
        if (this.clienteSelecionado != null) {
            setCliente(clienteSelecionado);
            veiculoControl.setClienteSelecionado(clienteSelecionado);
        }
    }
    
    public List<Cliente> getClientesTabela() {
        return clientesTabela;
    }
    
    public void setClientesTabela(List<Cliente> clientesTabela) {
        this.clientesTabela = clientesTabela;
    }
    
    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public VeiculoControl getVeiculoControl() {
        return veiculoControl;
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
