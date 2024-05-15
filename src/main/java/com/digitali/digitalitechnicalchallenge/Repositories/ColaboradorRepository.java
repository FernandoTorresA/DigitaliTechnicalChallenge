package com.digitali.digitalitechnicalchallenge.Repositories;

import com.digitali.digitalitechnicalchallenge.Entities.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    @Query("SELECT dc FROM Colaborador dc WHERE dc.rut= :rut")
    Colaborador getByRut(@Param("rut") String rut);
}
