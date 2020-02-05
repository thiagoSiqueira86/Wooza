package com.thiago.wooza.services.impl;

import com.thiago.wooza.entities.Plano;
import com.thiago.wooza.response.Response;
import com.thiago.wooza.services.PlanoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoServiceImpl implements PlanoService {
    @Override
    public Response<Plano> cadastrar(Plano plano) {
        return null;
    }

    @Override
    public Response<Plano> atualizar(Plano plano) {
        return null;
    }

    @Override
    public Response<Plano> remover(Plano plano) {
        return null;
    }

    @Override
    public Response<List<Plano>> listarTodos() {
        return null;
    }

    @Override
    public Response<List<Plano>> listarPorTipoEDdd(String tipo, int codigoArea) {
        return null;
    }

    @Override
    public Response<List<Plano>> listarPorOperadoraEDdd(String operadora, int codigoArea) {
        return null;
    }

    @Override
    public Response<List<Plano>> listarPorCodigoEDdd(String codigoPlano, int codigoArea) {
        return null;
    }
}
