package com.example.santa_rp.repository;

import com.example.santa_rp.model.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PromocionRepository extends JpaRepository<Promocion, Long> {

    // Consulta personalizada para obtener promociones activas
    @Query("SELECT p FROM Promocion p WHERE p.fecha_inicio <= CURRENT_DATE AND p.fecha_fin >= CURRENT_DATE")
    List<Promocion> findActivePromotions();
}
