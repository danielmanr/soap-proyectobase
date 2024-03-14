package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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
    @Column
    (name = "idCliente", nullable = false)
    private long idCliente;
    @Column(name = "Nombre", nullable = false)
    private String nombre;
    @Column(name = "Apellido", nullable = false)
    private String apellido;
    @Column(name = "NumeroIndetificacion", nullable = false)
    private String numeroIdentificacion;
    @Column(name = "NumeroCelular", nullable = false)
    private String numeroCelular;

}
