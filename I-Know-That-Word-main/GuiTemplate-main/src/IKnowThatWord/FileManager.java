package IKnowThatWord;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String PATH_USUARIOS="src/archivos/usuarios.txt";
    private static final String PATH_PALABRAS="src/archivos/palabras.txt";
    private FileReader fileReader;
    private BufferedReader entrada;
    private FileWriter fileWriter;
    private BufferedWriter salida;

    /*
     * Método que devuelve usuarios registrados
     */
    public ArrayList<String> leyendoArchivoDeUsuarios()
    {
        ArrayList<String>NombreUsuarios=new ArrayList<>();
        try {
            fileReader = new FileReader(PATH_USUARIOS); //agarra el archivo de los usuarios y los lee
            entrada = new BufferedReader(fileReader);
            String line = entrada.readLine();
            while(line!=null)
            {
                NombreUsuarios.add(line);
                line=entrada.readLine();
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            try {
                entrada.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return NombreUsuarios;
    }

    /*
     * Método que devuelve las palabras del archivo
     */

    public ArrayList<String> leyendoArchivoDePalabras()
    {
        ArrayList<String> frases=new ArrayList<String>();
        try {
            fileReader = new FileReader(PATH_PALABRAS); //lee el archivo de las palabras
            entrada = new BufferedReader(fileReader);
            String line = entrada.readLine();
            while(line!=null)
            {
                frases.add(line);
                line=entrada.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                entrada.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return frases;
    }

    /*
     * Método que permite escribir en el archivo
     */

    public void escribirTexto(String linea, int nivel)
    {
        try
        {
            fileWriter = new FileWriter(PATH_USUARIOS,true);
            salida = new BufferedWriter(fileWriter);
            salida.write(linea+":"+nivel);
            salida.newLine();
        } catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            try
            {
                salida.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /*
     * Método que permite volver a escribir en el archivo
     */

    public void reescribirNivel(ArrayList<String> usuarios, String nombre, int nivel)
    {
        try
        {
            fileWriter = new FileWriter(PATH_USUARIOS,true);
            salida = new BufferedWriter(fileWriter);
            salida.write(nombre+":"+nivel);
            salida.newLine();
            for (int i=0; i < usuarios.size(); i++)
            {
                int twoPoints=usuarios.get(i).indexOf(":");
                if (!usuarios.get(i).substring(0, twoPoints).equals(nombre))
                {
                    salida.write(usuarios.get(i));
                    salida.newLine();
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            try
            {
                salida.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /*
     * Método que permite limpiar el archivo
     */
    public void limpiarTexto()
    {
        try
        {
            salida = new BufferedWriter(new FileWriter(PATH_USUARIOS));
            salida.write("");
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
