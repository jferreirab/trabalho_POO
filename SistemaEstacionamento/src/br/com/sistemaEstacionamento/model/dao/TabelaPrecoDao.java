/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.TabelaPreco;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author jferr
 */
public class TabelaPrecoDao implements ITabelaPrecoDao{
    private EntityManager entityManager;
	
    private ICrudDao<TabelaPreco,Integer> crudDao;
    
    public TabelaPrecoDao() {
        entityManager = Conexao.getEntityManager();
        crudDao = new CrudDao<>(entityManager);
    }
    
    
    @Override
    public void salvarAtualizar(TabelaPreco tabelaPreco) {
    	crudDao.salvarAtualizar(tabelaPreco,tabelaPreco.getCodigo());
    }
        
    
    @Override
	public void excluir(TabelaPreco tabelaPreco) {
        crudDao.excluir(tabelaPreco);
    }
    
    
    @Override
	public List<TabelaPreco> pesquisar(TabelaPreco tabelaPreco) {
        return crudDao.pesquisar(getQueryPesquisar(tabelaPreco) + getOrderBy(),getValoresParametros(tabelaPreco));
    }
    
    private String getQueryPesquisar(TabelaPreco tabelaPreco) {
            StringBuilder sb = new StringBuilder("from TabelaPreco c where 1 = 1 ");
        if (tabelaPreco.getCodigo() != null) {
            sb.append("and c.codigo = :codigo ");
        }

        return sb.toString();
    }

    private Map<String, Object> getValoresParametros(TabelaPreco tabelaPreco) {
        Map<String,Object> valores = new HashMap<>();
        if (tabelaPreco.getCodigo() != null) {
            valores.put("codigo",tabelaPreco.getCodigo());
        }
        return valores;
    }
    private String getOrderBy() {
	StringBuilder sb = new StringBuilder(" order by tempo desc ");       
        return sb.toString();
    }
}
