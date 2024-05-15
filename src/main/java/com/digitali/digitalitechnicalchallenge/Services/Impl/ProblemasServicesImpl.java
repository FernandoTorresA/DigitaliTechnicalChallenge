package com.digitali.digitalitechnicalchallenge.Services.Impl;

import com.digitali.digitalitechnicalchallenge.Services.ProblemasServices;
import org.springframework.stereotype.Service;

@Service
public class ProblemasServicesImpl implements ProblemasServices {

    @Override
    public Integer getMultiplos(int value) {
        int sum = 0;
        for (int i = 1; i < value; i++) {
            //validando si el valor actual es múltiplo o no (de ambos)
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    @Override
    public Long getFactorPrimo(Long value) {

        long factorMayor = 1L;
        //primer divisor posible...
        int divisor = 2;

        //primero, validar el value de entrada antes del ciclo...
        while (value > 1) {
            if (value % divisor == 0) {
                factorMayor = (long) divisor;
                //Reducir el número dividiéndolo por el divisor y seguimos...
                value /= divisor;
            } else {
                //siguiente divisor si no cumple....
                divisor++;
            }
        }
        return factorMayor;
    }
}
