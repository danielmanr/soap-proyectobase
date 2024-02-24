package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.repositorios.RepositorioCuenta;
import co.vinni.soapproyectobase.utilidades.UtilidadArchivos;

import java.io.Serializable;

public class ServicioCuenta implements RepositorioCuenta, Serializable {
    @Override
    public void registrarCuenta(Cuenta cuenta){
        Cliente cliente = new Cliente();
        cliente.setNombre(cuenta.getNombre());
        cliente.setApellido(cuenta.getApellidos());
        UtilidadArchivos.guardar("datoCuenta",cuenta);
    }



}
