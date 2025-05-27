package com.example.santa_rp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.santa_rp.model.Producto;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Método para buscar productos por nombre
    List<Producto> findByEstadoTrue();

// Filtro general con múltiples criterios y rangos
    @Query("SELECT p FROM Producto p " +
           "JOIN p.categoria c " +
           "WHERE (:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) " +
           "AND (:categoriaNombre IS NULL OR LOWER(c.nombre) LIKE LOWER(CONCAT('%', :categoriaNombre, '%'))) " +
           "AND (:marca IS NULL OR LOWER(p.marca) LIKE LOWER(CONCAT('%', :marca, '%'))) " +
           "AND (:unidadMedida IS NULL OR LOWER(p.unidad_medida) = LOWER(:unidadMedida)) " +
           "AND (:estado IS NULL OR p.estado = :estado) " +
           "AND (:precioUnidadMin IS NULL OR p.precio_unidad >= :precioUnidadMin) " +
           "AND (:precioUnidadMax IS NULL OR p.precio_unidad <= :precioUnidadMax) " +
           "AND (:precioDocenaMin IS NULL OR p.precio_docena >= :precioDocenaMin) " +
           "AND (:precioDocenaMax IS NULL OR p.precio_docena <= :precioDocenaMax) " +
           "AND (:stockMin IS NULL OR p.stock >= :stockMin) " +
           "AND (:stockMax IS NULL OR p.stock <= :stockMax) " +
           "AND (:fechaCaducidadDesde IS NULL OR p.fecha_caducidad >= :fechaCaducidadDesde) " +
           "AND (:fechaCaducidadHasta IS NULL OR p.fecha_caducidad <= :fechaCaducidadHasta)"
    )
    List<Producto> filtroCompleto(
        @Param("nombre") String nombre,
        @Param("categoriaNombre") String categoriaNombre,
        @Param("marca") String marca,
        @Param("unidadMedida") String unidadMedida,
        @Param("estado") Boolean estado,
        @Param("precioUnidadMin") Double precioUnidadMin,
        @Param("precioUnidadMax") Double precioUnidadMax,
        @Param("precioDocenaMin") Double precioDocenaMin,
        @Param("precioDocenaMax") Double precioDocenaMax,
        @Param("stockMin") Integer stockMin,
        @Param("stockMax") Integer stockMax,
        @Param("fechaCaducidadDesde") LocalDate fechaCaducidadDesde,
        @Param("fechaCaducidadHasta") LocalDate fechaCaducidadHasta
    );


    //Filtro por sku
    @Query("SELECT p FROM Producto p " +
           "WHERE (:sku IS NULL OR LOWER(p.sku) LIKE LOWER(CONCAT('%', :sku, '%')))")
    List<Producto> buscarPorSku(@Param("sku") String sku);



}
