package uptc.edu.co.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {

    /**
     * Lee todo el contenido de un archivo de texto.
     * @param path Ruta del archivo (ej: "src/data/notas.txt")
     * @return El contenido en un String.
     * @throws IOException Si el archivo no existe o no se puede leer.
     */
    public static String readFile(String path) throws IOException {
        // Usamos UTF-8 para asegurar que la Ñ y caracteres especiales se lean bien
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    /**
     * Escribe un String en un archivo, creándolo si no existe.
     * @param path Ruta de destino.
     * @param content Texto cifrado o descifrado.
     * @throws IOException Si no hay permisos de escritura.
     */
    public static void writeFile(String path, String content) throws IOException {
        Files.write(Paths.get(path), content.getBytes(StandardCharsets.UTF_8));
    }
}