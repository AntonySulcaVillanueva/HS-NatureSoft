package com.example.santa_rp.service;

import java.util.List;
import java.util.Optional;

import com.example.santa_rp.model.Categoria;

public interface CategoriaService {

    // Lista todas las categorias
    List<Categoria> findAll();

    // Busca una categoria por su ID
    Optional<Categoria> findById(Long id);

    // Guarda una nueva categoria
    Categoria save(Categoria categoria);

    // Actualiza una categoria existente
    Categoria update(Long id, Categoria categoria);

    //metodo listar rodos los activos
    List<Categoria> findAllActive();

    //metodo para suponer la eliminacion y soo cambiar el estado
    void softDelete(Long id);

    //metodo para buscar por nombre y estado
    List<Categoria> searchNameAndStatus(String nombre, Boolean estado);
}
