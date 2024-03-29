package co.vinni.soapproyectobase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClienteDto implements Serializable {
    private int idCliente;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;
    @NotBlank(message = "El nuemro de identifiacion es obligatorio")
    private String numeroIdentificacion;
    @NotBlank(message = "El numero de celular es obligatorio")
    private String numeroCelular;
}
