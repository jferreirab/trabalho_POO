package br.com.sistemaEstacionamento.view;

import java.util.HashMap;
import java.util.Map;

public class CarregadorMenuPerfilOpe extends CarregadorMenuPerfil {

    @Override
    protected Map<String, Boolean> carregarMenu() {
        menuVisibilidade = new HashMap<>();
        
        menuVisibilidade.put("cadastroMenu", Boolean.FALSE);
        menuVisibilidade.put("atividadesMenu", Boolean.TRUE);
        menuVisibilidade.put("helpmenu", Boolean.TRUE);
        
        return menuVisibilidade;
    }
}
