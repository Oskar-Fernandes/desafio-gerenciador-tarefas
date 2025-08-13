package br.com.desafio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class TarefaDAO {

    public void salvar(Tarefa tarefa) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(tarefa);
            tx.commit();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public Tarefa atualizar(Tarefa tarefa) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Tarefa tarefaAtualizada = null;
        try {
            tx.begin();
            tarefaAtualizada = em.merge(tarefa);
            tx.commit();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        return tarefaAtualizada;
    }

    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Tarefa tarefa = em.find(Tarefa.class, id);
            if (tarefa != null) {
                em.remove(tarefa);
            }
            tx.commit();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public Tarefa buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Tarefa.class, id);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public List<Tarefa> buscarTodas() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT t FROM Tarefa t ORDER BY t.deadline";
            TypedQuery<Tarefa> query = em.createQuery(jpql, Tarefa.class);
            return query.getResultList();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }



    public List<Tarefa> buscarComFiltros(String titulo, String responsavel) {
        EntityManager em = JPAUtil.getEntityManager();
        try {

            String jpql = "SELECT t FROM Tarefa t WHERE t.situacao = :situacao ";


            if (titulo != null && !titulo.trim().isEmpty()) {
                jpql += "AND lower(t.titulo) LIKE lower(:titulo) ";
            }
            if (responsavel != null && !responsavel.trim().isEmpty()) {
                jpql += "AND lower(t.responsavel) LIKE lower(:responsavel) ";
            }

            jpql += "ORDER BY t.deadline";

            TypedQuery<Tarefa> query = em.createQuery(jpql, Tarefa.class);


            query.setParameter("situacao", SituacaoTarefa.EM_ANDAMENTO);

            if (titulo != null && !titulo.trim().isEmpty()) {
                query.setParameter("titulo", "%" + titulo + "%");
            }
            if (responsavel != null && !responsavel.trim().isEmpty()) {
                query.setParameter("responsavel", "%" + responsavel + "%");
            }

            return query.getResultList();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }











}