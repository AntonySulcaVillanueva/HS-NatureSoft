package com.eon.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria",referencedColumnName = "id_categoria")
    private Categoria categoria;

    private String nombre;
    private String descripcion;
    private Integer peso_unidad;
    private String unidad_medida;
    private BigDecimal precio_unidad;
    private BigDecimal precio_docena;
    private BigDecimal descuento_docenas; 
    private Integer stock; // cantidad de unidades disponibles
    private LocalDate fecha_caducidad;
    private String marca = "Hierba Santa Peru S.A.C.";
    private String estado;
    private String sku; //codigo del producto

    @ElementCollection
    private List<String> imagenes;

    @ElementCollection
    private List<String> ingredientes;

    @ElementCollection
    private List<String> etiquetas;

    private String composicion;

    private Integer calorias;
    private Double grasas_totales;
    private Double proteinas;
    private Double carbohidratos;

    private String video_url;

    private String contenido_neto;
    private String presentacion;
    private String uso_recomendado;
    private String advertencias;
}