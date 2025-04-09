package com.carol.food.domain.service;

import com.carol.food.domain.model.Cidade;
import com.carol.food.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade salvar(Cidade cidade){
        return cidadeRepository.salvar(cidade);
    }
}
