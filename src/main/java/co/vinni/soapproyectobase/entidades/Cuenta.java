package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Cuenta")
@Table(name = "Cuentas")
public class Cuenta implements Serializable {

    @Id
    private Long idCuenta;
    @Column(name = "Cliente", nullable = false)
    private int cliente;
    @Column(name = "NumeroCuenta", nullable = false)
    private String numeroDeCuenta;
    @Column(name = "Activa", nullable = false)
    private boolean activa;
    @Column(name = "Saldo", nullable = false)
    private double saldo;



    @Override
    public String toString() {
        return "Cuenta{" +
                "cliente=" + cliente +
                ", numeroDeCuenta='" + numeroDeCuenta + '\'' +
                ", activa=" + activa +
                ", saldo=" + saldo +
                '}';
    }

}
