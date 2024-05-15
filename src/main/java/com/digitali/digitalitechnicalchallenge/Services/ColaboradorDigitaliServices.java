package com.digitali.digitalitechnicalchallenge.Services;

import com.digitali.digitalitechnicalchallenge.Entities.Colaborador;
import java.util.List;

public interface ColaboradorDigitaliServices {

    List<Colaborador> getAll();

    Colaborador createColaborador(Colaborador colaborador);

    Colaborador getByRut(String rut);

    Colaborador updateColaborador(String rut, Colaborador newColaboradorValues);

    boolean deleteColaborador(String rut);

    String getFechaNacimientoByRut(String rut);
}
