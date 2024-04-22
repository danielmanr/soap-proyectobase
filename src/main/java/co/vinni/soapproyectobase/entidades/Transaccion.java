package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "Transaccion")
@Table(name = "Transacciones")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaccion;

    @Column(name = "Tipo", nullable = false)
    private String tipo;

    @Column(name = "Cantidad", nullable = false)
    private double cantidad;

    @ManyToMany(mappedBy = "transacciones")
    private List<Cuenta> cuentas;

}
