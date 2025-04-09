package com.carol.food.api.controller;

import com.carol.food.domain.model.FormaPagamento;
import com.carol.food.domain.repository.FormaPagamentoRepository;
import com.carol.food.domain.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formapagamentos")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @GetMapping
    public List<FormaPagamento> listar(){
        return  formaPagamentoRepository.listar();
    }

    @GetMapping("/{formapagamentoId}")
    public ResponseEntity<FormaPagamento> buscar(@PathVariable Long formapagamentoId){
        FormaPagamento formaPagamento = formaPagamentoRepository.buscar(formapagamentoId);

        if (formaPagamento != null){
            return ResponseEntity.ok(formaPagamento);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FormaPagamento adicionar(@RequestBody FormaPagamento formaPagamento){
        return formaPagamentoService.salvar(formaPagamento);
    }
}
