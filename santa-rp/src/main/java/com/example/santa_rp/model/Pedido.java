package com.example.santa_rp.model;

import com.example.santa_rp.model.common.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;
    private String ahorro;
    private String departamento;
    private String direccion_empresa;
    private String direccion_envio;
    private String distrito;
    private String estado_concrecion;
    private String estado_pedido;
    private String fecha_envio_promedio;
    private String fecha_pedido;
    private String fecha_registro;
    private String motivo_social;
    private String provincia;
    private String razon_social;
    private String telefono_cliente;
    private String telefono_fijo;
    private Double total_pagar;
    private Double descuento;
    private Double costo_envio;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metodo_pago", referencedColumnName = "id_metodo_pago")
    private MetodoPago metodoPago;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado", referencedColumnName = "id_empleado")
    private Empleado empleado;
}
