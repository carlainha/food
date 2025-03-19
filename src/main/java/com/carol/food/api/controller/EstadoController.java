package com.carol.food.api.controller;

import com.carol.food.domain.model.Estado;
import com.carol.food.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> listar(){
       return estadoRepository.listar();
    }
}
