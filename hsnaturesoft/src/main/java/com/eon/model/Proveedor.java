package com.eon.model;

import java.util.List;

import com.eon.model.common.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "proveedor")
public class Proveedor  extends Auditable{
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id_proveedor;

    private String nombre;
    private String apellido;

    @Column(unique = true , nullable = true)
    private String ruc;

    @Column(unique = true , nullable = true)
    private String email;

    private String telefono;
    private String direccion;
    private String paginaWeb;
    private String contacto;
    private String estado; // Activo, Inactivo, Eliminado
    private String sku; // Referente al codigo del proveedor

     @ElementCollection
    private List<String> imagenes;
}
