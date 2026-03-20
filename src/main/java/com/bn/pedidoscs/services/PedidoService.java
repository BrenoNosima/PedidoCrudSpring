package com.bn.pedidoscs.services;

import com.bn.pedidoscs.models.PedidoModel;
import com.bn.pedidoscs.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoModel criar(PedidoModel pedidoModel) {
        return pedidoRepository.save(pedidoModel);
    }

    public List<PedidoModel> listar() {
        return pedidoRepository.findAll();
    }

    public PedidoModel procurarPorId(Long id) {
        return pedidoRepository.findById(id).get();
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
