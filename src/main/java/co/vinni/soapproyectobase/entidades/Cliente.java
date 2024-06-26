package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Clientes")
@Setter
@Getter
@ToString
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id", nullable = false)
    private int idCliente;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Apellido", nullable = false)
    private String apellido;

    @Column(name = "NumeroIndetificacion", nullable = false)
    private String numeroIdentificacion;

    @Column(name = "NumeroCelular", nullable = false)
    private String numeroCelular;

    // La relación uno a uno con la cuenta
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Cuenta cuenta;

}
