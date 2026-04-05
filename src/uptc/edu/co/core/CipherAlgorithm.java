package uptc.edu.co.core;

public interface CipherAlgorithm {
    String encrypt(String text, String key);
    String decrypt(String text, String key);
}