package com.carol.food.infrastructure.repository;

import com.carol.food.domain.model.Cidade;
import com.carol.food.domain.repository.CidadeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cidade> listar(Long id) {
        return manager.createQuery("from Cidade",Cidade.class).getResultList();
    }

    @Override
    public Cidade buscar(Long id) {
        return null;
    }

    @Override
    public Cidade salvar(Cidade cidade) {
        return null;
    }

    @Override
    public void remover(Long id) {

    }
}
