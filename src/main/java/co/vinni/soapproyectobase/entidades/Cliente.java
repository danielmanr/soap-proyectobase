package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Cliente")
@Table(name = "Clientes")
public class Cliente implements Serializable {
    @Id
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
