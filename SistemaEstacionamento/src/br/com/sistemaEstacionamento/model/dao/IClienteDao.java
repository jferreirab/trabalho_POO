/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.Cliente;
import java.util.List;

/**
 *
 * @author jferr
 */
public interface IClienteDao {
    void salvarAtualizar(Cliente cliente);

    void excluir(Cliente cliente);

    List<Cliente> pesquisar(Cliente cliente);
}
