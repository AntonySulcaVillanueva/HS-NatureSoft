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
import java.util.List;

import com.example.santa_rp.model.common.Auditable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto extends Auditable {

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
    private Double precio_unidad;
    private Double precio_docena;
    private Double descuento_docenas;
    private Integer stock;// cantidad de productos en stock conteo por unidad
    private LocalDate fecha_caducidad;
    private String marca = "Hierba Santa Peru S.A.C.";
    private boolean estado = true;
    private String sku; //Identificador alfanumerico del producto ejem: HSP-001

    private List<String> imagenes;
    
    //producto.setStock(nuevoStock);
    //producto.actualizarEstadoPorStock();
    public void actualizarEstadoStock(){
        if (this.stock <= 0 || this.stock == null) {
            this.estado = false;
        } else {
            this.estado = true;
        }

    }



    
}
