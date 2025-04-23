package com.carol.food.domain.service;

import com.carol.food.domain.exception.EntidadeEmUsoException;
import com.carol.food.domain.exception.EntidadeNaoEncontradaException;
import com.carol.food.domain.model.FormaPagamento;
import com.carol.food.domain.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    public FormaPagamento salvar(FormaPagamento formaPagamento){
        return formaPagamentoRepository.salvar(formaPagamento);
    }

    public void excluir (Long id){
        try{
            formaPagamentoRepository.remover(id);
        }
        catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format("Forma Pagamento ou código %d não pode ser removida, pois está em uso.", id));
        }
        catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de forma pagamento com código %d", id));
        }
    }
}
