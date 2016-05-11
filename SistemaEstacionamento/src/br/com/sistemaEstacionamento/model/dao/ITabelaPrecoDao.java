/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.TabelaPreco;
import java.util.List;

/**
 *
 * @author jferr
 */
public interface ITabelaPrecoDao  {
    
    void salvarAtualizar(TabelaPreco tabelaPreco);

    void excluir(TabelaPreco tabelaPreco);

    List<TabelaPreco> pesquisar(TabelaPreco tabelaPreco);
    
}
