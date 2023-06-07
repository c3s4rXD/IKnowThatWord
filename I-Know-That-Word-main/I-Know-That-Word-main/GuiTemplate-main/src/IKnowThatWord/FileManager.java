package IKnowThatWord;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {

    private static final String PATH_USUARIOS="src/files/users.txt";
    private static final String PATH_PALABRAS="src/files/palabras.txt";
    private FileReader fileReader;
    private BufferedReader entrada;
    private FileWriter fileWriter;
    private BufferedWriter salida;
}
