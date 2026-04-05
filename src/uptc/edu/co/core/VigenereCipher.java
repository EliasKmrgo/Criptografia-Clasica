package uptc.edu.co.core;

public class VigenereCipher implements CipherAlgorithm {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public String encrypt(String text, String key) {
        return translateMessage(text, key, "encrypt");
    }

    @Override
    public String decrypt(String text, String key) {
        return translateMessage(text, key, "decrypt");
    }

    private String translateMessage(String message, String key, String action) {
        StringBuilder translated = new StringBuilder();
        int indexKey = 0;
        key = key.toUpperCase();

        for (char symbol : message.toCharArray()) {
            int num = ALPHABET.indexOf(Character.toUpperCase(symbol));

            if (num != -1) {
                int numkey = ALPHABET.indexOf(key.charAt(indexKey));

                if (action.equals("encrypt")) {
                    num += numkey;
                } else {
                    num -= numkey;
                }

                num = (num % ALPHABET.length() + ALPHABET.length()) % ALPHABET.length();

                if (Character.isUpperCase(symbol)) {
                    translated.append(ALPHABET.charAt(num));
                } else {
                    translated.append(Character.toLowerCase(ALPHABET.charAt(num)));
                }

                indexKey++;
                if (indexKey == key.length()) {
                    indexKey = 0;
                }
            } else {
                translated.append(symbol);
            }
        }
        return translated.toString();
    }
}