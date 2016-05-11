/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.ModeloVeiculo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author jferr
 */
public class ModeloVeiculoDao implements IModeloVeiculoDao{

    private EntityManager entityManager;
	
    private ICrudDao<ModeloVeiculo,Integer> crudDao;
    
    public ModeloVeiculoDao() {
        entityManager = Conexao.getEntityManager();
        crudDao = new CrudDao<>(entityManager);
    }
    @Override
    public void salvarAtualizar(ModeloVeiculo modeloVeiculo) {
    	crudDao.salvarAtualizar(modeloVeiculo,modeloVeiculo.getCodigo());
    }
        
    
    @Override
    public void excluir(ModeloVeiculo modeloVeiculo) {
        crudDao.excluir(modeloVeiculo);
    }
    
    
   /* @Override
    public List<ModeloVeiculo> pesquisar(ModeloVeiculo modeloVeiculo) {
        return crudDao.pesquisar(getQueryPesquisar(modeloVeiculo),getValoresParametros(modeloVeiculo));
    }
    
    private String getQueryPesquisar(ModeloVeiculo modeloVeiculo) {
	StringBuilder sb = new StringBuilder("from modeloVeiculo c where 1 = 1 ");
        if (modeloVeiculo.getCodigo() != null) {
            sb.append("and c.codigo = :codigo ");
        }
        if (modeloVeiculo.getModelo()!= null && !modeloVeiculo.getModelo().equals("")) {
            sb.append("and c.modelo like :modelo");
        }
        return sb.toString();
    }

	private Map<String, Object> getValoresParametros(ModeloVeiculo modeloVeiculo) {
		Map<String,Object> valores = new HashMap<>();
		if (modeloVeiculo.getCodigo() != null) {
	        valores.put("codigo",modeloVeiculo.getCodigo());
	    }
	    if (modeloVeiculo.getModelo()!= null && !modeloVeiculo.getModelo().equals("")) {
	        valores.put("modelo","%"+modeloVeiculo.getModelo()+"%");
	    }
	    return valores;
	}*/
    
}
