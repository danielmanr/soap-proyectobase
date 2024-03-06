package co.vinni.soapproyectobase.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta implements Serializable {


    private int cliente;
    private String numeroDeCuenta;
    private boolean activa;
    private double saldo;


    @Override
    public String toString() {
        return "Cuenta{" +
                "cliente=" + cliente +
                ", numeroDeCuenta='" + numeroDeCuenta + '\'' +
                ", activa=" + activa +
                ", saldo=" + saldo +
                '}';
    }
}
