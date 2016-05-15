/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class UsuarioDao implements IUsuarioDao {
    
    private EntityManager entityManager;
    private ICrudDao<Usuario, Integer> crudDao;
    
    public UsuarioDao() {
        entityManager = Conexao.getEntityManager();
        crudDao = new CrudDao<>(entityManager);
    }
    
    @Override
    public void salvarAtualizar(Usuario usuario) {
    	crudDao.salvarAtualizar(usuario, usuario.getCodigoUsuario());
    }
       
    @Override
    public void excluir(Usuario usuario) {
        crudDao.excluir(usuario);
    }
    
    @Override
    public List<Usuario> pesquisar(Usuario usuario) {
        return crudDao.pesquisar(getQueryPesquisar(usuario), getValoresParametros(usuario));
    }
    
    private String getQueryPesquisar(Usuario usuario) {
        StringBuilder sb = new StringBuilder("from Usuario usuario where 1 = 1 ");
        
        if (usuario.getCodigoUsuario() != null) 
            sb.append("and usuario.codigoUsuario = :codigoUsuario ");
        
        if (usuario.getLogin() != null && !usuario.getLogin().equals("")) 
            sb.append("and usuario.login like :login ");
        
        if (usuario.getSenha() != null && !usuario.getSenha().equals("")) 
            sb.append("and usuario.senha like :senha ");
        
        if (usuario.getCodigoPerfil() != null && !usuario.getCodigoPerfil().equals(""))  
            sb.append("and usuario.codigoPerfil like :codigoPerfil ");
                
        return sb.toString();
    }

    private Map<String, Object> getValoresParametros(Usuario usuario) {
        Map<String,Object> valores = new HashMap<>();
        
        if (usuario.getCodigoUsuario() != null) 
            valores.put("codigoUsuario", usuario.getCodigoUsuario());
        
        if (usuario.getLogin() != null && !usuario.getLogin().equals("")) 
            valores.put("login", "%" + usuario.getLogin() + "%");
        
        if (usuario.getSenha()!= null && !usuario.getSenha().equals("")) 
            valores.put("senha", "%"+usuario.getSenha()+"%");
        
        if (usuario.getCodigoPerfil() != null && !usuario.getCodigoPerfil().equals("")) 
            valores.put("codigoPerfil","%" +usuario.getCodigoPerfil()+"%");
        
        return valores;
    }
}
