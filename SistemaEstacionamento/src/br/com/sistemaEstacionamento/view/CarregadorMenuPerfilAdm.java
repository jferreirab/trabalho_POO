/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.view;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Desenvolvedor
 */
public class CarregadorMenuPerfilAdm extends CarregadorMenuPerfil {

    @Override
    protected Map<String, Boolean> carregarMenu() {
        menuVisibilidade = new HashMap<>();
        
        menuVisibilidade.put("cadastroMenu", Boolean.TRUE);
        menuVisibilidade.put("atividadesMenu", Boolean.TRUE);
        menuVisibilidade.put("helpmenu", Boolean.TRUE);
        
        return menuVisibilidade;
    }
}
