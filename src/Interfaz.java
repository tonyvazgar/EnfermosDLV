/*
 * Created by TonyVazgar on 3/10/18.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Interfaz extends Frame{
    
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
    Button buscarPorPalabra;
    TextField buscarPorPalabraField;
    TextArea consola;
    Label ingresaUnaPalabra;

    /* ---------------------------------------------- *
     *            Constructor de la clase             *
     * ---------------------------------------------- */
    public Interfaz() {
        setTitle("*PROGRAMITA EN DLV*");
        setBounds(100, 100, 1000, 800);
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
        buscarPorPalabra = new Button("Bucar por palabra");
        buscarPorPalabraField = new TextField();
        ingresaUnaPalabra = new Label("Ingresa una palabra para buscar informacion relacionada:");

        verAnswerSet.setBounds(570, 100, 400, 20);
        verAnswerSet.setFont(tipografia);
        add(verAnswerSet);
        personasExistentes.setBounds(570, 140, 400, 20);
        add(personasExistentes);
        sintomasDePersonas.setBounds(570, 180, 400, 20);
        add(sintomasDePersonas);
        medicamentosParaEnfermedad.setBounds(570, 220, 400, 20);
        add(medicamentosParaEnfermedad);
        posiblesEnfermedades.setBounds(570,260,400,20);
        add(posiblesEnfermedades);
        puedeTomarUnaPersona.setBounds(570,300,400,20);
        add(puedeTomarUnaPersona);
        enfermedadesSinCura.setBounds(570,340,400,20);
        add(enfermedadesSinCura);
        liciados.setBounds(570,380,400,20);
        add(liciados);
        amigosEnfermos.setBounds(570,420,400,20);
        add(amigosEnfermos);
        sinCura.setBounds(570,460,400,20);
        add(sinCura);
        ingresaUnaPalabra.setBounds(570, 590, 400, 20);
        add(ingresaUnaPalabra);
        buscarPorPalabraField.setBounds(570, 610, 400, 20);
        add(buscarPorPalabraField);
        buscarPorPalabra.setBounds(570,650,400,20);
        add(buscarPorPalabra);
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
        personasExistentes.addActionListener(theController);
        sintomasDePersonas.addActionListener(theController);
        medicamentosParaEnfermedad.addActionListener(theController);
        posiblesEnfermedades.addActionListener(theController);
        puedeTomarUnaPersona.addActionListener(theController);
        enfermedadesSinCura.addActionListener(theController);
        liciados.addActionListener(theController);
        amigosEnfermos.addActionListener(theController);
        sinCura.addActionListener(theController);
        buscarPorPalabra.addActionListener(theController);
    }
}
