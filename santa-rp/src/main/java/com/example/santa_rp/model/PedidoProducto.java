package com.example.santa_rp.model;

import com.example.santa_rp.model.common.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido_productos")
public class PedidoProducto extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;
    private Double precio_unidad;
    private Double precio_docena;
    private Double descuento_docena;
    private Double costo_general_docena_unidades;
    private Double descuento_docenas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto_pedido", referencedColumnName = "id_producto")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedido pedido;
}
