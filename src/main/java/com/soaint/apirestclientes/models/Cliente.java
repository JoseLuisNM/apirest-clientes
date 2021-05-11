package com.soaint.apirestclientes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private String sexo;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"cliente"}, allowSetters = true)
    private List<Cuenta> cuentas;

    @PrePersist
    public void establecerFechaCreacion(){
        this.fechacreacion = new Date();
    }

    public void actualizarCuentas(List<Cuenta> nuevasCuentas){
        List<Cuenta> mantener = cuentas.stream().filter( c -> !nuevasCuentas.contains(c) ).collect(Collectors.toList());
        nuevasCuentas.addAll(mantener);
        cuentas.clear();
        cuentas.addAll(nuevasCuentas);
    }

    public void eliminarCuenta(List<Cuenta> cuentas){
        System.out.println("Entramos en eliminar cuentas de clase cliente");
        this.cuentas.removeAll(cuentas);
    }

    public void eliminarCuenta(Cuenta cuenta){
        System.out.println("Entramos en eliminar cuenta de clase cliente");
        cuentas.remove(cuenta);
    }


}
