package com.carol.food.domain.service;

import com.carol.food.domain.model.FormaPagamento;
import com.carol.food.domain.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    public FormaPagamento salvar(FormaPagamento formaPagamento){
        return formaPagamentoRepository.salvar(formaPagamento);
    }

}
