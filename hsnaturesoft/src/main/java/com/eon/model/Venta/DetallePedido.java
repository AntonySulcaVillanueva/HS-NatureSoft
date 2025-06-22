package com.eon.model.Venta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import com.eon.model.Producto;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_promocion_aplicada")
    private Promocion promocionAplicada;

    private Long idProductoOriginal;

    @Column(nullable = false, length = 255)
    private String nombreProducto;

    @Column(nullable = false)
    private BigDecimal precioUnitarioAlMomento;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private BigDecimal subtotal;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal descuentoAplicadoPorPromocion = BigDecimal.ZERO;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioFinalUnitarioConDescuento;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotalFinalConDescuento;

    private String nombreCategoriaProducto; 
    
    private String skuProducto;
    private String marcaProducto;
    private String unidadMedidaProducto;
    private BigDecimal precioDocenaAlMomento;
    private BigDecimal descuentoDocenasAlMomento;


    public DetallePedido(Producto producto, Integer cantidad) {
        if (producto == null || cantidad == null) {
            throw new IllegalArgumentException("Producto y cantidad son obligatorios.");
        }
        if (cantidad <= 0) {
             throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }
        this.idProductoOriginal = producto.getId_producto();
        this.nombreProducto = producto.getNombre();
        this.precioUnitarioAlMomento = producto.getPrecio_unidad();
        this.cantidad = cantidad;
        this.subtotal = this.precioUnitarioAlMomento.multiply(BigDecimal.valueOf(cantidad));
        
        this.descuentoAplicadoPorPromocion = BigDecimal.ZERO;
        this.precioFinalUnitarioConDescuento = this.precioUnitarioAlMomento;
        this.subtotalFinalConDescuento = this.subtotal;

        if (producto.getCategoria() != null) {
            this.nombreCategoriaProducto = producto.getCategoria().getNombre();
        }
        this.skuProducto = producto.getSku();
        this.marcaProducto = producto.getMarca();
        this.unidadMedidaProducto = producto.getUnidad_medida();
        
        if (cantidad >= 12 && producto.getPrecio_docena() != null) {
            this.precioDocenaAlMomento = producto.getPrecio_docena();
            this.descuentoDocenasAlMomento = producto.getDescuento_docenas();
        } else {
            this.precioDocenaAlMomento = null;
            this.descuentoDocenasAlMomento = null;
        }
    }

    public void aplicarPromocion(Promocion promocion) {
        if (promocion == null) {
            resetearDescuento();
            return;
        }

        BigDecimal precioBaseUnitario = this.precioUnitarioAlMomento;
        BigDecimal descuentoTotalCalculado = BigDecimal.ZERO;
        BigDecimal precioUnitarioFinal = precioBaseUnitario;

        int numDocenas = this.cantidad / 12;
        int unidadesRestantes = this.cantidad % 12;

        BigDecimal subtotalUnidades = BigDecimal.ZERO;
        BigDecimal subtotalDocenas = BigDecimal.ZERO;
        
        this.promocionAplicada = null; 
        
        switch (promocion.getTipoPromocion()) {
            case "PORCENTAJE":
                if ("PRODUCTO_UNITARIO".equals(promocion.getAplicaA()) || "CATEGORIA".equals(promocion.getAplicaA())) {
                    BigDecimal descuentoPorUnidad = precioBaseUnitario.multiply(promocion.getValorDescuento().divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
                    precioUnitarioFinal = precioBaseUnitario.subtract(descuentoPorUnidad);
                    descuentoTotalCalculado = descuentoPorUnidad.multiply(BigDecimal.valueOf(this.cantidad));
                    this.promocionAplicada = promocion;
                } else if ("PRODUCTO_DOCENA".equals(promocion.getAplicaA()) && numDocenas > 0) {
                    if (this.precioDocenaAlMomento != null) {
                        BigDecimal precioPorDocena = this.precioDocenaAlMomento;
                        BigDecimal descuentoPorDocena = precioPorDocena.multiply(promocion.getValorDescuento().divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
                        
                        descuentoTotalCalculado = descuentoPorDocena.multiply(BigDecimal.valueOf(numDocenas));
                        
                        subtotalDocenas = (precioPorDocena.subtract(descuentoPorDocena)).multiply(BigDecimal.valueOf(numDocenas));
                        subtotalUnidades = precioBaseUnitario.multiply(BigDecimal.valueOf(unidadesRestantes));
                        
                        precioUnitarioFinal = precioBaseUnitario;
                        this.promocionAplicada = promocion;
                    }
                }
                break;

            case "MONTO_FIJO":
                if ("PRODUCTO_UNITARIO".equals(promocion.getAplicaA()) || "CATEGORIA".equals(promocion.getAplicaA())) {
                    BigDecimal descuentoPorUnidad = promocion.getValorDescuento().divide(BigDecimal.valueOf(this.cantidad), 2, RoundingMode.HALF_UP);
                    precioUnitarioFinal = precioBaseUnitario.subtract(descuentoPorUnidad);
                    descuentoTotalCalculado = promocion.getValorDescuento();
                    this.promocionAplicada = promocion;
                } else if ("PRODUCTO_DOCENA".equals(promocion.getAplicaA()) && numDocenas > 0) {
                    if (this.precioDocenaAlMomento != null) {
                        BigDecimal descuentoPorDocenas = promocion.getValorDescuento();
                        descuentoTotalCalculado = descuentoPorDocenas;

                        subtotalDocenas = (this.precioDocenaAlMomento.multiply(BigDecimal.valueOf(numDocenas))).subtract(descuentoPorDocenas);
                        subtotalUnidades = precioBaseUnitario.multiply(BigDecimal.valueOf(unidadesRestantes));

                        precioUnitarioFinal = precioBaseUnitario;
                        this.promocionAplicada = promocion;
                    }
                }
                break;
            default:
                resetearDescuento();
                return;
        }

        if (precioUnitarioFinal.compareTo(BigDecimal.ZERO) < 0) {
            precioUnitarioFinal = BigDecimal.ZERO;
        }

        this.descuentoAplicadoPorPromocion = descuentoTotalCalculado;
        this.precioFinalUnitarioConDescuento = precioUnitarioFinal;

        if ("PRODUCTO_DOCENA".equals(promocion.getAplicaA()) && numDocenas > 0 && this.promocionAplicada != null) {
             this.subtotalFinalConDescuento = subtotalDocenas.add(subtotalUnidades);
        } else {
            this.subtotalFinalConDescuento = this.precioFinalUnitarioConDescuento.multiply(BigDecimal.valueOf(this.cantidad));
        }
    }

    private void resetearDescuento() {
        this.promocionAplicada = null;
        this.descuentoAplicadoPorPromocion = BigDecimal.ZERO;
        this.precioFinalUnitarioConDescuento = this.precioUnitarioAlMomento;
        this.subtotalFinalConDescuento = this.precioUnitarioAlMomento.multiply(BigDecimal.valueOf(this.cantidad));
    }
}