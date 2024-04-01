package co.vinni.soapproyectobase.dto;

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
    private int idCliente_cuenta;
    private String numeroDeCuenta;
    private boolean activa;
    private double saldo;
}
