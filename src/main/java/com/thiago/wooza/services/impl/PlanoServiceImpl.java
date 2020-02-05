package com.thiago.wooza.services.impl;

import com.thiago.wooza.constants.BaseConstants;
import com.thiago.wooza.entities.Plano;
import com.thiago.wooza.exceptions.RecursoNaoEncontradoException;
import com.thiago.wooza.repositorys.PlanoRepository;
import com.thiago.wooza.response.Response;
import com.thiago.wooza.services.PlanoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoServiceImpl implements PlanoService {

    private static final Logger LOGGER = LogManager.getLogger(PlanoServiceImpl.class);

    @Autowired
    private PlanoRepository repository;

    @Override
    public Response<Plano> cadastrar(Plano plano) {
        Response<Plano> response = new Response<>();

        try{
            Plano p = repository.save(plano);
            response.setData(p);
            response.setStatus(HttpStatus.OK.value());
        }catch (DataAccessException ex){
            LOGGER.error(".cadastrar::" + ex.getMessage(), ex);
            response.getErrors().add(BaseConstants.ERRO_INESPERAD);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return response;
    }

    @Override
    public Response<Plano> atualizar(Plano plano) {
        Response<Plano> response = new Response<>();

        try{
            Plano p = repository.findById(plano.getId())
                    .orElseThrow(() -> new RecursoNaoEncontradoException("Plano informado não localizado."));

            p.setCodigoPlano(plano.getCodigoPlano());
            p.setDdds(plano.getDdds());
            p.setFranquiaInternet(plano.getFranquiaInternet());
            p.setMinutos(plano.getMinutos());
            p.setOperadora(plano.getOperadora());
            p.setTipo(plano.getTipo());
            p.setValor(plano.getValor());

            repository.save(p);

            response.setData(p);
            response.setStatus(HttpStatus.OK.value());
        }catch (RecursoNaoEncontradoException ex){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.getErrors().add("Plano informado não localizado.");
        }catch (DataAccessException ex){
            LOGGER.error(".atualizar::" + ex.getMessage(), ex);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.getErrors().add(BaseConstants.ERRO_INESPERAD);
        }

        return response;
    }

    @Override
    public Response<Plano> remover(Long idPlano) {
        Response<Plano> response = new Response<>();

        try{
            Plano p = repository.findById(idPlano)
                    .orElseThrow(() -> new RecursoNaoEncontradoException("Plano informado não localizado."));

            repository.delete(p);

            response.setStatus(HttpStatus.NO_CONTENT.value());
        }catch (RecursoNaoEncontradoException ex){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.getErrors().add("Plano informado não localizado.");
        }catch (DataAccessException ex){
            LOGGER.error(".remover::" + ex.getMessage(), ex);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.getErrors().add(BaseConstants.ERRO_INESPERAD);
        }

        return response;
    }

    @Override
    public Response<List<Plano>> listarTodos() {
        Response<List<Plano>> response = new Response<>();

        try{
            List<Plano> planos = repository.findAll();

            response.setData(planos);
            response.setStatus(HttpStatus.OK.value());
        }catch (DataAccessException ex){
            LOGGER.error(".listarTodos::" + ex.getMessage(), ex);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.getErrors().add(BaseConstants.ERRO_INESPERAD);
        }

        return response;
    }

    @Override
    public Response<List<Plano>> listarPorTipoEDdd(String tipo, int codigoArea) {
        Response<List<Plano>> response = new Response<>();

        try{
            List<Plano> planos = repository.findByTipoAndDdd(tipo, codigoArea);

            response.setData(planos);
            response.setStatus(HttpStatus.OK.value());
        }catch (DataAccessException ex){
            LOGGER.error(".::" + ex.getMessage(), ex);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.getErrors().add(BaseConstants.ERRO_INESPERAD);
        }

        return response;
    }

    @Override
    public Response<List<Plano>> listarPorOperadoraEDdd(String operadora, int codigoArea) {
        Response<List<Plano>> response = new Response<>();

        try{
            List<Plano> planos = repository.findByOperadoraAndDdd(operadora, codigoArea);

            response.setData(planos);
            response.setStatus(HttpStatus.OK.value());
        }catch (DataAccessException ex){
            LOGGER.error(".::" + ex.getMessage(), ex);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.getErrors().add(BaseConstants.ERRO_INESPERAD);
        }

        return response;
    }

    @Override
    public Response<List<Plano>> listarPorCodigoEDdd(String codigoPlano, int codigoArea) {
        Response<List<Plano>> response = new Response<>();

        try{
            List<Plano> planos = repository.findByCodigoAndDdd(codigoPlano, codigoArea);

            response.setData(planos);
            response.setStatus(HttpStatus.OK.value());
        }catch (DataAccessException ex){
            LOGGER.error(".::" + ex.getMessage(), ex);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.getErrors().add(BaseConstants.ERRO_INESPERAD);
        }

        return response;
    }
}
