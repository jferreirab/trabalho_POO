/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.Cliente;
import br.com.sistemaEstacionamento.model.domain.Veiculo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author jferr
 */
public class VeiculoDao implements IVeiculoDao{
 
    private EntityManager entityManager;
	
    private ICrudDao<Veiculo,Integer> crudDao;
    
    public VeiculoDao() {
        entityManager = Conexao.getEntityManager();
        crudDao = new CrudDao<>(entityManager);
    }
    @Override
    public void salvarAtualizar(Veiculo veiculo) {
    	crudDao.salvarAtualizar(veiculo,veiculo.getCodigo());
    }
        
    
    @Override
    public void excluir(Veiculo veiculo) {
        crudDao.excluir(veiculo);
    }
    
    
    @Override
    public List<Veiculo> pesquisar(Veiculo veiculo) {
        return crudDao.pesquisar(getQueryPesquisar(veiculo),getValoresParametros(veiculo));
    }
    
    private String getQueryPesquisar(Veiculo veiculo) {
	StringBuilder sb = new StringBuilder("from Veiculo c where 1 = 1 ");
        if (veiculo.getCodigo() != null) {
            sb.append("and c.codigo = :codigo ");
        }
        if (veiculo.getPlaca()!= null && !veiculo.getPlaca().equals("")) {
            sb.append("and c.placa like :placa ");
        }
        if(veiculo.getCliente()!= null ){
            sb.append("and c.cliente = :cliente ");
        }
        return sb.toString();
    }

    private Map<String, Object> getValoresParametros(Veiculo veiculo) {
	Map<String,Object> valores = new HashMap<>();
	if (veiculo.getCodigo() != null) {
	    valores.put("codigo",veiculo.getCodigo());
	}
	if (veiculo.getPlaca()!= null && !veiculo.getPlaca().equals("")) {
	    valores.put("placa","%"+veiculo.getPlaca()+"%");
	}
        if(veiculo.getCliente()!= null ){
            valores.put("cliente",veiculo.getCliente());
        }
	return valores;
    }

    @Override
    public List<Veiculo> pesquisarPorCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
