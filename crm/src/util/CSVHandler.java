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

    public void eliminarUsuarioPorId(String id) {
        File archivoTemporal = new File("C:\\Users\\cocoo\\Documents\\CodeIntelligence Academy\\CodeIntelligence-java\\crm\\src\\resources\\users_temp.csv");

        try (BufferedReader lector = new BufferedReader(new FileReader(ficheroPath));
             FileWriter escritor = new FileWriter(archivoTemporal)) {

            String linea;
            boolean encontrado = false;

            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                // Asumimos que el ID está en la primera posición (índice 0)
                if (!partes[0].equals(id)) {
                    escritor.write(linea + "\n"); // Escribimos la línea en el archivo temporal
                } else {
                    encontrado = true; // Marcamos que hemos encontrado y eliminado el usuario
                }
            }

            if (encontrado) {
                System.out.println("Usuario con ID " + id + " eliminado exitosamente.");
            } else {
                System.out.println("No se encontró un usuario con ID " + id + ".");
            }
        } catch (IOException e) {
            System.out.println("Se ha producido un error al eliminar el usuario: " + e.getMessage());
        }

        // Reemplazar el archivo original con el archivo temporal
        if (!ficheroPath.delete()) {
            System.out.println("No se pudo eliminar el archivo original.");
            return;
        }
        if (!archivoTemporal.renameTo(ficheroPath)) {
            System.out.println("No se pudo renombrar el archivo temporal.");
        }
    }

}
