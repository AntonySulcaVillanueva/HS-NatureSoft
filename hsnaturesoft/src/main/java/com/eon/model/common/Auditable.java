package com.eon.model.common;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

@MappedSuperclass
@Getter
public abstract class Auditable {

    @Column(name = "fecha_creacion", updatable = false)
    protected LocalDateTime fecha_creacion;

    @Column(name = "fecha_modificacion")
    protected LocalDateTime fecha_modificacion;

    @PrePersist
    protected void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.fecha_creacion = now;
        this.fecha_modificacion = now;
    }

    @PreUpdate
    protected void preUpdate() {
        this.fecha_modificacion = LocalDateTime.now();
    }

}