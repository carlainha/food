package com.carol.food.domain.service;

import com.carol.food.domain.exception.EntidadeEmUsoException;
import com.carol.food.domain.exception.EntidadeNaoEncontradaException;
import com.carol.food.domain.model.Restaurante;
import com.carol.food.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante salvar(Restaurante restaurante){
        return  restauranteRepository.save(restaurante);
    }

    public void excluir(Long id) {
        try{
            restauranteRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format("Restaurante ou código %d não pode ser removida, pois está em uso.", id));
        }
        catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de restaurante com código %d", id));
        }
    }
}
