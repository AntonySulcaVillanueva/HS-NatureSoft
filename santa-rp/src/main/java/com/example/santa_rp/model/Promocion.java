package com.example.santa_rp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "promocion")
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_promocion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Producto producto; // Relación con Producto

    private Double descuento; // Descuento en porcentaje (por ejemplo, 10 para 10%)
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    // Método para aplicar la promoción y reducir el stock
    public void aplicarPromocion() {
        if (producto != null && producto.getStock() > 0) {
            // Reducir el stock (por ejemplo, 1 unidad por promoción consumida)
            producto.setStock(producto.getStock() - 1);
            producto.actualizarEstadoStock(); // Actualiza el estado del producto
        }
    }
}
