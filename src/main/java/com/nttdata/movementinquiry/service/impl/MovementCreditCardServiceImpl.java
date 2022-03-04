package com.nttdata.movementinquiry.service.impl;

import com.nttdata.movementinquiry.entity.MovementCreditCard;
import com.nttdata.movementinquiry.repository.MovementCreditCardRepository;
import com.nttdata.movementinquiry.service.MovementCreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class MovementCreditCardServiceImpl implements MovementCreditCardService {

    @Autowired
    MovementCreditCardRepository movementCreditCardRepository;

    @Override
    public Flux<MovementCreditCard> findAll() {
        return movementCreditCardRepository.findAll();
    }

    @Override
    public Mono<MovementCreditCard> save(MovementCreditCard entity) {
        entity.setDate(new Date());
        entity.setStatus(true);
        return movementCreditCardRepository.save(entity);
    }

    @Override
    public Mono<MovementCreditCard> update(MovementCreditCard entity) {
        return  movementCreditCardRepository.findById(entity.getId())
                .switchIfEmpty(Mono.empty())
                .flatMap(origin -> {
                    origin.setDescription(entity.getDescription());
                    origin.setStatus(entity.getStatus());
                    origin.setDate(entity.getDate());
                    origin.setAmount(entity.getAmount());
                    return movementCreditCardRepository.save(origin);
                });
    }

    @Override
    public Mono<MovementCreditCard> delete(String id) {
        return movementCreditCardRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .flatMap(origin -> {
                    origin.setStatus(false);
                    return movementCreditCardRepository.save(origin);
                });
    }

    @Override
    public Flux<MovementCreditCard> findByNumberAccount(String numberAccount) {
        return movementCreditCardRepository.findByNumberAccount(numberAccount);
    }
}