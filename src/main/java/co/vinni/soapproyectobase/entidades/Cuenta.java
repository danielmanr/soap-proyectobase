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
    private String numerodeCedula;
    private String numerodeCelular;
    private String numeroDeCuenta;
    private boolean activa;
    private double saldo;


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
