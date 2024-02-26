package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.servicios.ServicioCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class ControladorCuenta {
    ServicioCuenta servicioCuenta = new ServicioCuenta();

    public boolean registrarCuenta(Cuenta cuenta) {

        if(servicioCuenta.registrarCuenta(cuenta)){
            return true;
        }else{
            return false;
        }
    }

    public boolean Consignacion(int valor, int numeroCedula,int numeroCuenta){

        if(!servicioCuenta.realizarConsignacion(valor,numeroCedula,numeroCuenta)){
            return false;
        }
        return true;
    }

    public void leerCuenta(String nombreCuenta){
        servicioCuenta.traeDatosCuenta(nombreCuenta);
    }


}