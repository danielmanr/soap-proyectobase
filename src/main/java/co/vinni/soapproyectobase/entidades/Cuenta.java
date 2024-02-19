package co.vinni.soapproyectobase.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta implements Serializable {


    private String nombre;
    private String apellidos;
    private String tipoDocumento;
    private long numerodeCedula;
    private long numerodeCelular;
    private long numeroDeCuenta;
    private boolean activa;
    private long saldo;

}
