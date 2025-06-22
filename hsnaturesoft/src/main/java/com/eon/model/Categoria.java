package com.eon.model;

import java.util.List;

import com.eon.model.common.Auditable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;

    private String nombre;
    private String descripcion;

    @ElementCollection
    private List<String> imagenes;

    private String sku; // referente al codigo de la categoria
}