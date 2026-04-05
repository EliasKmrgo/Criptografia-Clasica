import uptc.edu.co.CLI.*;

public class App {
    public static void main(String[] args) throws Exception {
        MenuHandler menu = new MenuHandler();
        menu.run(args);
        
        // String text = "Elías es un niño de la UPTC.2022\n¡Hola, mundo! ¿Cómo estás? ÁÉÍÓÚ ñ Ñ.";
        // TextNormalizerService normalizer = new TextNormalizerService();
        // System.out.println("Original: " + text);
        // System.out.println("Strict Normalized: " + normalizer.normalize(text, "strict", "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"));
        // System.out.println("Lax Normalized: " + normalizer.normalize(text, "lax", "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"));
        // String key = "lemon";
        

        // CaesarCipher caesarCipher = new CaesarCipher();
        // System.out.println("Encrypted: " + caesarCipher.encrypt(text, key));
        // System.out.println("Decrypted: " + caesarCipher.decrypt(caesarCipher.encrypt(text, key), key));
        // System.out.println("------------------------------");
        // VigenereCipher vigenereCipher = new VigenereCipher();
        // System.out.println("Encrypted: " + vigenereCipher.encrypt(text, key));
        // System.out.println("Decrypted: " + vigenereCipher.decrypt(vigenereCipher.encrypt(text, key), key));
    }
}
