package manejoarchivos;

import java.io.*;

public class ManejoArchivos {

    public static void CrearArchivo(String nombreArchivo) {
        //Declaramos un objeto de tipo File
        var archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            //Aqui ya esta creado el archivo
            salida.close(); //Cerrar archivo
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void escribirArchivo(String nombreArchivo, String contenido) {
        //Recibe el nombre del archivo y el contenido
        //Declaramos un objeto de tipo file
        var archivo = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenido);
            salida.close(); //Cerrar archivo
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }

    }

    public static void agregarArchivo(String nombreArchivo, String contenido) {
        //Declaramos un objeto de tipo file
        var archivo = new File(nombreArchivo);
        try {
            //Invocamos a FileWriter para poder anexar la informacion y no sobreescrbirla
            PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo, true));
            salida.println(contenido);//Agregar mi contenido
            salida.close(); //Cerrar archivo
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void leerArchivo(String nombreArchivo) {
        var archivo = new File(nombreArchivo);
        try {
            //Entrada es el descriptor de lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            // Nos devuelve una linea de nuestro archivo
            var lectura = entrada.readLine();
            while (lectura != null) { // hasta null
                System.out.println("lectura = " + lectura);
                //Avanzamos en la lectura
                lectura = entrada.readLine();
            }
            entrada.close(); //Cerrar archivo
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

}
