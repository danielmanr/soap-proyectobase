package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.servicios.ServicioCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class ControladorCuenta {
    ServicioCuenta servicioCuenta = new ServicioCuenta();

    public void registrarCuenta(Cuenta cuenta) {

        servicioCuenta.registrarCuenta(cuenta);
    }


}