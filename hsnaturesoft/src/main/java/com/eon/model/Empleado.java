package com.eon.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.eon.model.common.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="empleado") 
public class Empleado extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empleado;
    private String nombres;
    private String apellidos;
    
    @Column(unique = true ,nullable = true )
    private String email;

    private String telefono;
    private String direccion;

    private LocalDate fechaIngreso;
    private LocalDate fechaNacimiento;
    private LocalDate fechaSalida;
    private BigDecimal salario;
    private String tipoContrato;
    private LocalDate fechaContrato;
    private LocalDate fechaTerminacionContrato;
    private String observaciones;
    private String foto;
    private String dni;
    private String estado; // Activo, Inactivo, Eliminado


}