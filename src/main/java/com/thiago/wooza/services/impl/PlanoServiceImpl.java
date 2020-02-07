package com.thiago.wooza.services.impl;

import com.thiago.wooza.entities.Plano;
import com.thiago.wooza.enums.PlanoTipoEnum;
import com.thiago.wooza.exceptions.RecursoNaoEncontradoException;
import com.thiago.wooza.repositories.PlanoRepository;
import com.thiago.wooza.services.PlanoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoServiceImpl implements PlanoService {

    private static final Logger LOGGER = LogManager.getLogger(PlanoServiceImpl.class);

    @Autowired
    private PlanoRepository repository;

    @Override
    public Plano salvar(Plano p) {
        return repository.save(p);
    }

    @Override
    public Plano atualizar(Plano p) {
        Plano entity = repository.findById(p.getId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Plano informado não localizado"));

        entity.setCodigoPlano(p.getCodigoPlano());
        entity.setTipo(p.getTipo());
        entity.setOperadora(p.getOperadora());
        entity.setMinutos(p.getMinutos());
        entity.setFranquiaInternet(p.getFranquiaInternet());
        entity.setValor(p.getValor());
        entity.setDdds(p.getDdds());

        return repository.save(entity);
    }

    @Override
    public void remover(Long idPlano) {
        Plano entity = repository.findById(idPlano)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Plano informado não localizado"));

        repository.delete(entity);
    }

    @Override
    public List<Plano> listarTodos() {
        return repository.findAll();
    }

    @Override
    public List<Plano> listarPorTipoDdd(PlanoTipoEnum tipo, int codigoArea) {
        return repository.findPlanoByTipoAndDdd(tipo, codigoArea);
    }

    @Override
    public List<Plano> listarPorOperadraDdd(String operadora, int codigoArea) {
        return repository.findPlanoByOperadoraAndDdd(operadora, codigoArea);
    }

    @Override
    public List<Plano> listarPorCodigoDdd(String codigoPlano, int codigoArea) {
        return repository.findPlanoByCodigoAndDdd(codigoPlano, codigoArea);
    }
}
