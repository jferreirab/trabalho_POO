/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.Veiculo;
import java.util.List;

/**
 *
 * @author jferr
 */
public interface IVeiculoDao {
    
    void salvarAtualizar(Veiculo veiculo);

    void excluir(Veiculo veiculo);

    List<Veiculo> pesquisar(Veiculo veiculo);
}
