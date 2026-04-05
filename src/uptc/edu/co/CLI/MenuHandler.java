package uptc.edu.co.CLI;

import uptc.edu.co.core.*;
import uptc.edu.co.services.*;

public class MenuHandler {

    public void run(String[] args) {
        ArgumentParser parser = new ArgumentParser(args);

        // 1. Validar flags obligatorios
        if (!parser.validateRequired()) {
            showUse();
            return;
        }

        try {
            // 2. Extraer parámetros del Parser
            String cipherType = parser.get("--cipher", "");
            String mode = parser.get("--mode", "");
            String key = parser.get("--key", "");
            String inputPath = parser.get("--in", "");
            String outputPath = parser.get("--out", "");
            String normMode = parser.get("--normalize", "lax");

            // 3. Seleccionar Algoritmo
            CipherAlgorithm algorithm = selectCipher(cipherType);
            if (algorithm == null) return;

            // 4. Orquestar el servicio
            String rawContent = FileService.readFile(inputPath);
            String cleanContent = TextNormalizerService.normalize(rawContent, normMode, "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ");

            String result = mode.equalsIgnoreCase("enc") 
                ? algorithm.encrypt(cleanContent, key) 
                : algorithm.decrypt(cleanContent, key);

            FileService.writeFile(outputPath, result);
            
            System.out.println("\n[OK] Operación finalizada con éxito.");
            System.out.println("[INFO] Algoritmo: " + cipherType.toUpperCase());
            System.out.println("[INFO] Resultado en: " + outputPath);

        } catch (Exception e) {
            System.err.println("[ERROR] Ocurrió un fallo: " + e.getMessage());
        }
    }

    private CipherAlgorithm selectCipher(String type) {
        if (type.equalsIgnoreCase("caesar")) return new CaesarCipher();
        if (type.equalsIgnoreCase("vigenere")) return new VigenereCipher();
        System.err.println("[ERROR] Algoritmo no reconocido.");
        return null;
    }

    private void showUse() {
        System.out.println("\nMODO DE USO:");
        System.out.println("java -jar cipher.jar --cipher {caesar|vigenere} --mode {enc|dec} --key <clave> --in <archivo> --out <archivo> --normalize {strict|lax}");
    }
}