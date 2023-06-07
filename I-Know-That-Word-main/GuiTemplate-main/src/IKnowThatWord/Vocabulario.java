package IKnowThatWord;

import java.util.ArrayList;
import java.util.Random;

/**
 * Carlos Fernando Dradá Hincapié - 2040171 - carlos.drada@correounivalle.edu.co
 * Cesar Mauricio Hincapié Lopez - 2228820 - cesar.hincapie@correounivalle.edu.co
 */
public class Vocabulario
{
    /*
     * Atributos
     */
    private ArrayList<String> palabras=new ArrayList<String>();
    private FileManager fileManager;

    /*
     * Constructor
     */
    public Vocabulario()
    {
        fileManager=new FileManager();
        palabras=fileManager.leyendoArchivoDePalabras();
    }

    /*
     * Metodo que retornara el numero de palabras del nivel
     */
    public ArrayList<String> getFrases(int nivel)
    {
        ArrayList<String> frasesDelJuego=new ArrayList<String>();
        Random random=new Random();
        int cantidadDeFrases=0;
        switch (nivel)
        {
            case 1:
                while(cantidadDeFrases < 20)
                {
                    int number=random.nextInt(palabras.size());
                    frasesDelJuego.add(palabras.get(number));
                    palabras.remove(number);
                    cantidadDeFrases++;
                }
                break;

            case 2:
                while(cantidadDeFrases < 40)
                {
                    int number=random.nextInt(palabras.size());
                    frasesDelJuego.add(palabras.get(number));
                    palabras.remove(number);
                    cantidadDeFrases++;
                }
                break;

            case 3:
                while(cantidadDeFrases < 50)
                {
                    int number=random.nextInt(palabras.size());
                    frasesDelJuego.add(palabras.get(number));
                    palabras.remove(number);
                    cantidadDeFrases++;
                }
                break;

            case 4:
                while(cantidadDeFrases < 60)
                {
                    int number=random.nextInt(palabras.size());
                    frasesDelJuego.add(palabras.get(number));
                    palabras.remove(number);
                    cantidadDeFrases++;
                }
                break;

            case 5:
                while(cantidadDeFrases < 70)
                {
                    int number=random.nextInt(palabras.size());
                    frasesDelJuego.add(palabras.get(number));
                    palabras.remove(number);
                    cantidadDeFrases++;
                }
                break;

            case 6:
                while(cantidadDeFrases < 80)
                {
                    int number=random.nextInt(palabras.size());
                    frasesDelJuego.add(palabras.get(number));
                    palabras.remove(number);
                    cantidadDeFrases++;
                }
                break;

            case 7:
                while(cantidadDeFrases < 100)
                {
                    int number=random.nextInt(palabras.size());
                    frasesDelJuego.add(palabras.get(number));
                    palabras.remove(number);
                    cantidadDeFrases++;
                }
                break;

            case 8:
                while(cantidadDeFrases < 120)
                {
                    int number=random.nextInt(palabras.size());
                    frasesDelJuego.add(palabras.get(number));
                    palabras.remove(number);
                    cantidadDeFrases++;
                }
                break;

            case 9:
                while(cantidadDeFrases < 140)
                {
                    int number=random.nextInt(palabras.size());
                    frasesDelJuego.add(palabras.get(number));
                    palabras.remove(number);
                    cantidadDeFrases++;
                }
                break;

            case 10:
                while(cantidadDeFrases < 200)
                {
                    int number=random.nextInt(palabras.size());
                    frasesDelJuego.add(palabras.get(number));
                    palabras.remove(number);
                    cantidadDeFrases++;
                }
                break;
        }
        return frasesDelJuego;
    }
}