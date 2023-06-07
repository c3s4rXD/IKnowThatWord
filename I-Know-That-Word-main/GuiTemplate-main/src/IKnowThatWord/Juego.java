package IKnowThatWord;

import java.util.ArrayList;

public class Juego {

    /*
    * Atributos
    */

    private Vocabulario palabras;

    private ArrayList<String> juegoDePalabras;

    /*
    * Constructor
    */

    public Juego(){
        juegoDePalabras = new ArrayList<String>();
        palabras = new Vocabulario();

    }

    /*
    * Método que devuelve las palabras del nivel
    */

    public ArrayList<String> getJuegoDePalabras(int nivel)
    {
        juegoDePalabras = palabras.getFrases(nivel);
        return juegoDePalabras;


    }

    /*
     * Método que devuelve el tamaño de las palabras buenas en el nivel
     */

    public int tamañoPalabrasCorrectas(int nivel)
    {
        int elnivel= 0;
        switch (nivel)
        {
            case 1 : elnivel=10;
                break;

            case 2 : elnivel=20;
                break;

            case 3 : elnivel=25;
                break;

            case 4 : elnivel=30;
                break;

            case 5 : elnivel=35;
                break;

            case 6 : elnivel=40;
                break;

            case 7 : elnivel=50;
                break;

            case 8 : elnivel=60;
                break;

            case 9 : elnivel=70;
                break;

            case 10 : elnivel=100;
                break;
        }
        return elnivel;

    }

    /*
     * Método que regresa si el usuario gana o pierde
     */
    public boolean ganar(int nivel,int aciertos){

        boolean esGanador = false;
        switch (nivel)
        {
            case 1:
                if (aciertos >= 14)
                {
                    esGanador = true;
                }



            case 2:
                if (aciertos >= 28)
                {
                    esGanador = true;
                }

            case 3:
                if (aciertos >= 37)
                {
                    esGanador = true;
                }

            case 4:
                if (aciertos >= 48)
                {
                    esGanador = true;
                }

            case 5:
                if (aciertos >= 56)
                {
                    esGanador = true;
                }

            case 6:
                if (aciertos >= 68)
                {
                    esGanador = true;
                }

            case 7:
                if (aciertos >= 90)
                {
                    esGanador = true;
                }

            case 8:
                if (aciertos >= 108)
                {
                    esGanador = true;
                }

            case 9:
                if (aciertos >= 133)
                {
                    esGanador = true;
                }

            case 10:
                if (aciertos >= 200)
                {
                    esGanador = true;
                }
                break;
        }
        return esGanador;


    }



}
