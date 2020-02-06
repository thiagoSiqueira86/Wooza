package com.thiago.wooza.repositorys;

import com.thiago.wooza.entities.Plano;
import com.thiago.wooza.enums.PlanoTipoEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanoRepository extends JpaRepository<Plano, Long> {

    @Query("SELECT p FROM Plano p INNER JOIN p.ddds d WHERE p.tipo = :tipo AND d.codigoArea = :codigoArea")
    List<Plano> findPlanoByTipoAndDdd(
            @Param("tipo")PlanoTipoEnum tipo,
            @Param("codigoArea") int codigoArea);

    @Query("SELECT p FROM Plano p INNER JOIN p.ddds d WHERE p.operadora = :operadora AND d.codigoArea = :codigoArea")
    List<Plano> findPlanoByOperadoraAndDdd(
            @Param("operadora") String operadora,
            @Param("codigoArea") int codigoArea);

    @Query("SELECT p FROM Plano p INNER JOIN p.ddds d WHERE p.codigoPlano LIKE LOWER (CONCAT ('%', :codigoPlano, '%')) AND d.codigoArea = :codigoArea")
    List<Plano> findPlanoByCodigoAndDdd(
            @Param("codigoPlano") String codigoPlano,
            @Param("codigoArea") int codigoArea);
}
