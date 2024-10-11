package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class UserCSVHandler {
    public File ficheroPath = new File("");

    private BufferedReader lector; //lee el archivo
    private String linea; // recibe la línea de cada fila
    private String partes[] = null; //almacena cada línea

    public void writeNewUserLine(String id, String nombre, String email, int edad) {
        try (FileWriter escribir = new FileWriter(ficheroPath, true)) { // true para agregar sin sobrescribir
            escribir.write(  id + "," + nombre + "," + email + "," + edad + "\n");
            escribir.close();
        } catch (Exception e) {
            System.out.println("Se ha producido un error al escribir en el archivo.");
        }
    }
    public void escribirLineaNueva(){
    }


    public void leerArchivo(String nombreArchivo) {
        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
                imprimirLinea();
                System.out.println();
            }
            lector.close();
            linea = null;
            partes = null;
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        }
    }

    public void imprimirLinea(){
        for (int i = 0; i < partes.length; i++) {
            System.out.print(partes[i] + "  |  ");
        }
    }

}
