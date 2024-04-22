package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "Cuenta")
@Table(name = "Cuentas")
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;

    @Column(name = "NumeroCuenta", nullable = false)
    private String numeroDeCuenta;

    @Column(name = "Activa", nullable = false)
    private boolean activa;

    @Column(name = "Saldo", nullable = false)
    private double saldo;

    // La relación uno a uno con el cliente
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cuenta_id")
    private List<Producto> productos;

}
