package co.vinni.soapproyectobase;

import co.vinni.soapproyectobase.controladores.ControladorCliente;
import co.vinni.soapproyectobase.controladores.ControladorCuenta;
import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.naming.ldap.Control;
import java.util.Scanner;

/**
 * author Vinni 2023
 */
@SpringBootApplication
public class SoapProyectobaseApplication {


    public static void main(String[] args) {
        SpringApplication.run(SoapProyectobaseApplication.class,args);
        System.out.println("proyecto Base");


    }
}
