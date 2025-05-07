package com.carol.food.api.controller;

import com.carol.food.domain.exception.EntidadeEmUsoException;
import com.carol.food.domain.exception.EntidadeNaoEncontradaException;
import com.carol.food.domain.model.Cozinha;
import com.carol.food.domain.model.FormaPagamento;
import com.carol.food.domain.repository.FormaPagamentoRepository;
import com.carol.food.domain.service.FormaPagamentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/formapagamentos")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @GetMapping
    public List<FormaPagamento> listar(){
        return  formaPagamentoRepository.findAll();
    }

    @GetMapping("/{formapagamentoId}")
    public ResponseEntity<FormaPagamento> buscar(@PathVariable Long formapagamentoId){
        Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(formapagamentoId);

        if (formaPagamento.isPresent()){
            return ResponseEntity.ok(formaPagamento.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FormaPagamento> adicionar(@RequestBody FormaPagamento formaPagamento){
        formaPagamento = formaPagamentoService.salvar(formaPagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(formaPagamento);
    }

    @PutMapping("/{formapagamentoId}")
    public ResponseEntity<FormaPagamento> atualizar(@PathVariable Long formapagamentoId,@RequestBody FormaPagamento formaPagamento){
        Optional<FormaPagamento> formaPagamentoAtual = formaPagamentoRepository.findById(formapagamentoId);

        if (formaPagamentoAtual.isPresent()){
            BeanUtils.copyProperties(formaPagamento, formaPagamentoAtual,"id");

            FormaPagamento formaPagamentoSalvo = formaPagamentoService.salvar(formaPagamentoAtual.get());
            return ResponseEntity.ok(formaPagamentoSalvo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{formapagamentoId}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long formapagamentoId) {
        try{
            formaPagamentoService.excluir(formapagamentoId);
            return ResponseEntity.notFound().build();
        }
        catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }
        catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
}
