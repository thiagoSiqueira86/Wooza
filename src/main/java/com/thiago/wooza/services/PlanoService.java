package com.thiago.wooza.services;


import com.thiago.wooza.entities.Plano;
import com.thiago.wooza.enums.PlanoTipoEnum;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlanoService {

    Plano salvar(Plano p);
    Plano atualizar(Plano p);
    void remover(Long idPlano);
    List<Plano> listarTodos();
    List<Plano> listarPorTipoDdd(PlanoTipoEnum tipo, int codigoArea);
    List<Plano> listarPorOperadraDdd(String operadora, int codigoArea);
    List<Plano> listarPorCodigoDdd(String codigoPlano, int codigoArea);
}
