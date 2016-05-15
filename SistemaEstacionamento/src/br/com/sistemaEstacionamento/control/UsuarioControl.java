package br.com.sistemaEstacionamento.control;

import br.com.sistemaEstacionamento.model.dao.IUsuarioDao;
import br.com.sistemaEstacionamento.model.dao.UsuarioDao;
import br.com.sistemaEstacionamento.model.domain.Usuario;
import br.com.sistemaEstacionamento.util.CriptografaString;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Daniel
 */
public class UsuarioControl {
    
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private Usuario usuario;
    private Usuario usuarioSelecionado;
    private List<Usuario> usuariosTabela;
    private final IUsuarioDao usuarioDao;
    public static int perfilLogado = 0;
    
    public UsuarioControl() throws NoSuchAlgorithmException, UnsupportedEncodingException{
        
        this.usuarioDao = new UsuarioDao();
        usuariosTabela = ObservableCollections.observableList(new ArrayList<Usuario>());
        this.novo();
        this.pesquisar();
    }
    
    public void novo() {
        setUsuario(new Usuario());
    }
    public boolean salvar() throws NoSuchAlgorithmException, UnsupportedEncodingException  {
        
        Usuario usuarioValidarLogin = new Usuario();
        usuarioValidarLogin.setCodigoUsuario(null);
        usuarioValidarLogin.setLogin(usuario.getLogin());
        usuarioValidarLogin.setSenha("");
        usuarioValidarLogin.setCodigoPerfil(null);
        
        if (usuarioDao.pesquisar(usuario).size() > 0)
            return false;
        else {
            usuario.setSenha(CriptografaString.criptografiaHashMd5(usuario.getSenha()));
            usuarioDao.salvarAtualizar(usuario);        
            novo();
            pesquisar();
            return true;
        }
    }

    public void excluir() throws NoSuchAlgorithmException, UnsupportedEncodingException{
        usuarioDao.excluir(usuario);
        novo();
        pesquisar();
    }

    public void pesquisar() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        usuariosTabela.clear();
        usuario.setSenha(CriptografaString.criptografiaHashMd5(usuario.getSenha()));
        usuariosTabela.addAll(usuarioDao.pesquisar(usuario));
    }
    
    public boolean realizarLogin() {
        //Usuário MASTER
        if (usuario.getLogin().equals("admin") && usuario.getSenha().equals("admin"))
        {
            this.perfilLogado = 1;
            return true;
        }
        else
        {
            List<Usuario> listaUsuario = new ArrayList<Usuario>();
            listaUsuario = usuarioDao.pesquisar(usuario);
            if (usuarioDao.pesquisar(usuario).size() > 0){
                this.perfilLogado = listaUsuario.get(0).getCodigoPerfil();
                return true;
            }
            return false;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        Usuario oldUsuario = this.usuario;
        this.usuario = usuario;
        propertyChangeSupport.firePropertyChange("usuario", oldUsuario, usuario);
    }
    
     public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
        if (this.usuarioSelecionado != null) {
            setUsuario(usuarioSelecionado);
        }
    }
    
    public List<Usuario> getUsuariosTabela() {
        return usuariosTabela;
    }
    
    public void setUsuariosTabela(List<Usuario> usuariosTabela) {
        this.usuariosTabela = usuariosTabela;
    }
    
    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }
    
     public void addPropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.addPropertyChangeListener(e);
    }
    
     public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }
}
