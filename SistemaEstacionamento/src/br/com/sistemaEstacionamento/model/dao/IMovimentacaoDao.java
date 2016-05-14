/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.Movimentacao;
import java.util.List;

/**
 *
 * @author Aurel
 */
public interface IMovimentacaoDao {

    void salvarAtualizar(Movimentacao movimentacao);

    void excluir(Movimentacao movimentacao);

    List<Movimentacao> pesquisar(Movimentacao movimentacao);
}
