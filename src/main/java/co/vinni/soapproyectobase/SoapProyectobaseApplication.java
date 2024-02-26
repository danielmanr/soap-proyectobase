package co.vinni.soapproyectobase;

import co.vinni.soapproyectobase.controladores.ControladorCuenta;
import co.vinni.soapproyectobase.entidades.Cuenta;
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
        //SpringApplication.run(SoapProyectobaseApplication.class, args);

        Scanner lectura = new Scanner (System.in);
        ControladorCuenta controlaCuenta = new ControladorCuenta();
        Cuenta cuenta = new Cuenta();
        boolean salir = false;
        String numeroCuenta;
        double valor = 0;

        while(!salir){
            System.out.println("***Bienvenido a Cuenta***");
            System.out.println("Marque una opción");
            System.out.println("1. Creacion de cuenta");
            System.out.println("2. Verificar estado de Cuenta ya existente");
            System.out.println("3. Realizar una Consignacion a una Cuenta");
            System.out.println("4. Realizar una Transferencia a un Numero Celular");
            System.out.println("5. Realizar un Retiro");
            System.out.println("6. Salir");
            int opc = lectura.nextInt();
            switch (opc){
                case 1:
                    System.out.println("Digite su Nombre");
                    cuenta.setNombre(lectura.next());
                    System.out.println("Digite su Apellido");
                    cuenta.setApellidos(lectura.next());
                    System.out.println("Digite su Numero de identificacion");
                    cuenta.setNumerodeCedula(lectura.next());
                    System.out.println("Digite su tipo de documento");
                    cuenta.setTipoDocumento(lectura.next());
                    cuenta.setSaldo(0);
                    cuenta.setActiva(true);
                    System.out.println("Digite su Numero Celular");
                    cuenta.setNumerodeCelular(lectura.next());
                    if(controlaCuenta.registrarCuenta(cuenta)){
                        System.out.println("Gracias por Registrarse");
                    }else{
                        System.out.println("Usuario Existente");
                        break;
                   }
                    break;
                case 2:
                    System.out.println("Digite el numero de cedula");
                    String numeroCedula = lectura.next();
                    System.out.println("Digite el numero de cuenta");
                    numeroCuenta = lectura.next();
                    cuenta = controlaCuenta.estadoCuenta(numeroCedula,numeroCuenta);
                    System.out.println(cuenta);
                    break;
                case 3:
                    System.out.println("Digite el numero de cedula del destinatario");
                    String cedula = lectura.next();
                    System.out.println("Digite el numero de cuenta del destinatario");
                    String cuentaDestinatario = lectura.next();
                    System.out.println("Digite el valor a consignar");
                    valor = lectura.nextDouble();
                    if(!controlaCuenta.Consignacion(valor,cedula,cuentaDestinatario)){
                        System.out.println("Consignacion invalida");
                        break;
                    }
                    System.out.printf("Consigacion existosa");
                    break;

                case 4:
                    System.out.println("Digite el numero de celular del destinatario");
                    String celular = lectura.next();
                    System.out.println("Digite el valor a transferir");
                    double valor1 = lectura.nextDouble();
                    if(!controlaCuenta.transferencia(valor1,celular)){
                        System.out.println("Problemas en la transferencia");
                        break;
                    }
                    System.out.println("Transferencia Exitosa");
                    break;
                case 5:
                    System.out.println("Digite el numero de Cuenta");
                    numeroCuenta = lectura.next();
                    System.out.println("Digite el valor a retirar");
                    valor = lectura.nextDouble();
                    if(!controlaCuenta.retiroCuenta(numeroCuenta,valor)){
                        System.out.println("Error en la transaccion");
                        break;
                    }
                    System.out.println("Retiro Exitoso");
                    break;
                case 6:
                    System.exit(0);
            }

            System.out.println("Desea continuar haciendo operaciones:");
            System.out.println("1. Continuar");
            System.out.println("2. terminar");
            opc = lectura.nextInt();
            if (opc == 1){
                salir = false;
            }else{
                salir = true;
            }
        }
    }
}
