package com.carol.food.domain.service;

import com.carol.food.domain.model.Estado;
import com.carol.food.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado){
        return estadoRepository.salvar(estado);
    }
}
