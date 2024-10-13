package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVHandler {
    private final File ficheroPath;

    public CSVHandler() {
        this.ficheroPath = new File("C:\\Users\\cocoo\\Documents\\CodeIntelligence Academy\\CodeIntelligence-java\\crm\\src\\resources\\users.csv"); // Cambia la ruta según tu estructura
    }

    public void writeNewUserLine(String id, String nombre, String email, int edad) {
        try (FileWriter escribir = new FileWriter(ficheroPath, true)) { // true para agregar sin sobrescribir
            escribir.write(id + "," + nombre + "," + email + "," + edad + "\n");
            System.out.println("Usuario escrito en el archivo: " + id + ", " + nombre + ", " + email + ", " + edad);
        } catch (IOException e) {
            System.out.println("Se ha producido un error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void leerArchivo() {
        try (BufferedReader lector = new BufferedReader(new FileReader(ficheroPath))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                imprimirLinea(partes);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Se ha producido un error al leer el archivo: " + e.getMessage());
        }
    }

    private void imprimirLinea(String[] partes) {
        for (String parte : partes) {
            System.out.print(parte + "  |  ");
        }
    }
}
