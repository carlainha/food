package com.carol.food.api.controller;

import com.carol.food.domain.model.Cozinha;
import com.carol.food.domain.model.Restaurante;
import com.carol.food.domain.repository.RestauranteRepository;
import com.carol.food.domain.service.RestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public List<Restaurante> listar(){
        return restauranteRepository.listar();
    }

    @GetMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId){
        Restaurante restaurante = restauranteRepository.buscar(restauranteId);

        if (restaurante != null){
            return  ResponseEntity.ok(restaurante);
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante adicionar(@RequestBody Restaurante restaurante){
        return restauranteService.salvar(restaurante);
    }

    @PutMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> atualizar(@PathVariable Long restauranteId,@RequestBody Restaurante restaurante){
        Restaurante restauranteAtual = restauranteRepository.buscar(restauranteId);

        if (restauranteAtual != null){
            BeanUtils.copyProperties(restaurante,restauranteAtual, "id");

            restauranteAtual = restauranteRepository.salvar(restauranteAtual);
            return ResponseEntity.ok(restauranteAtual);
        }
        return ResponseEntity.notFound().build();
    }
}
