# Criptografía Clásica
Sistema de cifrado y descifrado diseñado para periodistas de investigación, permitiendo la protección de hallazgos mediante algoritmos criptográficos clásicos.

## Instrucciones de Compilación y Ejecución

### Requisitos
* Java JDK 17 o superior.
* Terminal de comandos (PowerShell, Bash o CMD).

### Compilación
Abra la terminal de comandos y ubiquese en la carpeta en la que se encuentre el Cipher.jar(para el ejemplo se usara el src de este repositorio), ejecute el siguiente comando para compilar todos los módulos:

Este comando muestra lo necesario para el funcionamiento del programa:
```bash
java -jar Cipher.jar

Salida en pantalla:
Error: Falta el argumento obligatorio --cipher

MODO DE USO:
java -jar cipher.jar --cipher {caesar|vigenere} --mode {enc|dec} --key <clave> --in <archivo> --out <archivo> --normalize {strict|lax}
```

Este comando muestra como cifrar el archivo ParaCifrar.txt con vigenere y una normalizacion lax:
```bash
java -jar Cipher.jar --cipher vigenere --mode enc --key lemon --in src\data\ParaCifrar.txt --out src\data\ParaDecifrar.txt --normalize lax
```

Este comando muestra como decifrar el archivo ParaDecifrar.txt, recuerde usar el mismo cifrador y clave que uso para el cifrado:
```bash
java -jar Cipher.jar --cipher vigenere --mode dec --key lemon --in src\data\ParaDecifrar.txt --out src\data\Decifrado.txt --normalize lax
```
