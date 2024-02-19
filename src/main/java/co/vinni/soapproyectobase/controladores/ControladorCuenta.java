package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.servicios.ServicioCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControladorCuenta {

    @Autowired
    private ServicioCuenta servicioCuenta;

    // Otro código de la clase
    @Autowired
    public void registrarCuenta(Cuenta cuenta) {

        servicioCuenta.registrarCuenta(cuenta);
    }
}