package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;
    @Column(name = "idCliente_cuenta", nullable = false)
    private int idCliente_cuenta;
    @Column(name = "NumeroCuenta", nullable = false)
    private String numeroDeCuenta;
    @Column(name = "Activa", nullable = false)
    private boolean activa;
    @Column(name = "Saldo", nullable = false)
    private double saldo;


}
