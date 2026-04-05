package uptc.edu.co.core;

public class CaesarCipher implements CipherAlgorithm {


    @Override
    public String encrypt(String text, String key) {
        StringBuilder encryptedText = new StringBuilder();
        int keyINt = key.length();

        for (char currentChar : text.toCharArray()) {
            if (currentChar >= 'a' && currentChar <= 'z') {
                char encryptedChar = (char)((currentChar - 'a' + keyINt) % 26 + 'a');
                encryptedText.append(encryptedChar);

            } else if (currentChar >= 'A' && currentChar <= 'Z') {
                char encryptedChar = (char)((currentChar - 'A' + keyINt) % 26 + 'A');
                encryptedText.append(encryptedChar);
                
            } else {
                encryptedText.append(currentChar);
            }
        }

        return encryptedText.toString();
    }

    @Override
    public String decrypt(String text, String key) {
        StringBuilder decryptedText = new StringBuilder();
        int keyINt = key.length();

        for (char currentChar : text.toCharArray()) {
            if (currentChar >= 'a' && currentChar <= 'z') {
                char decryptedChar = (char)((currentChar - 'a' - keyINt % 26 + 26) % 26 + 'a');
                decryptedText.append(decryptedChar);

            } else if (currentChar >= 'A' && currentChar <= 'Z') {
                char encryptedChar = (char)((currentChar - 'A' - keyINt % 26 + 26) % 26 + 'A');
                decryptedText.append(encryptedChar);

            } else {
                decryptedText.append(currentChar);
            }
        }
        return decryptedText.toString();
    }
}
