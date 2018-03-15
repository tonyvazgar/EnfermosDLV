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
    Button nuevosHechos;

    TextArea consola;


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
    
    public void constuyeComponentes() {
        ponerBotones();
        ponerConsola();
    }

    public void setActionListener(Object theController) {
        verAnswerSet.addActionListener((ActionListener) theController);
        sintomasDePersonas.addActionListener((ActionListener) theController);
        medicamentosParaEnfermedad.addActionListener((ActionListener) theController);
        posiblesEnfermedades.addActionListener((ActionListener) theController);
        puedeTomarUnaPersona.addActionListener((ActionListener) theController);
        enfermedadesSinCura.addActionListener((ActionListener) theController);
        liciados.addActionListener((ActionListener) theController);
        amigosEnfermos.addActionListener((ActionListener) theController);
        nuevosHechos.addActionListener((ActionListener) theController);
    }

    public void actionPerformed(ActionEvent evento) {

        Button botonAccionado = (Button) evento.getSource();

        if(botonAccionado == verAnswerSet){
            consola.setText(ProjectDeductiveDatabase.cargarAnswerSet());
        }else if(botonAccionado == personasExistentes) {
            consola.setText(ProjectDeductiveDatabase.cargarPersonas());
        }else if(botonAccionado == sintomasDePersonas){
            consola.setText(ProjectDeductiveDatabase.cargarSintomasDePersonas());
        }else if(botonAccionado == medicamentosParaEnfermedad){
            consola.setText(ProjectDeductiveDatabase.cargarMedicinaEnfermedad());
        }else if(botonAccionado == posiblesEnfermedades){
            consola.setText(ProjectDeductiveDatabase.cargarPuedeEstarEnfermo());
        }else if(botonAccionado == puedeTomarUnaPersona){
            consola.setText(ProjectDeductiveDatabase.cargarPosiblesMedicamentos());
        }else if(botonAccionado == enfermedadesSinCura){
        }else if(botonAccionado == liciados){
            consola.setText(ProjectDeductiveDatabase.cargarDesahuciado());
        }else if(botonAccionado == amigosEnfermos){
            consola.setText(ProjectDeductiveDatabase.cargarAmigos());
        }else if(botonAccionado == nuevosHechos){

        }
    }

    /* ---------------------------------------------- *
     *               Metodos propios                  *
     * ---------------------------------------------- */
    
    public void ponerBotones(){
        verAnswerSet = new Button("Ver el Answer-Set");
        personasExistentes = new Button("Ver las personas que existen");
        sintomasDePersonas = new Button("Ver sintomas de las personas");
        medicamentosParaEnfermedad = new Button("Medicamentos que se usan para enfermedad");
        posiblesEnfermedades = new Button("Enfermedades relacionadas con los sintomas");
        puedeTomarUnaPersona = new Button("Ver lo que puede tomar una persona enferma");
        enfermedadesSinCura = new Button("Ver enfermedades que tienen cura");
        liciados = new Button("Ver personas desahuciadas");
        amigosEnfermos = new Button("Amigos que están en las buenas y en las malas");
        nuevosHechos = new Button("Agregar hechos");

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
        nuevosHechos.setBounds(570,460,300,20);
        add(nuevosHechos);

        verAnswerSet.addActionListener(this::actionPerformed);
        personasExistentes.addActionListener(this::actionPerformed);
        sintomasDePersonas.addActionListener(this::actionPerformed);
        medicamentosParaEnfermedad.addActionListener(this::actionPerformed);
        posiblesEnfermedades.addActionListener(this::actionPerformed);
        puedeTomarUnaPersona.addActionListener(this::actionPerformed);
        enfermedadesSinCura.addActionListener(this::actionPerformed);
        liciados.addActionListener(this::actionPerformed);
        amigosEnfermos.addActionListener(this::actionPerformed);
        nuevosHechos.addActionListener(this::actionPerformed);
    }

    public void ponerConsola(){
        consola = new TextArea();
        consola.setBounds(50, 50, 500, 700);
        consola.setEditable(false);
        consola.setText("********************************* Inteligencia Artificial *************************************\n" +
                "\n                        Luis Antonio Vázquez García     ID: 153675\n" +
                "\nProyecto en donde se usa el lenguaje DLV para crear una base de datos\n" +
                "deductiva");
        add(consola);
    }

    public void inicia() {
        setVisible(true);
    }

    public void endProgram() {
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
    }
}
