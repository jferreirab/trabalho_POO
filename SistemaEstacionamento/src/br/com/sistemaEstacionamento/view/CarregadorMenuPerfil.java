/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.view;

import java.util.Map;

/**
 *
 * @author Desenvolvedor
 */
public abstract class CarregadorMenuPerfil {
    
    protected Map<String, Boolean> menuVisibilidade;
        
    protected abstract Map<String, Boolean> carregarMenu();
}
