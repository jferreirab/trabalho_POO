/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.MarcaVeiculo;
import java.util.List;

/**
 *
 * @author jferr
 */
public interface IMarcaVeiculoDao {
    
     void salvarAtualizar(MarcaVeiculo marcaVeiculo);

    void excluir(MarcaVeiculo marcaVeiculo);

    List<MarcaVeiculo> pesquisar(MarcaVeiculo marcaVeiculo);
}
