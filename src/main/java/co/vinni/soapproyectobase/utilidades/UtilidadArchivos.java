package co.vinni.soapproyectobase.utilidades;

import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;

import java.io.*;
import java.util.*;

public class UtilidadArchivos {
    public static boolean guardar(String archivo, Object objeto){
        long numeroCuenta = generarNumeroCuenta();


        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(objeto.toString());
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


    public static void generarNumeroCuenta(){

        int cantidadNumeros = 10; // Cantidad de números aleatorios únicos que deseas generar
        List<Integer> numeros = new ArrayList<>();

        // Llenar la lista con los números del 1 al 100 (o el rango que desees)
        for (int i = 1; i <= 9; i++) {
            numeros.add(i);
        }

        // Mezclar la lista para obtener un orden aleatorio
        Collections.shuffle(numeros);

        // Imprimir los primeros "cantidadNumeros" elementos de la lista
        for (int i = 0; i < cantidadNumeros; i++) {
            System.out.println(numeros.get(i));
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
    return clientes;
    }


}
