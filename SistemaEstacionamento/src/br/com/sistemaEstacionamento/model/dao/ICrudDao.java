/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import java.util.List;
import java.util.Map;

/**
 *
 * @author jferr
 */
public interface ICrudDao<T, I> {
    
    void salvarAtualizar(T t, I i);

    void excluir(T t);

    List<T> pesquisar(String queryPesquisar, Map<String, Object> valores);
    
}
