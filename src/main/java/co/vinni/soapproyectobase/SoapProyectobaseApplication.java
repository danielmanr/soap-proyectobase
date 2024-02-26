package co.vinni.soapproyectobase;

import co.vinni.soapproyectobase.controladores.ControladorCuenta;
import co.vinni.soapproyectobase.entidades.Cuenta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.naming.ldap.Control;

/**
 * author Vinni 2023
 */
@SpringBootApplication
public class SoapProyectobaseApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SoapProyectobaseApplication.class, args);
//        ControladorCuenta controlaCuenta = new ControladorCuenta();
//        Cuenta cuenta = new Cuenta();
//        cuenta.setNombre("sujetoA");
//        cuenta.setApellidos("ApellidoA");
//        cuenta.setNumerodeCedula(133000);
//        cuenta.setTipoDocumento("cc");
//        cuenta.setSaldo(0);
//        cuenta.setActiva(true);
//        cuenta.setNumerodeCelular(311122321);
//        if(controlaCuenta.registrarCuenta(cuenta)){
//            System.out.printf("Usuario Registrado con Exito");
//        }else{
//            System.out.println("Usuario Existente");
//        }

        //hacer una consignacion por numero de cuenta

        ControladorCuenta controlaCuenta = new ControladorCuenta();
        if(!controlaCuenta.Consignacion(20000,133000,796123845)){
            System.out.println("Consignacion invalida");
        }
        System.out.printf("Consigacion existosa");




//        ControladorCuenta controlaCuenta = new ControladorCuenta();
//        ControladorCuenta controladorCuenta = new ControladorCuenta();
//        controladorCuenta.leerCuenta("Clientes");
//        controladorCuenta.leerCuenta("datoCuenta265439871");



    }

}
