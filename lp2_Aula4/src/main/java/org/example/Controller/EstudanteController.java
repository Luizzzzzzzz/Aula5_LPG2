package org.example.Controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.example.Model.Estudante;
import org.example.persistence.JpaUtil;

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
        Query query = manager.createQuery("select 1 from Estudante 1");
        List<Estudante> estudantes = query.getResultList();
        return estudantes;
    }

    public Estudante consultaEstudantePorId(Long id) {
        Estudante estudante = manager.find(Estudante.class, id);
        return estudante;
    }
}
