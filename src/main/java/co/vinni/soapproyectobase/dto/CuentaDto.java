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
public class CuentaDto implements Serializable {

    private Long serial;
    @NotBlank(message = "El nombre es Obligatorio")
    private String nombre;
//    @NotBlank(message = "numero de Cedula")
//    private

}
