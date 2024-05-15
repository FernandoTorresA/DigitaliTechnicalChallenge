package com.digitali.digitalitechnicalchallenge.Controllers;

import com.digitali.digitalitechnicalchallenge.Services.ProblemasServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Component
@RestController
@RequestMapping("/digitali/problemas")
public class ProblemasController {

    @Autowired
    ProblemasServices problemasServices;

    //PROBLEMAS MATEMÁTICOS (los agregué aquí en otro controller para evitar hacer otro componente)

    //1- Múltiples de 3 o 5
    @GetMapping("/getMultiplos")
    public ResponseEntity<Integer> getMultiplos(@RequestParam("value") int value) {
        log.info("[getMultiplos] Request recieved...");
        return ResponseEntity.ok(problemasServices.getMultiplos(value));
    }

    //2- Factor primo
    @GetMapping("/getFactorPrimo")
    public ResponseEntity<Long> getFactorPrimo(@RequestParam("value") Long value) {
        log.info("[getFactorPrimo] Request recieved...");
        return ResponseEntity.ok(problemasServices.getFactorPrimo(value));
    }
}
