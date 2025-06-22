package com.eon.model;

import java.math.BigDecimal;
import java.util.List;

import com.eon.model.common.Auditable;

import jakarta.persistence.ElementCollection;
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
@Table(name = "insumo")
public class Insumo extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_insumo;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn( name = "categoria" , referencedColumnName = "id_categoria")
    private Categoria Categoria;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "proveedor", referencedColumnName = "id_proveedor")
    private Proveedor proveedor;

    private String nombre;
    private String descripcion;
    private String sku; //codigo del insumo
    private String unidad_medida; // gramos, kilos, litros, unidades, etc.
    private Integer cantidad;

    private BigDecimal costo;
    private String observaciones;

    private String estado; // Activo, Inactivo, Eliminado

    @ElementCollection
    private List<String> imagenes;

    @ElementCollection
    private List<String> etiquetas;


    
}
