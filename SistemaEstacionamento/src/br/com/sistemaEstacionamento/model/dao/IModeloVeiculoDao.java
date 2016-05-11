/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.ModeloVeiculo;
import java.util.List;

/**
 *
 * @author jferr
 */
public interface IModeloVeiculoDao {
    
    void salvarAtualizar(ModeloVeiculo modeloVeiculo);

    void excluir(ModeloVeiculo modeloVeiculo);

    //List<ModeloVeiculo> pesquisar(ModeloVeiculo modeloVeiculo);
}
