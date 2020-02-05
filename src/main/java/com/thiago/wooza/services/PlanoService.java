package com.thiago.wooza.services;

import com.thiago.wooza.entities.Plano;
import com.thiago.wooza.response.Response;

import java.util.List;

public interface PlanoService {

    Response<Plano> cadastrar(Plano plano);
    Response<Plano> atualizar(Plano plano);
    Response<Plano> remover(Plano plano);
    Response<List<Plano>> listarTodos();
    Response<List<Plano>> listarPorTipoEDdd(String tipo, int codigoArea);
    Response<List<Plano>> listarPorOperadoraEDdd(String operadora, int codigoArea);
    Response<List<Plano>> listarPorCodigoEDdd(String codigoPlano, int codigoArea);
}
