package com.nttdata.movementinquiry.controller;

import com.nttdata.balanceinquiry.model.Inquiry;
import com.nttdata.balanceinquiry.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/inquiry")
public class InquiryController {

    @Autowired
    InquiryService inquiryService;

    @GetMapping
    public Flux<Inquiry> getMovements(){
        System.out.println("Listar movimientos");
        return inquiryService.findAll();
    }

    @PostMapping
    public Mono<Inquiry> saveMovement(@RequestBody Inquiry inquiry){
        System.out.println("Guardar movimientos");
        return inquiryService.save(inquiry);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Inquiry> updateMovements(@RequestBody Inquiry inquiry){
        System.out.println("Actualizar movimiento");
        return inquiryService.update(inquiry);
    }

    @PutMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Inquiry> deleteMovements(@PathVariable String id){
        System.out.println("Eliminar movimiento - cambiar de estado");
        return inquiryService.delete(id);
    }

    @GetMapping("/{account}")
    @ResponseStatus(HttpStatus.OK)
    public  Flux<Inquiry> findMovementsByAccount(@PathVariable String account){
        System.out.println("Listar movimientos de una cuenta");
        return inquiryService.findByAccount(account);
    }

}
