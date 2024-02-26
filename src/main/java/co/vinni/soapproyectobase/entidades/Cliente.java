package co.vinni.soapproyectobase.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {
    public String nombre;
    public String apellido;
    public String numeroIdentificacion;
    private String numeroCuenta;
    private String numeroCelular;

}