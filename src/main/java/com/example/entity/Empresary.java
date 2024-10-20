package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empresary")
public class Empresary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String fechaOperacion;
    @NotNull
    private String producto;
    @NotNull
    private String tipoTransaccion;
    @NotNull
    private Integer cantidad;
    @NotNull
    private String descripcion;
    @NotNull
    private String usuario;
    @NotNull
    private String fechaVencimiento;
    @NotNull
    private String proveedor;
}
