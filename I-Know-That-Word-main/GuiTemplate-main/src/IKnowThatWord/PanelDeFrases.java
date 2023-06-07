package IKnowThatWord;

import javax.swing.*;
import java.awt.*;

public class PanelDeFrases extends JPanel {

    /*
    *Atributos
    */
    private String palabra, logo;

    /*
    Constructor
    */
    public PanelDeFrases(){
        setBackground(Color.CYAN);
        palabra ="";
        logo="I KNOW THAT WORD!";}

    /*
    *Metodo que coloca la palabra en la pantalla para que el jugador la memorice
    */

    public void setPalabra(String palabra){
        this.palabra = palabra;
        repaint();}

    /*
    *Metodo que coloca el nombre del juego en la pantalla mientras no se muestre una palabra
    */
    public void setLogo(String logo){
        this.logo = logo;
        repaint();}

    /*
    *colorea el panel de las frases
    */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRoundRect(160, 175,400,150,75,75);

        g.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        g.setColor(Color.white);
        g.drawString(logo, 187,265);

        g.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        g.setColor(Color.white);
        g.drawString(palabra, 260,270);
    }
}