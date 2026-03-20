package com.bn.pedidoscs.controllers;

import com.bn.pedidoscs.models.PedidoModel;
import com.bn.pedidoscs.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoModel> salvar(@RequestBody PedidoModel pedidoModel) {
        PedidoModel request = pedidoService.criar(pedidoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/pedidos/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<PedidoModel>> listar() {
        List<PedidoModel> request = pedidoService.listar();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoModel> procurarPorId(@PathVariable Long id) {
        PedidoModel request = pedidoService.procurarPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
