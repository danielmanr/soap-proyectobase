package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.repositorios.RepositorioCuenta;
import co.vinni.soapproyectobase.utilidades.UtilidadArchivos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServicioCuenta implements RepositorioCuenta, Serializable {
    @Override
    public void registrarCuenta(Cuenta cuenta){
        Cliente cliente = new Cliente();
        cliente.setNombre(cuenta.getNombre());
        cliente.setApellido(cuenta.getApellidos());
        cuenta.setNumeroDeCuenta(Integer.parseInt(generarNumeroCuenta()));

        UtilidadArchivos.guardar("datoCuenta"+cuenta.getNumeroDeCuenta(),cuenta);
        UtilidadArchivos.guardar("Clientes",cliente);
    }


    public void traeDatosCuenta(String nombreCuenta){
        UtilidadArchivos.obtener(nombreCuenta);

    }


    private String generarNumeroCuenta() {
        StringBuilder numeroCuenta = new StringBuilder();
        int cantidadNumeros = 9;
        List<Integer> numeros = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            numeros.add(i);
        }
        Collections.shuffle(numeros);

        for (int i = 0; i < cantidadNumeros; i++) {
            numeroCuenta.append(numeros.get(i));
        }

        return numeroCuenta.toString();

    }



}
