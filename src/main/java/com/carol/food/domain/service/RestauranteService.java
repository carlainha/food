package com.carol.food.domain.service;

import com.carol.food.domain.model.Restaurante;
import com.carol.food.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante salvar(Restaurante restaurante){
        return  restauranteRepository.salvar(restaurante);
    }
}
