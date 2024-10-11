package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVUtils {

    /**
     * verifica la existencia de la entidad en el archivo. El nombre del archivo se pasa como string por parámetro
     * @param fileName
     * @param id
     * @return la existencia de la entidad en el archivo
     */
    public static boolean entityExistsOnTheFile(String fileName, String id) {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length > 0 && datos[0].equals(id)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
