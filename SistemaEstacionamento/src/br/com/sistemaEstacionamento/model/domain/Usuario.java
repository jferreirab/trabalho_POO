package br.com.sistemaEstacionamento.model.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_USUARIO")
    private Integer codigoUsuario;
    
    @Column(name = "NM_LOGIN")
    private String login;
    
    @Column(name = "NM_SENHA")
    private String senha;
    
    //@OneToOne(mappedBy = "usuario", targetEntity = Perfil.class, fetch = FetchType.LAZY)
    @Column(name = "CD_PERFIL")
    private String codigoPerfil;
            
    public Usuario () {
    }

    /**
     * @return the codigoUsuario
     */
    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @return the codigoPerfil
     */
    public String getCodigoPerfil() {
        return codigoPerfil;
    }

    /**
     * @param codigoUsuario the codigoUsuario to set
     */
    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @param codigoPerfil the codigoPerfil to set
     */
    public void setCodigoPerfil(String codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }
    
    public boolean validar() {
        if (codigoUsuario == null || codigoUsuario.equals(""))
            return false;
        if (login == null || login.equals(""))
            return false;
        if (senha == null || senha.equals(""))
            return false;
        return !(codigoPerfil == null || codigoPerfil.equals(""));
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.codigoUsuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        
        if (obj == null) 
            return false;
        
        if (getClass() != obj.getClass()) 
            return false;
        
        final Usuario usuarioValidacao = (Usuario) obj;
        if (!Objects.equals(this.codigoUsuario, usuarioValidacao.codigoUsuario)) 
            return false;
        
        return Objects.equals(this.login, usuarioValidacao.login);
    }
}
