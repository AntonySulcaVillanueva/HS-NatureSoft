package com.eon.model.Venta;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
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
    private Long idPromocion;

    private String nombre;
    private String tipoPromocion;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorDescuento;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean activa = true;
    private String descripcion;
    private String aplicaA; 
}