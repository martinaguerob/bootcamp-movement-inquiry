package com.nttdata.movementinquiry.controller;

import com.nttdata.movementinquiry.entity.MovementBankAccount;
import com.nttdata.movementinquiry.entity.MovementCreditCard;
import com.nttdata.movementinquiry.service.MovementCreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movements")
public class MovementCreditCardController {

    @Autowired
    MovementCreditCardService movementCreditCardService;

    @GetMapping("/credit-card")
    public Flux<MovementCreditCard> getMovementsCreditCard(){
        System.out.println("Listar movimientos");
        return movementCreditCardService.findAll();
    }

    @PostMapping("/credit-card")
    public Mono<MovementCreditCard> saveMovementCreditCard(@RequestBody MovementCreditCard movementCreditCard){
        System.out.println("Guardar movimientos");
        return movementCreditCardService.save(movementCreditCard);
    }

    @PutMapping("/credit-card/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<MovementCreditCard> updateMovements(@RequestBody MovementCreditCard movementCreditCard){
        System.out.println("Actualizar movimiento");
        return movementCreditCardService.update(movementCreditCard);
    }

    @PutMapping("/credit-card/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<MovementCreditCard> deleteMovements(@PathVariable String id){
        System.out.println("Eliminar movimiento - cambiar de estado");
        return movementCreditCardService.delete(id);
    }

    @GetMapping("/credit-card/number/{numberAccount}")
    @ResponseStatus(HttpStatus.OK)
    public  Flux<MovementCreditCard> findMovementsByAccount(@PathVariable String numberAccount){
        System.out.println("Listar movimientos de una cuenta");
        return movementCreditCardService.findByNumberAccount(numberAccount);
    }
}
