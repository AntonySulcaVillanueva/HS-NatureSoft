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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mov_inv_insumos")
public class MovInvInsumos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mov_inv_insumos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto",referencedColumnName = "id_producto")
    private Producto producto;
    private String descripcion;
    private Integer cantidad; // TENER EN CUENTA :   frontend calculara la docena + cantidad = producto.stock

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado",referencedColumnName = "id_empleado" )
    private Empleado empleado;
    private String tipoMovimiento; // "ingreso" o "salida"










    
    
}
