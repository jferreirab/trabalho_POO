/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.Usuario;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface IUsuarioDao {
    
    void salvarAtualizar(Usuario usuario);
    void excluir(Usuario usuario);
    List<Usuario> pesquisar(Usuario usuario);
}
