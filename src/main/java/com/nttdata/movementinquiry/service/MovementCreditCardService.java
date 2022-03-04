package com.nttdata.movementinquiry.service;

import com.nttdata.movementinquiry.entity.MovementBankAccount;
import com.nttdata.movementinquiry.entity.MovementCreditCard;
import reactor.core.publisher.Flux;

public interface MovementCreditCardService extends CrudService<MovementCreditCard, String> {
    Flux<MovementCreditCard>findByNumberAccount(String numberAccount);
}
