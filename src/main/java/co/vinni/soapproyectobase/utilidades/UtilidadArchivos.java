package co.vinni.soapproyectobase.utilidades;

import co.vinni.soapproyectobase.entidades.Cliente;
import co.vinni.soapproyectobase.entidades.Cuenta;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class UtilidadArchivos {
    private static Cuenta cuenta;

    public static boolean guardar(String archivo, Object objeto){

        try {
            // Crear un ObjectOutputStream con un FileOutputStream en modo de escritura
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));

            // Escribir el objeto en el archivo
            oos.writeObject(objeto);

            // Cerrar el ObjectOutputStream
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
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


    public static boolean guardarCliente(String nombreArchivo, String nuevoDato){

        List<String> lineas = new ArrayList<>();

        // Leer el archivo y cargar las líneas existentes
        try {
            if (Files.exists(Paths.get(nombreArchivo))) {
                lineas = Files.readAllLines(Paths.get(nombreArchivo));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Buscar si el número ya existe en el archivo
        boolean encontrado = false;
        for (int i = 0; i < lineas.size(); i++) {
            String linea = lineas.get(i);
            String[] partes = linea.split(",");
            if (partes.length > 0 && partes[2].equals(nuevoDato.split(",")[2])) {
                //lineas.set(i, nuevoDato); // Actualizar la línea existente
                encontrado = true;
                return false;
            }
        }


        // Si el número no se encontró, agregarlo al final
        if (!encontrado) {
            lineas.add(nuevoDato);
        }

        // Escribir las líneas actualizadas en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String linea : lineas) {
                writer.write(linea + "\n");
            }
            System.out.println("Cuenta generada o actualizado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;

    }






}
