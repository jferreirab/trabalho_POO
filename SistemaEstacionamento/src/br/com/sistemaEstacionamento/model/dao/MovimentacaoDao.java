/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.model.dao;

import br.com.sistemaEstacionamento.model.domain.Cliente;
import br.com.sistemaEstacionamento.model.domain.Movimentacao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author Aurel
 */
public class MovimentacaoDao implements IMovimentacaoDao {

    private EntityManager entityManager;
    private ICrudDao<Movimentacao, Integer> crudDao;

    public MovimentacaoDao() {
        entityManager = Conexao.getEntityManager();
        crudDao = new CrudDao<>(entityManager);
    }

    public void salvarAtualizar(Movimentacao movimentacao) {
        crudDao.salvarAtualizar(movimentacao, movimentacao.getCodigo());
    }

    @Override
    public void excluir(Movimentacao cliente) {
        crudDao.excluir(cliente);
    }

    @Override
    public List<Movimentacao> pesquisar(Movimentacao movimentacao) {
        return crudDao.pesquisar(getQueryPesquisar(movimentacao), getValoresParametros(movimentacao));
    }

    private String getQueryPesquisar(Movimentacao movimentacao) {
        StringBuilder sb = new StringBuilder("from Movimentacao m where 1 = 1 and m.dtSaida is null ");
        if (movimentacao.getCodigo() != null) {
            sb.append("and m.codigo = :codigo ");
        }
        if (movimentacao.getDsPlaca() != null && !movimentacao.getDsPlaca().equals("")) {
            sb.append("and m.dsPlaca like :dsPlaca");
        }
        return sb.toString();
    }

    private Map<String, Object> getValoresParametros(Movimentacao movimentacao) {
        Map<String, Object> valores = new HashMap<>();
        if (movimentacao.getCodigo() != null) {
            valores.put("codigo", movimentacao.getCodigo());
        }
        if (movimentacao.getDsPlaca() != null && !movimentacao.getDsPlaca().equals("")) {
            valores.put("dsPlaca", "%" + movimentacao.getDsPlaca()+ "%");
        }
        return valores;
    }










}
