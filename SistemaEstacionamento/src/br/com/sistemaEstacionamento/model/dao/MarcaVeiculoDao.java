/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.CorVeiculo;
import br.com.sistemaEstacionamento.model.domain.MarcaVeiculo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author jferr
 */
public class MarcaVeiculoDao implements IMarcaVeiculoDao{

     private EntityManager entityManager;
	
    private ICrudDao<MarcaVeiculo,Integer> crudDao;
    
    public MarcaVeiculoDao() {
        entityManager = Conexao.getEntityManager();
        crudDao = new CrudDao<>(entityManager);
    }
    @Override
    public void salvarAtualizar(MarcaVeiculo marcaVeiculo) {
    	crudDao.salvarAtualizar(marcaVeiculo,marcaVeiculo.getCodigo());
    }
        
    
    @Override
    public void excluir(MarcaVeiculo marcaVeiculo) {
        crudDao.excluir(marcaVeiculo);
    }
    
    
    @Override
    public List<MarcaVeiculo> pesquisar(MarcaVeiculo marcaVeiculo) {
        return crudDao.pesquisar(getQueryPesquisar(marcaVeiculo),getValoresParametros(marcaVeiculo));
    }
    
	private String getQueryPesquisar(MarcaVeiculo marcaVeiculo) {
		StringBuilder sb = new StringBuilder("from MarcaVeiculo c where 1 = 1 ");
        if (marcaVeiculo.getCodigo() != null) {
            sb.append("and c.codigo = :codigo ");
        }
        if (marcaVeiculo.getMarca()!= null && !marcaVeiculo.getMarca().equals("")) {
            sb.append("and c.marca like :marca");
        }
        return sb.toString();
	}

	private Map<String, Object> getValoresParametros(MarcaVeiculo marcaVeiculo) {
		Map<String,Object> valores = new HashMap<>();
		if (marcaVeiculo.getCodigo() != null) {
	        valores.put("codigo",marcaVeiculo.getCodigo());
	    }
	    if (marcaVeiculo.getMarca()!= null && !marcaVeiculo.getMarca().equals("")) {
	        valores.put("marca","%"+marcaVeiculo.getMarca()+"%");
	    }
	    return valores;
	}
    
}
