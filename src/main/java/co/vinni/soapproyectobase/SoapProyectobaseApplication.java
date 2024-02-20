package co.vinni.soapproyectobase;

import co.vinni.soapproyectobase.controladores.ControladorCuenta;
import co.vinni.soapproyectobase.entidades.Cuenta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author Vinni 2023
 */
@SpringBootApplication
public class SoapProyectobaseApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SoapProyectobaseApplication.class, args);
        ControladorCuenta controlaCuenta = new ControladorCuenta();
        Cuenta cuenta = new Cuenta();
        cuenta.setNombre("fulano");
        cuenta.setApellidos("de tal");
        cuenta.setNumeroDeCuenta(123441);
        cuenta.setNumerodeCedula(1030000000);
        cuenta.setTipoDocumento("cc");
        cuenta.setSaldo(0);
        cuenta.setActiva(true);
        cuenta.setNumerodeCelular(311122321);
        controlaCuenta.registrarCuenta(cuenta);



    }

}
