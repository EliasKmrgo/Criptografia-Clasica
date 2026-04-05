package uptc.edu.co.services;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class TextNormalizerService {

    public static String normalize(String text, String mode, String alphabet) {
        if (text == null || text.isEmpty()) return "";

        
        // Usamos NFD para separar la letra de su acento y luego eliminamos el acento.
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        normalized = pattern.matcher(normalized).replaceAll("");

        normalized = normalized.replace("n\u0303", "ñ").replace("N\u0303", "Ñ");

        if ("strict".equalsIgnoreCase(mode)) {
            // MODO STRICT:
            // Convertimos a mayúsculas y eliminamos TODO lo que no esté en el alfabeto
            StringBuilder sb = new StringBuilder();
            String upperText = normalized.toUpperCase();
            for (char c : upperText.toCharArray()) {
                if (alphabet.indexOf(c) != -1) {
                    sb.append(c);
                }
            }
            return sb.toString();
        } else if ("lax".equalsIgnoreCase(mode)) {
            return normalized; // Puedes usar .toUpperCase() aquí si prefieres consistencia
        }
        throw new IllegalArgumentException("Modo no válido. Use 'strict' o 'lax'.");
    }
}
