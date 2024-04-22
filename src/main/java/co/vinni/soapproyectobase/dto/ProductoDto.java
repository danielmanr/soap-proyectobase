package co.vinni.soapproyectobase.dto;


import co.vinni.soapproyectobase.entidades.Cuenta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProductoDto {

    private Long idProducto;
    @NotBlank(message = "El tipo es obligatorio")
    private String tipo;
    @NotBlank(message = "El capacidad obligatorio")
    private double capacidad;
    @NotBlank(message = "El franquicia es obligatorio")
    private String franquicia;

}
