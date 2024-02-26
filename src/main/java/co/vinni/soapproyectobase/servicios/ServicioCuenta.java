package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.repositorios.RepositorioCuenta;
import co.vinni.soapproyectobase.utilidades.UtilidadArchivos;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServicioCuenta implements RepositorioCuenta, Serializable {
    @Override
    public boolean registrarCuenta(Cuenta cuenta){
        Cliente cliente = new Cliente();
        cliente.setNombre(cuenta.getNombre());
        cliente.setApellido(cuenta.getApellidos());
        cliente.setNumeroIdentificacion(cuenta.getNumerodeCedula());
        cliente.setNumeroCelular(cuenta.getNumerodeCelular());
        cuenta.setNumeroDeCuenta(generarNumeroCuenta());
        if(UtilidadArchivos.guardarCliente("Clientes",cliente.getApellido()+","+cliente.getNombre()+","+cliente.getNumeroIdentificacion()+","+cliente.getNumeroCelular()+","+cuenta.getNumeroDeCuenta())){
            cliente.setNumeroCuenta(cuenta.getNumeroDeCuenta());
            UtilidadArchivos.guardar("datoCuenta"+cuenta.getNumeroDeCuenta(),cuenta);
            System.out.println("Numero de Cuenta"+cuenta.getNumeroDeCuenta());
            return true;
        }else{
            return false;
        }
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
    }


    private boolean buscarCuenta(String ruta) {
        File archivo = new File(ruta);
        if (archivo.exists() && archivo.isFile()) {
            return true;
        } else {
            return false;
        }
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

}
