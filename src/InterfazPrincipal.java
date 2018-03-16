/*
 * Created by TonyVazgar on 1/27/18.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class InterfazPrincipal extends Frame{
    
    /* ---------------------------------------------- *
     *           Elementos de la interfaz             *
     * ---------------------------------------------- */

    Font tipografia = new Font("Helvetica", Font.PLAIN, 14);

    Button verAnswerSet;
    Button personasExistentes;
    Button sintomasDePersonas;
    Button medicamentosParaEnfermedad;
    Button posiblesEnfermedades;
    Button puedeTomarUnaPersona;
    Button enfermedadesSinCura;
    Button liciados;
    Button amigosEnfermos;
    Button sinCura;

    TextArea consola;

    /* ---------------------------------------------- *
     *            Constructor de la clase             *
     * ---------------------------------------------- */
    public InterfazPrincipal() {
        setTitle("*PROGRAMA EN DLV*");
        setBounds(100, 100, 900, 800);
        setLocationRelativeTo(null);
        setBackground(new Color(255,255,255));
        setLayout(null);
        setResizable(false);
        setFont(tipografia);
        constuyeComponentes();
        endProgram();
    }

    /* ---------------------------------------------- *
     *           Metodos del la clase view            *
     * ---------------------------------------------- */
    
    private void constuyeComponentes() {
        ponerBotones();
        ponerConsola();
    }

    private void ponerBotones(){
        verAnswerSet = new Button("Ver el Answer-Set");
        personasExistentes = new Button("Ver las personas que existen");
        sintomasDePersonas = new Button("Ver sintomas de las personas");
        medicamentosParaEnfermedad = new Button("Medicamentos que se usan para enfermedad");
        posiblesEnfermedades = new Button("Enfermedades relacionadas con los sintomas");
        puedeTomarUnaPersona = new Button("Ver lo que puede tomar una persona enferma");
        enfermedadesSinCura = new Button("Ver enfermedades que tienen cura");
        liciados = new Button("Ver personas desahuciadas");
        amigosEnfermos = new Button("Amigos que están en las buenas y en las malas");
        sinCura = new Button("Ver enfermedades SIN cura");

        verAnswerSet.setBounds(570, 100, 300, 20);
        verAnswerSet.setFont(tipografia);
        add(verAnswerSet);
        personasExistentes.setBounds(570, 140, 300, 20);
        add(personasExistentes);
        sintomasDePersonas.setBounds(570, 180, 300, 20);
        add(sintomasDePersonas);
        medicamentosParaEnfermedad.setBounds(570, 220, 300, 20);
        add(medicamentosParaEnfermedad);
        posiblesEnfermedades.setBounds(570,260,300,20);
        add(posiblesEnfermedades);
        puedeTomarUnaPersona.setBounds(570,300,300,20);
        add(puedeTomarUnaPersona);
        enfermedadesSinCura.setBounds(570,340,300,20);
        add(enfermedadesSinCura);
        liciados.setBounds(570,380,300,20);
        add(liciados);
        amigosEnfermos.setBounds(570,420,300,20);
        add(amigosEnfermos);
        sinCura.setBounds(570,460,300,20);
        add(sinCura);

    }

    private void ponerConsola(){
        consola = new TextArea();
        consola.setBounds(50, 50, 500, 700);
        consola.setEditable(false);
        consola.setText("********************************* Inteligencia Artificial *************************************\n" +
                "\n                        Luis Antonio Vázquez García     ID: 153675\n");
        add(consola);
    }

    private void endProgram() {
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
    }

    public void inicia(Controler theControler) {
        setVisible(true);
        setActionListener(theControler);
    }

    public void setActionListener(Controler theController) {
        verAnswerSet.addActionListener(theController);
        sintomasDePersonas.addActionListener(theController);
        medicamentosParaEnfermedad.addActionListener(theController);
        posiblesEnfermedades.addActionListener(theController);
        puedeTomarUnaPersona.addActionListener(theController);
        System.out.println("asdsdsdsfafaf");
        enfermedadesSinCura.addActionListener(theController);
        liciados.addActionListener(theController);
        amigosEnfermos.addActionListener(theController);
        sinCura.addActionListener(theController);
    }
}
