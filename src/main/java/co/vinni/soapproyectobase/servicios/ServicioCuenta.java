package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.repositorios.RepositorioCuenta;
import co.vinni.soapproyectobase.utilidades.UtilidadArchivos;

import java.io.Serializable;

public class ServicioCuenta implements RepositorioCuenta, Serializable {
    @Override
    public void registrarCuenta(Cuenta cuenta){

        UtilidadArchivos.guardar("datoCuenta",cuenta);

    }

}
