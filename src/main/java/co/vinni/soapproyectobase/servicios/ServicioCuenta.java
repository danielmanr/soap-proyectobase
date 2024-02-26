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
        if(UtilidadArchivos.guardarCliente("Clientes",cliente.getApellido()+","+cliente.getNombre()+","+cliente.getNumeroIdentificacion())){
            cuenta.setNumeroDeCuenta(Integer.parseInt(generarNumeroCuenta()));
            cliente.setNumeroCuenta(cuenta.getNumeroDeCuenta());
            UtilidadArchivos.guardar("datoCuenta"+cuenta.getNumeroDeCuenta(),cuenta);
            return true;
        }else{
            return false;
        }
    }


    public boolean realizarConsignacion(int valor, int numeroCedula,int numeroCuenta){
        if(buscarCliente(numeroCedula)){
            String ruta = "C:\\Users\\Daniel\\IdeaProjects\\soap-proyectobase\\datoCuenta"+numeroCuenta;
            if(buscarCuenta(ruta)){
                Cuenta cuenta = new Cuenta();
                cuenta = (Cuenta)UtilidadArchivos.obtener("datoCuenta"+Integer.toString(numeroCuenta));
                long nuevoValor = cuenta.getSaldo() + valor ;
                cuenta.setSaldo(nuevoValor);
                UtilidadArchivos.guardar("datoCuenta"+Integer.toString(numeroCuenta),cuenta);
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


    public boolean buscarCliente(int numeroCedula){
        String nombreArchivo = "Clientes";
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                // Procesar los datos como desees
                if(datos[2].equals(Integer.toString(numeroCedula))){
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }

}
