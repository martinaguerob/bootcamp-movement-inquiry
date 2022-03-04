package com.nttdata.movementinquiry.repository;

import com.nttdata.movementinquiry.entity.MovementBankAccount;
import com.nttdata.movementinquiry.entity.MovementCreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MovementCreditCardRepository extends ReactiveMongoRepository<MovementCreditCard, String> {

    Flux<MovementCreditCard> findByNumberAccount(String numberAccount);
}
