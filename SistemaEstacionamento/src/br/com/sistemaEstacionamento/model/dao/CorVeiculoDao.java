/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.CorVeiculo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author jferr
 */
public class CorVeiculoDao implements ICorVeiculoDao{
    
     private final EntityManager entityManager;
	
    private final ICrudDao<CorVeiculo,Integer> crudDao;
    
    public CorVeiculoDao() {
        entityManager = Conexao.getEntityManager();
        crudDao = new CrudDao<>(entityManager);
    }
    @Override
    public void salvarAtualizar(CorVeiculo corVeiculo) {
    	crudDao.salvarAtualizar(corVeiculo,corVeiculo.getCodigo());
    }
        
    
    @Override
    public void excluir(CorVeiculo corVeiculo) {
        crudDao.excluir(corVeiculo);
    }
    
    
    @Override
    public List<CorVeiculo> pesquisar(CorVeiculo corVeiculo) {
        return crudDao.pesquisar(getQueryPesquisar(corVeiculo),getValoresParametros(corVeiculo));
    }
    
    private String getQueryPesquisar(CorVeiculo corVeiculo) {
	StringBuilder sb = new StringBuilder("from CorVeiculo c where 1 = 1 ");
        if (corVeiculo.getCodigo() != null) {
            sb.append("and c.codigo = :codigo ");
        }
        if (corVeiculo.getCor()!= null && !corVeiculo.getCor().equals("")) {
            sb.append("and c.cor like :cor");
        }
        return sb.toString();
    }

    private Map<String, Object> getValoresParametros(CorVeiculo corVeiculo) {
	Map<String,Object> valores = new HashMap<>();
	if (corVeiculo.getCodigo() != null) {
            valores.put("codigo",corVeiculo.getCodigo());
        }
        if (corVeiculo.getCor()!= null && !corVeiculo.getCor().equals("")) {
            valores.put("cor","%"+corVeiculo.getCor()+"%");
        }
        return valores;
    }
    
}
