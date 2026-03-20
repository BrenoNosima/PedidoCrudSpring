package com.bn.pedidoscs.repositories;

import com.bn.pedidoscs.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
