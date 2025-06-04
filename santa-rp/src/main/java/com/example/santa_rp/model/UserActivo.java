package com.example.santa_rp.model;

import com.example.santa_rp.model.common.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_activo")
public class UserActivo extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado", referencedColumnName = "id_empleado")
    private Empleado empleado;
}
