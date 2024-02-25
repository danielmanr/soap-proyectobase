package co.vinni.soapproyectobase.utilidades;

import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;

import java.io.*;
import java.util.*;

public class UtilidadArchivos {
    private static Cuenta cuenta;

    public static boolean guardar(String archivo, Object objeto){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(objeto);
        } catch (IOException e) {
            return false;
        }
        return true;

    }
    public static Object obtener(String archivo){
        Object objetoCOnsultado;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
            objetoCOnsultado = ois.readObject();
            return objetoCOnsultado;
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }



    public static boolean verificarExistenciaCuenta(){

        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = new Cliente();

        String archivo = "clientes.txt";

        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;

            // Leer cada línea del archivo hasta que no haya más líneas
            while ((linea = lector.readLine()) != null) {
                // Dividir la línea en partes usando la coma como delimitador
                String[] partes = linea.split(",");

                if (partes.length >= 3) {
                    String nombre = partes[0];
                    cliente.setNombre(nombre);
                    String apellido = partes[1];
                    cliente.setApellido(apellido);
                    String email = partes[2].trim();
                    long numeroIdentificacion = Long.parseLong(partes[1].trim());
                    cliente.setNumeroIdentificacion(numeroIdentificacion);
                } else {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                }
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    return true;
    }



}
