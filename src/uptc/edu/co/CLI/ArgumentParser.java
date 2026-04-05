package uptc.edu.co.CLI;

import java.util.HashMap;
import java.util.Map;

public class ArgumentParser {

    private Map<String, String> params = new HashMap<>();

    public ArgumentParser(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("--")) {
                if (i + 1 < args.length) {
                    params.put(args[i], args[i + 1]); // Guarda el valor (ej: strict)
                    i++;
                }
            }
        }
    }

    public String get(String flag, String defaultValue) {
        return params.getOrDefault(flag, defaultValue);
    }

    public boolean has(String flag) {
        return params.containsKey(flag);
    }

    public boolean validateRequired() {
        String[] required = {"--cipher", "--mode", "--key", "--in", "--out"};
        for (String flag : required) {
            if (!params.containsKey(flag) || params.get(flag).isEmpty()) {
                System.err.println("Error: Falta el argumento obligatorio " + flag);
                return false;
            }
        }
        return true;
    }
}
