/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.CorVeiculo;
import java.util.List;

/**
 *
 * @author jferr
 */
public interface ICorVeiculoDao {
    void salvarAtualizar(CorVeiculo corVeiculo);

    void excluir(CorVeiculo corVeiculo);

    List<CorVeiculo> pesquisar(CorVeiculo corVeiculo);
}
