package com.thiago.wooza.controller;

import com.thiago.wooza.entities.Plano;
import com.thiago.wooza.enums.PlanoTipoEnum;
import com.thiago.wooza.services.PlanoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/planos")
@CrossOrigin(origins = {"*"})
@Api(value = "Endpoint Plano", tags = "CRUD")
public class PlanoController {

    @Autowired
    private PlanoService service;

    @GetMapping
    @ApiOperation(value = "Lista todos os planos cadastrados")
    public ResponseEntity<List<Plano>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping(value = "/pesquisarPorTipo/{tipo}/{ddd}")
    @ApiOperation(value = "Lista os planos por tipo e DDD")
    public ResponseEntity<List<Plano>> listarPorTipoDdd(
            @PathVariable("tipo")PlanoTipoEnum tipo,
            @PathVariable("ddd") int ddd){
        return ResponseEntity.ok(service.listarPorTipoDdd(tipo, ddd));
    }

    @GetMapping(value = "pesquisarPorOperadora/{operadora}/{ddd}")
    @ApiOperation(value = "Lista os planos por operadora e DDD")
    public ResponseEntity<List<Plano>> listarPorOperadoraDdd(
            @PathVariable("operadora") String operadora,
            @PathVariable("ddd") int ddd){
        return ResponseEntity.ok(service.listarPorOperadraDdd(operadora, ddd));
    }

    @GetMapping(value = "pesquisarPorCodigo/{codigoPlano}/{ddd}")
    @ApiOperation(value = "Lista os planos pelo código do plano e DDD")
    public ResponseEntity<List<Plano>> listarPorCodigoDdd(
            @PathVariable("codigoPlano") String codigoPlano,
            @PathVariable("ddd") int ddd){
        return ResponseEntity.ok(service.listarPorCodigoDdd(codigoPlano, ddd));
    }

    @PostMapping
    @ApiOperation(value = "Cadastra um novo plano")
    public Plano cadastrar(@RequestBody Plano plano){
        return service.salvar(plano);
    }

    @PutMapping
    @ApiOperation(value = "Atualiza um plano existente")
    public Plano atualizar(@RequestBody Plano plano){
        return service.atualizar(plano);
    }

    @DeleteMapping("/{idPlano}")
    @ApiOperation(value = "Remove um plano existente")
    public ResponseEntity remover(@PathVariable("idPlano") Long idPlano){
        service.remover(idPlano);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Plano removido com sucesso");
    }
}
