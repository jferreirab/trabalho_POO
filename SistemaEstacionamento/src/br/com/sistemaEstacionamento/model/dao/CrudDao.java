/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author jferr
 */
public class CrudDao<T,I> implements ICrudDao<T, I>{
    
    private EntityManager entityManager;

    public CrudDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    @Override
    public void salvarAtualizar(T t,I i) {
    entityManager.getTransaction().begin();
    if (i != null) {
        t = ligar(t);
    }
    entityManager.persist(t);
    entityManager.getTransaction().commit();
    }
    
    public T ligar(T t) {
         return entityManager.merge(t);  
    }
    
    
    @Override
	public void excluir(T t) {    
    	entityManager.getTransaction().begin();
        t = ligar(t);
        entityManager.remove(t);
        entityManager.getTransaction().commit();
    }
    
    
    @Override
	@SuppressWarnings("unchecked")
    public List<T> pesquisar(String queryPesquisar,Map<String,Object> valores) {
        Query query = entityManager.createQuery(queryPesquisar);
        for (String chave: valores.keySet()) {
        	Object valor = valores.get(chave);
        	query.setParameter(chave,valor);
        }
        return query.getResultList();
    }	
    
}
