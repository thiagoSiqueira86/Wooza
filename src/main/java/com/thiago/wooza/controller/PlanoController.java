package com.thiago.wooza.controller;

import com.thiago.wooza.entities.Plano;
import com.thiago.wooza.enums.PlanoTipoEnum;
import com.thiago.wooza.services.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/planos")
@CrossOrigin(origins = {"*"})
public class PlanoController {

    @Autowired
    private PlanoService service;

    @GetMapping
    public ResponseEntity<List<Plano>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping(value = "/pesquisarPorTipo/{tipo}/{ddd}")
    public ResponseEntity<List<Plano>> listarPorTipoDdd(
            @PathVariable("tipo")PlanoTipoEnum tipo,
            @PathVariable("ddd") int ddd){
        return ResponseEntity.ok(service.listarPorTipoDdd(tipo, ddd));
    }

    @GetMapping(value = "pesquisarPorOperadora/{operadora}/{ddd}")
    public ResponseEntity<List<Plano>> listarPorOperadoraDdd(
            @PathVariable("operadora") String operadora,
            @PathVariable("ddd") int ddd){
        return ResponseEntity.ok(service.listarPorOperadraDdd(operadora, ddd));
    }

    @GetMapping(value = "pesquisarPorCodigo/{codigoPlano}/{ddd}")
    public ResponseEntity<List<Plano>> listarPorCodigoDdd(
            @PathVariable("codigoPlano") String codigoPlano,
            @PathVariable("ddd") int ddd){
        return ResponseEntity.ok(service.listarPorCodigoDdd(codigoPlano, ddd));
    }

    @PostMapping
    public Plano cadastrar(@RequestBody Plano plano){
        return service.salvar(plano);
    }

    @PutMapping
    public Plano atualizar(@RequestBody Plano plano){
        return service.atualizar(plano);
    }

    @DeleteMapping("/{idPlano}")
    public ResponseEntity remover(@PathVariable("idPlano") Long idPlano){
        service.remover(idPlano);

        return (ResponseEntity) ResponseEntity.noContent();
    }
}
