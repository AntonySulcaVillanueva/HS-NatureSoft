package com.eon.model.Venta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.eon.model.Cliente;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalOriginal;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalConDescuento;

    @Column(nullable = false)
    private LocalDateTime fechaPedidoOriginal = LocalDateTime.now();

    private String nombreClienteOriginal;

    private String direccionEnvioOriginal;

    @Column(length = 50)
    private String estado;

    @Column(length = 255)
    private String direccionEnvio;

    @Column(length = 50)
    private String metodoPago;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles = new ArrayList<>();

    public void addDetalle(DetallePedido detalle) {
        if (this.detalles == null) {
            this.detalles = new ArrayList<>();
        }
        this.detalles.add(detalle);
        detalle.setPedido(this);
        recalcularTotales(); 
    }

    public void removeDetalle(DetallePedido detalle) {
        if (this.detalles != null) {
            this.detalles.remove(detalle);
            detalle.setPedido(null);
            recalcularTotales(); 
        }
    }

    public Pedido(Cliente cliente, String direccionEnvio, String metodoPago) {
        this.cliente = cliente;
        this.direccionEnvioOriginal = direccionEnvio;
        this.metodoPago = metodoPago;
        this.fechaPedidoOriginal = LocalDateTime.now();
        if (cliente != null) {
            this.nombreClienteOriginal = cliente.getNombre();
        }
        this.totalOriginal = BigDecimal.ZERO;
        this.totalConDescuento = BigDecimal.ZERO;
    }

    public void recalcularTotales() {
        BigDecimal nuevoTotalOriginal = BigDecimal.ZERO;
        BigDecimal nuevoTotalConDescuento = BigDecimal.ZERO;

        for (DetallePedido detalle : this.detalles) {
            nuevoTotalOriginal = nuevoTotalOriginal.add(detalle.getSubtotal());
            nuevoTotalConDescuento = nuevoTotalConDescuento.add(detalle.getSubtotalFinalConDescuento());
        }
        this.totalOriginal = nuevoTotalOriginal;
        this.totalConDescuento = nuevoTotalConDescuento;
    }
}