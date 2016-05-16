package br.com.sistemaEstacionamento.view;

import java.util.Map;

public abstract class CarregadorMenuPerfil {
    
    protected Map<String, Boolean> menuVisibilidade;
        
    protected abstract Map<String, Boolean> carregarMenu();
}
