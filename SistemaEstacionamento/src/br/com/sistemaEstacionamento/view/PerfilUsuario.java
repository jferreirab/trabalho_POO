package br.com.sistemaEstacionamento.view;

public enum PerfilUsuario {
    
    ADMINISTRADOR(1, CarregadorMenuPerfilAdm.class), 
    OPERADOR(2, CarregadorMenuPerfilOpe.class);
    
    private final int perfilUsuario;
    private Class classeExecucao;
    
    private PerfilUsuario(int perfilUsuario, Class classeExecucao){
        this.perfilUsuario = perfilUsuario;
        this.classeExecucao = classeExecucao;
    }
    
    public int getPerfilUsuario() {
        return perfilUsuario;
    }
    
    public CarregadorMenuPerfil getCarregadorMenu() throws InstantiationException,IllegalAccessException {
            return (CarregadorMenuPerfil)classeExecucao.newInstance();
    }
}

