package com.thiago.wooza.repositorys;

import com.thiago.wooza.entities.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanoRepository extends JpaRepository<Plano, Long> {

    @Query("SELECT p FROM Plano p JOIN DDD d WHERE p.tipo = :tipo AND d.codigoArea = :codigoArea")
    List<Plano> findByTipoAndDdd(@Param("tipo") String tipo, @Param("codigoArea") int codigoArea);

    @Query("SELECT p FROM Plano p JOIN DDD d WHERE p.operadora = :operadora AND d.codigoArea = :codigoArea")
    List<Plano> findByOperadoraAndDdd(@Param("operadora")String operadora, @Param("codigoArea") int codigoArea);

    @Query("SELECT p FROM Plano p JOIN DDD d WHERE p.codigoPlano = :codigoPlano AND d.codigoArea = :codigoArea")
    List<Plano> findByCodigoAndDdd(@Param("codigoPlano") String codigoPlano, @Param("codigoArea") int codigoArea);
}
