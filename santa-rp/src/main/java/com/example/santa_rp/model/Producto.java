package com.example.santa_rp.model;

import com.example.santa_rp.model.common.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    private String nombre;
    private String descripcion;
    private String unidad;
    private Double precio_docena;
    private Double descuento_docena;
    private String imagen1;
    private String imagen2;
    private String imagen3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria", referencedColumnName = "id_categoria")
    private Categoria categoria;
}
