package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.ClienteDto;
import co.vinni.soapproyectobase.dto.CuentaDto;
import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.servicios.ServicioCliente;
import co.vinni.soapproyectobase.servicios.ServicioCuenta;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class ControladorCuenta {

    @Autowired
    private ServicioCuenta servicioCuenta;

    @GetMapping("/cuenta/nuevo")
    public Cuenta asignacionCuenta(){
        Cuenta cuenta = new Cuenta();
        ServicioCuenta scuenta = new ServicioCuenta();
        String numerocuenta = scuenta.generarNumeroCuenta();
        cuenta.setNumeroDeCuenta(numerocuenta);
        cuenta.setSaldo(0);
        cuenta.setActiva(true);
        return cuenta;
    }





}