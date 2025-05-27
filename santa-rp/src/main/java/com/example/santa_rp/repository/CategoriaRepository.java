package com.example.santa_rp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.santa_rp.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    //metodo para listar todos los activos
    List<Categoria> findByEstadoTrue();

    //metodo para listar todos los inactivos ""
     @Query("SELECT c FROM Categoria c " +
           "WHERE (:nombre IS NULL OR LOWER(c.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) " +
           "AND (:estado IS NULL OR c.estado = :estado)")
    List<Categoria> searchNameAndStatus(@Param("nombre") String nombre, @Param("estado") Boolean estado);

}
