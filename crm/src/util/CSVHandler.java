package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVHandler {
    private final File filePath;
    private final String path="C:\\Users\\migue\\Documents\\developer\\CodeIntelligence-java\\crm\\src\\resources\\users.csv";

    public CSVHandler() {
        this.filePath = new File(path);
    }

    public void writeNewUserLine(String id, String name, String email, int age) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(id + "," + name + "," + email + "," + age + "\n");
            System.out.println("Usuario escrito en el archivo: " + id + ", " + name + ", " + email + ", " + age);
        } catch (IOException e) {
            System.out.println("Se ha producido un error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                printLine(parts);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Se ha producido un error al leer el archivo: " + e.getMessage());
        }
    }

    private void printLine(String[] parts) {
        for (String part : parts) {
            System.out.print(part + "  |  ");
        }
    }

    public void deleteUserById(String id) {
        File tempFile = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             FileWriter writer = new FileWriter(tempFile)) {

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (!parts[0].equals(id)) {
                    writer.write(line + "\n");
                } else {
                    found = true;
                }
            }

            if (found) {
                System.out.println("Usuario con ID " + id + " eliminado exitosamente.");
            } else {
                System.out.println("No se encontró un usuario con ID " + id + ".");
            }
        } catch (IOException e) {
            System.out.println("Se ha producido un error al eliminar el usuario: " + e.getMessage());
        }

        if (!filePath.delete()) {
            System.out.println("No se pudo eliminar el archivo original.");
            return;
        }
        if (!tempFile.renameTo(filePath)) {
            System.out.println("No se pudo renombrar el archivo temporal.");
        }
    }

    public void updateUserById(String id, String newName, String newEmail, int newAge) {
        File tempFile = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             FileWriter writer = new FileWriter(tempFile)) {

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(id)) {
                    writer.write(id + "," + newName + "," + newEmail + "," + newAge + "\n");
                    found = true;
                } else {
                    writer.write(line + "\n");
                }
            }

            if (found) {
                System.out.println("Usuario con ID " + id + " actualizado exitosamente.");
            } else {
                System.out.println("No se encontró un usuario con ID " + id + ".");
            }
        } catch (IOException e) {
            System.out.println("Se ha producido un error al actualizar el usuario: " + e.getMessage());
        }

        if (!filePath.delete()) {
            System.out.println("No se pudo eliminar el archivo original.");
            return;
        }
        if (!tempFile.renameTo(filePath)) {
            System.out.println("No se pudo renombrar el archivo temporal.");
        }
    }
}
