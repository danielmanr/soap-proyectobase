package co.vinni.soapproyectobase.dto;

import co.vinni.soapproyectobase.entidades.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long idCuenta;
    private String numeroDeCuenta;
    private boolean activa;
    private double saldo;
    private Cliente cliente;
}
