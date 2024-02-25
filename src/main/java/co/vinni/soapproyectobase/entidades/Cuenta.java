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
    private int numeroDeCuenta;
    private boolean activa;
    private long saldo;


    @Override
    public String toString() {
        return "Cuenta{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", numerodeCedula=" + numerodeCedula +
                ", numerodeCelular=" + numerodeCelular +
                ", numeroDeCuenta=" + numeroDeCuenta +
                ", activa=" + activa +
                ", saldo=" + saldo +
                '}';
    }

}
