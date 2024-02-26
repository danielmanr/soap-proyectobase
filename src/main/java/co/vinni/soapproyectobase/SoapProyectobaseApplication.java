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
//        cuenta.setNombre("pruebaCliente2");
//        cuenta.setApellidos("Transferencia2");
//        cuenta.setNumerodeCedula(54321);
//        cuenta.setTipoDocumento("cc");
//        cuenta.setSaldo(0);
//        cuenta.setActiva(true);
//        cuenta.setNumerodeCelular("320122321");
//        if(controlaCuenta.registrarCuenta(cuenta)){
//            System.out.printf("Usuario Registrado con Exito");
//        }else{
//            System.out.println("Usuario Existente");
//        }

        //hacer una consignacion por numero de cuenta

//        ControladorCuenta controlaCuenta = new ControladorCuenta();
//        if(!controlaCuenta.Consignacion(20000,133000,796123845)){
//            System.out.println("Consignacion invalida");
//        }
//        System.out.printf("Consigacion existosa");


        //hacer una consignacion por numero
        ControladorCuenta controlaCuenta = new ControladorCuenta();
        controlaCuenta.transferencia(3000,"320122321");



//        ControladorCuenta controlaCuenta = new ControladorCuenta();
//        ControladorCuenta controladorCuenta = new ControladorCuenta();
//        controladorCuenta.leerCuenta("Clientes");
//        controladorCuenta.leerCuenta("datoCuenta265439871");


        //ver estado de cuenta;
        ControladorCuenta controladorCuenta = new ControladorCuenta();





    }

}
