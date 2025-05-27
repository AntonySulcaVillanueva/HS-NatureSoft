package com.example.santa_rp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import com.example.santa_rp.model.Producto;

public interface ProductoService {

    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto save(Producto producto);
    Producto update(Long id , Producto producto);

    // Metodo para listar todos los productos activos
    List<Producto> findAllActive ();

    // Metodo para suponer la eliminacion y solo cambiar el estado
    void softDelete(Long id);

    //Metodo para busqueda por nombre y demas atributos
    List<Producto> buscarPorFiltros(
        String nombre,
        String categoriaNombre,
        String marca,
        String unidadMedida,
        Boolean estado,
        Double precioUnidadMin,
        Double precioUnidadMax,
        Double precioDocenaMin,
        Double precioDocenaMax,
        Integer stockMin,
        Integer stockMax,
        LocalDate fechaCaducidadDesde,
        LocalDate fechaCaducidadHasta
    );

    // Metodo para buscar por sku ya sea que contenga una letra semejante o sea igual
    List<Producto> buscarPorSku(String sku);

}
