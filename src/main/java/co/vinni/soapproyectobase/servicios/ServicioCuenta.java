package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.repositorios.RepositorioCuenta;
import co.vinni.soapproyectobase.utilidades.UtilidadArchivos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ServicioCuenta {
    @Autowired
    RepositorioCuenta repocuenta;


    public boolean registrarCuenta(Cuenta cuenta){

        if(repocuenta.save(cuenta) != null){
            return true;
        }
        return false;
    }


    public Cuenta estadoCuenta(String numeroCedula, String numeroCuenta){
        Cuenta cuenta = new Cuenta();
        if(!buscarCliente(numeroCedula)){
            return cuenta;
        }
        cuenta = (Cuenta)UtilidadArchivos.obtener("datoCuenta"+numeroCuenta);
        return cuenta;
    }


    public boolean realizarTransferencia(double valor, String numeroCelular){

        String [] datosCliente = buscarClienteCelular(numeroCelular);
        String cedula = datosCliente[0];
        String celular = datosCliente[1];
        String numeroCuenta = datosCliente[2];
        if(!buscarCliente(cedula)){
            return false;
        }
        if(!realizarConsignacion((int)valor,cedula,numeroCuenta)){
            return false;
        }
        return true;
    }


    public boolean realizarConsignacion(double valor, String numeroCedula,String numeroCuenta){
        /*
        if(buscarCliente(numeroCedula)){
            String ruta = "C:\\Users\\Daniel\\IdeaProjects\\soap-proyectobase\\datoCuenta"+numeroCuenta;
            if(buscarCuenta(ruta)){
                Cuenta cuenta = new Cuenta();
                cuenta = (Cuenta)UtilidadArchivos.obtener("datoCuenta"+numeroCuenta);
                double nuevoValor = cuenta.getSaldo() + valor ;
                cuenta.setSaldo(nuevoValor);
                UtilidadArchivos.guardar("datoCuenta"+numeroCuenta,cuenta);
            }
        }else{
            return false;
        }
        return true;

         */
        return true;
    }


    private boolean buscarCuenta(String ruta) {
        File archivo = new File(ruta);
        if (archivo.exists() && archivo.isFile()) {
            return true;
        } else {
            return false;
        }
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


    public boolean buscarCliente(String numeroCedula){
        String nombreArchivo = "Clientes";
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                // Procesar los datos como desees
                if(datos[2].equals(numeroCedula)){
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }


    public String[] buscarClienteCelular(String numeroCelular){
        String nombreArchivo = "Clientes";
        String celularCedula [] = new String[3];
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                // Procesar los datos como desees
                if(datos[3].equals(numeroCelular)){
                    celularCedula[0] = datos[2];
                    celularCedula[1] = datos[3];
                    celularCedula[2] = datos[4];
                    return celularCedula;
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return celularCedula;
    }



    public boolean retiroCuenta(String numeroCuenta, double valor){
        /*
        if(!buscarCuenta("datoCuenta"+numeroCuenta)){
            return false;
        }
        Cuenta cuenta = (Cuenta)UtilidadArchivos.obtener("datoCuenta"+numeroCuenta);
        double saldo = cuenta.getSaldo();
        if(saldo >= valor){
            saldo = cuenta.getSaldo() - valor;
            cuenta.setSaldo(saldo);
            UtilidadArchivos.guardar("datoCuenta"+numeroCuenta,cuenta);
            return true;
        }
        System.out.println("Fondos insuficientes");
        return false;

        */
        return true;

    }



}
