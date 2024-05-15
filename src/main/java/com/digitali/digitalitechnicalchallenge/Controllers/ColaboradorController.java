package com.digitali.digitalitechnicalchallenge.Controllers;

import com.digitali.digitalitechnicalchallenge.Entities.Colaborador;
import com.digitali.digitalitechnicalchallenge.Services.ColaboradorDigitaliServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Component
@RestController
@RequestMapping("/digitali/colaboradores")
public class ColaboradorController {

    @Autowired
    ColaboradorDigitaliServices colaboradorDigitaliServices;

    //No solicitado, pero es útil para probar los cambios
    @GetMapping("/getAll")
    public ResponseEntity<List<Colaborador>> getAllColaborador() {
        log.info("[getAllColaborador] Request recieved...");
        List<Colaborador> colaboradorList = colaboradorDigitaliServices.getAll();
        return ResponseEntity.ok(colaboradorList);
    }

    //1- Ingresar colaborador
    @PostMapping()
    public ResponseEntity<Colaborador> createColaborador(@RequestBody Colaborador colaborador) {
        log.info("[createColaborador] Request recieved...");
        Colaborador Colaborador = colaboradorDigitaliServices.createColaborador(colaborador);
        return ResponseEntity.ok(Colaborador);
    }

    //2- Obtener por rut
    //utilizo @RequestParam en lugar de @PathVariable por practicidad en el postman, puedo cambiar el RQ rápidamente por params
    @GetMapping()
    public ResponseEntity<Colaborador> getColaborador(@RequestParam("rut") String rut) {
        log.info("[getColaborador] Request recieved...");
        Colaborador colaborador = colaboradorDigitaliServices.getByRut(rut);
        return ResponseEntity.ok(colaborador);
    }


    //3- Actualizar dirección (se puede refactorizar el service)
    @PutMapping("/{rut}")
    public ResponseEntity<Colaborador> updateColaborador(@PathVariable String rut, @RequestBody Colaborador newColaboradorValues) {
        log.info("[updateColaborador] Request recieved...");
        Colaborador colaborador = colaboradorDigitaliServices.updateColaborador(rut, newColaboradorValues);
        if (colaborador != null) {
            return ResponseEntity.ok(colaborador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //4- Borrar un colaborador
    @DeleteMapping("/{rut}")
    public ResponseEntity<Boolean> deleteColaborador(@PathVariable String rut) {
        log.info("[deleteColaborador] Request recieved...");
        if (colaboradorDigitaliServices.deleteColaborador(rut)) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //5- Obtener fecha de nacimiento
    @GetMapping("/getFechaNacimiento")
    public String getFechaNacimientoColaborador(@RequestParam("rut") String rut) {
        log.info("[getFechaNacimientoColaborador] Request recieved...");
        return colaboradorDigitaliServices.getFechaNacimientoByRut(rut);
    }
}
