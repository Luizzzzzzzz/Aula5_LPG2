package org.example.Controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.example.Model.Estudante;
import org.example.persistence.JpaUtil;

import java.math.BigDecimal;
import java.util.List;

public class EstudanteController {
    EntityManager manager;
    EntityTransaction transaction;

    public EstudanteController(){
        manager = JpaUtil.getEntityManager();
        transaction = manager.getTransaction();
    }

    public void InsereEstudante(String nome, Character sexo, Boolean PCD){
        transaction.begin();
        Estudante estudante = new Estudante();
        estudante.setNome(nome);
        estudante.setSexo(sexo);
        estudante.setPCD(PCD);
        manager.persist(estudante);
        transaction.commit();
    }

    @SuppressWarnings("unchecked")
    public List<Estudante> consultaEstudantes() {
        Query query = manager.createQuery("select e from Estudante e");
        List<Estudante> estudantes = query.getResultList();
        return estudantes;
    }

    public Estudante consultaEstudantePorId(Long id) {
        Estudante estudante = manager.find(Estudante.class, id);
        return estudante;
    }

    public void alteraEstudante(Long id, String nome, Character sexo, Boolean PCD, BigDecimal IRA){
        transaction.begin();
        Estudante estudante = manager.find(Estudante.class, id);

        estudante.setNome(nome);
        estudante.setSexo(sexo);
        estudante.setPCD(PCD);
        estudante.setIRA(IRA);
        transaction.commit();
    }

    public void excluiEstudante(Long id){
        transaction.begin();
        Estudante estudante = manager.find(Estudante.class, id);
        manager.remove(estudante);
        transaction.commit();
    }

    public void finalizaEntityManager(){
        manager.close();
        JpaUtil.close();
    }
}
