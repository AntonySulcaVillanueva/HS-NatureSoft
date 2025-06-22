package com.eon.model.Inventario;

import com.eon.model.Empleado;
import com.eon.model.Insumo;
import com.eon.model.Proveedor;
import com.eon.model.common.Auditable;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mov_inv_insumos")
public class MovInvInsumos extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insumo",referencedColumnName = "id_insumo")
    private Insumo insumo;
    
    private String descripcion;
    private Integer cantidad; // TENER EN CUENTA :   frontend calculara la docena + cantidad = producto.stock

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado",referencedColumnName = "id_empleado" )
    private Empleado empleado;
    
    private String tipoMovimiento; // "ingreso" o "salida"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor", referencedColumnName = "id_proveedor")
    private Proveedor proveedor;
    
    
    
}
