/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.Cliente;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author juliano
 */
public class ClienteDao implements IClienteDao{
    private EntityManager entityManager;
	
    private ICrudDao<Cliente,Integer> crudDao;
    
    public ClienteDao() {
        entityManager = Conexao.getEntityManager();
        crudDao = new CrudDao<>(entityManager);
    }
    
    
    @Override
	public void salvarAtualizar(Cliente cliente) {
    	crudDao.salvarAtualizar(cliente,cliente.getCodigo());
    }
        
    
    @Override
	public void excluir(Cliente cliente) {
        crudDao.excluir(cliente);
    }
    
    
    @Override
	public List<Cliente> pesquisar(Cliente cliente) {
        return crudDao.pesquisar(getQueryPesquisar(cliente),getValoresParametros(cliente));
    }
    
	private String getQueryPesquisar(Cliente cliente) {
		StringBuilder sb = new StringBuilder("from Cliente c where 1 = 1 ");
        if (cliente.getCodigo() != null) {
            sb.append("and c.codigo = :codigo ");
        }
        if (cliente.getNome() != null && !cliente.getNome().equals("")) {
            sb.append("and c.nome like :nome");
        }
        return sb.toString();
	}

	private Map<String, Object> getValoresParametros(Cliente cliente) {
		Map<String,Object> valores = new HashMap<>();
		if (cliente.getCodigo() != null) {
	        valores.put("codigo",cliente.getCodigo());
	    }
	    if (cliente.getNome() != null && !cliente.getNome().equals("")) {
	        valores.put("nome","%"+cliente.getNome()+"%");
	    }
	    return valores;
	}
}
