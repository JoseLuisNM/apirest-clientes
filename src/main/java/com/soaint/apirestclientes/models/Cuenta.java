package com.soaint.apirestclientes.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cuentas")

public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCuenta;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties(value = {"cuentas"})
    private Cliente cliente;

    @PrePersist
    public void establecerFechaCreacion(){
        this.fechacreacion = new Date();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (! (obj instanceof Cuenta)){
            return false;
        }
        return this.id != null && this.id.equals( ((Cuenta) obj).getId() );
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, fechacreacion, numeroCuenta);
    }
}
