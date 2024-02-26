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


    public boolean Consignacion(double valor, String numeroCedula,String numeroCuenta){

        if(!servicioCuenta.realizarConsignacion(valor,numeroCedula,numeroCuenta)){
            return false;
        }
        return true;
    }


    public boolean transferencia(double valor, String numeroCelular){
        return servicioCuenta.realizarTransferencia(valor,numeroCelular);
    }


    public Cuenta estadoCuenta(String numeroCedula ,String numeroCuenta){
        return servicioCuenta.estadoCuenta(numeroCedula, numeroCuenta);

    }


}