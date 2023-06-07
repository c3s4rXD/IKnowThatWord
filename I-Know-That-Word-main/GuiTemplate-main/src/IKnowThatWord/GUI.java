package IKnowThatWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class is used for ...
 * @autor Cesar Mauricio Hincapie Lopez cesar.hincapie@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {
    public static final String BEGINNING_MESSAGE="Bienvenido al juego 'I KNOW THAT WORD!!!' este es un juego de palabras y el objetivo es ver si puedes memorizar las palabras que se muestran por pantalla."
                        +"\n \n El juego cuenta con 10 niveles, Siendo cada nivel un poco mas complicado que el anterior."
                        +"\n \n Comenzaremos enseñandote las palabras que vas a memorizar,"
                        +"una vez comienza el juego,apareceran palabras de manera aleatoria y deberas determinar si dicha palabra es una de las que se te encargo a memorizar anteriormente al comenzar o no, "
                        +" y dependiendo de tus aciertos avanzaras o no de nivel."
                        +"\n \n Te deseo suerte";
    /*
     * Atributos
     */
    private Header headerProject;
    private JButton ayuda, salir, iniciar;
    private Escucha escucha;
    private FileManager fileManager;
    private Timer timer1, timer2;
    private Juego juego;
    private PanelDeFrases panelDeFrases;


    /**
     * Constructor de la clase GUI
     */
    public GUI() {
        initGUI();

        //Configuracion del JFrame
        this.setTitle("¿I KNOW THAT WORD?");
        //this.pack();
        this.setBackground(new Color(255, 255, 255, 255));
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * Este metodo se usa para configurar por default los JComponent,
     * creacion d elos listener y objetos de control que usaremos para la CUI
     */
    private void initGUI() {

        //Configuracion del diseño del contenedor del JFram
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Crear el objeto listener y el control de objeros
        escucha = new Escucha();
        panelDeFrases = new PanelDeFrases();
        fileManager = new FileManager();
        juego = new Juego();

        //Configuracion de los JComponents

        /*
         *creacion del header
         */
        headerProject = new Header("I KNOW THAT WORD", Color.BLACK);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constraints);

        /*
         * Creacion del boton de ayuda
         */
        ayuda = new JButton("AYUDA");
        ayuda.addActionListener(escucha);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(ayuda, constraints);

        /*
         *Creacion del boton de salida
         */
        salir = new JButton("SALIR");
        salir.addActionListener(escucha);
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(salir, constraints);

        /*
         * Coloca y crea el panel de las frases
         */
        panelDeFrases.setPreferredSize(new Dimension(700, 500));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(panelDeFrases, constraints);

        /*
         * Creacion del boton para iniciar el juego
         */
        iniciar = new JButton("JUGAR");
        iniciar.addActionListener(escucha);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        add(iniciar, constraints);

        /*
         * Creacion de los Timer 1 y timer 2
         */
        timer1 = new Timer(5000, escucha);
        timer1.start();

        timer2 = new Timer(7000, escucha);
        timer2.start();


    }

    /**
     *
     *
     * @param args Objeto usada para enviar datos de entrada desde una linea de comandos cuando
     *             el programa se ejecute por consola.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * clase externa que extiende un adaptador de clase o implementa los listener de la clase GUI
     */
    private class Escucha implements ActionListener {

        /*
         * Atributos de la clase escucha
         */
        private ArrayList<String> NombreUsuarios, PalabrasDelNivel, palabrasBuenas;
        private boolean banderaTimer1 = false, banderaTimer2 = false, repetirLevel = false, ganarNivel = false;
        private int contador = 0, nivelUsuario = 1, aciertos = 0, bienvenido = 1, primerTiempo = 1;
        private Random random = new Random();
        private String logo, logo2, nombre;

        /*
         * Constructor
         */
        public Escucha() {
            NombreUsuarios = new ArrayList<String>();
            PalabrasDelNivel = new ArrayList<String>();
            palabrasBuenas = new ArrayList<String>();

            logo = "";
            nombre = "";
            logo2 = "I KNOW THAT WORD";
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            /*
             * Boton de juego
             */
            if (e.getSource() == iniciar) {

                /*
                 * Bienvenida al jugador
                 */
                if (bienvenido == 1) {
                    int frequentUser = 0;
                    NombreUsuarios = fileManager.leyendoArchivoDeUsuarios();
                    nombre = JOptionPane.showInputDialog("Bienvenido , inserta tu nombre de jugador");
                    for (int i = 0; i < NombreUsuarios.size(); i++) {
                        int twoPoints = NombreUsuarios.get(i).indexOf(":");
                        if (NombreUsuarios.get(i).substring(0, twoPoints).equals(nombre)) {
                            nivelUsuario = Integer.parseInt(NombreUsuarios.get(i).substring(twoPoints + 1));
                            JOptionPane.showMessageDialog(null, "Hola otra vez " + nombre + " , que te diviertas!");
                            frequentUser = 1;
                            break;
                        }
                    }
                    if (nombre != null && frequentUser == 0) {
                        NombreUsuarios.add(nombre);
                        fileManager.escribirTexto(nombre, nivelUsuario);
                    }
                    while (nombre == null) {
                        nombre = JOptionPane.showInputDialog("Digita un nombre de jugador ");
                        for (int i = 0; i < NombreUsuarios.size(); i++) {
                            int twoPoints = NombreUsuarios.get(i).indexOf(":");
                            if (NombreUsuarios.get(i).substring(0, twoPoints).equals(nombre)) {
                                nivelUsuario = Integer.parseInt(NombreUsuarios.get(i).substring(twoPoints + 1));
                                JOptionPane.showMessageDialog(null, "Hola otra vez " + nombre + " , que te diviertas!");
                                frequentUser = 1;
                                break;
                            }
                        }
                        if (nombre != null && frequentUser == 0) {
                            NombreUsuarios.add(nombre);
                            fileManager.escribirTexto(nombre, nivelUsuario);
                        }
                    }
                    bienvenido = 0;
                }

                /*
                 * Si el jugador pasa de nivel , se ejecutará este metodo
                 */
                if (ganarNivel == true) {
                    fileManager.limpiarTexto();
                    fileManager.reescribirNivel(NombreUsuarios, nombre, nivelUsuario);
                    iniciar.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "A continuacion veras las palabras a memorizar, debes prestar mucha atencion");
                    //dictionary.reset();
                    PalabrasDelNivel = juego.getJuegoDePalabras(nivelUsuario);
                    palabrasBuenas.clear();
                    panelDeFrases.setLogo(logo);
                    aciertos = 0;
                    ganarNivel = false;
                    timer1.start();
                    timer2.start();
                    banderaTimer1 = true;
                }

                /*
                 * Si el jugador pierde el nivel, debera repetirlo
                 */
                if (repetirLevel == true) {
                    iniciar.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "A continuacion veras las palabras a memorizar, debes prestar mucha atencion");
                    //dictionary.reset();
                    PalabrasDelNivel = juego.getJuegoDePalabras(nivelUsuario);
                    palabrasBuenas.clear();
                    panelDeFrases.setLogo(logo);
                    aciertos = 0;
                    repetirLevel = false;
                    timer1.start();
                    timer2.start();
                    banderaTimer1 = true;
                }

                /*
                 * timer 1 empieza
                 */
                if (primerTiempo == 1) {
                    iniciar.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "A continuacion veras las palabras a memorizar, debes prestar mucha atencion");
                    PalabrasDelNivel = juego.getJuegoDePalabras(nivelUsuario);
                    panelDeFrases.setLogo(logo);
                    banderaTimer1 = true;
                    primerTiempo = 0;
                }
            }

            /*
             * timer 1
             */
            if (e.getSource() == timer1 && banderaTimer1 == true) {
                /*
                 * palabras que el usuario debe recordar
                 */
                if (contador < juego.tamañoPalabrasCorrectas(nivelUsuario)) {
                    /*
                     * colocar las palabras en el panel
                     */
                    String laPalabra = PalabrasDelNivel.get(random.nextInt(PalabrasDelNivel.size()));
                    palabrasBuenas.add(laPalabra);
                    panelDeFrases.setPalabra(laPalabra);
                    panelDeFrases.updateUI();
                    contador++;
                } else {
                    /*
                     *Timer 1 para y timer 2 empieza
                     */
                    timer1.stop();
                    panelDeFrases.setPalabra("");
                    contador = 0;
                    JOptionPane.showMessageDialog(null, "A continuacion veras las palabras y determinaras si estaban , debes prestar mucha atencion");
                    System.out.println(palabrasBuenas);
                    banderaTimer1 = false;
                    banderaTimer2 = true;
                }
            }

            /*
             * Timer 2
             */
            if (e.getSource() == timer2 && banderaTimer2 == true) {
                /*
                 * Palabras del nivel
                 */
                if (contador < PalabrasDelNivel.size()) {
                    /*
                     * coloca todas las palabrar en el panel
                     */
                    String laPalabra = PalabrasDelNivel.get(contador);
                    panelDeFrases.setPalabra(laPalabra);
                    int option = JOptionPane.showConfirmDialog(panelDeFrases, "Esta palabra pertenecia a las 10 que memorizaste?", "Escoge una ventana", JOptionPane.YES_NO_OPTION);
                    boolean flag = false;
                    for (int i = 0; i < palabrasBuenas.size(); i++) {
                        if (laPalabra.equals(palabrasBuenas.get(i))) {
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                    }
                    /*
                     * El jugador debe escoger la opcion correcta
                     */
                    if (flag == true && option == JOptionPane.YES_OPTION) {
                        aciertos++;
                        JOptionPane.showMessageDialog(null, "Acertaste");
                    }
                    if (flag == false && option == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Fallaste");
                    }
                    if (flag == true && option == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Fallaste");
                    }
                    if (flag == false && option == JOptionPane.NO_OPTION) {
                        aciertos++;
                        JOptionPane.showMessageDialog(null, "Acertaste");
                    }
                    contador++;
                } else {
                    /*
                     * Timer 2 stop
                     */
                    timer2.stop();
                    panelDeFrases.setPalabra("");
                    /*
                     * El jugador gano o perdio
                     */
                    if (!juego.ganar(nivelUsuario, aciertos)) {
                        JOptionPane.showMessageDialog(null, "No alcanzaste el numero de aciertos, Presiona el boton jugar para volver a comenzar");
                        repetirLevel = true;
                    }
                    if (juego.ganar(nivelUsuario, aciertos)) {
                        JOptionPane.showMessageDialog(null, "Felicidades , presiona el boton para iniciar con la siguiente ronda");
                        nivelUsuario++;
                        ganarNivel = true;
                    }
                    iniciar.setEnabled(true);
                    contador = 0;
                    panelDeFrases.setLogo(logo2);
                    banderaTimer2 = false;
                }
            }

            /*
             * Boton de ayuda
             */
            if (e.getSource() == ayuda) {
                JOptionPane.showMessageDialog(null, BEGINNING_MESSAGE);
            }

            /*
             * Boton de salida
             */
            if (e.getSource() == salir) {
                System.exit(0);
            }
        }
    }
}

