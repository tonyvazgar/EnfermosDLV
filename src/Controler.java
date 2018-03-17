import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler implements ActionListener {

    InterfazPrincipal view;
    ProjectDeductiveDatabase model;

    public Controler(ProjectDeductiveDatabase model, InterfazPrincipal view){
        this.model = model;
        this.view = view;
    }

    public void actionPerformed(ActionEvent event){
        Button botonAccionado = (Button) event.getSource();
        if (botonAccionado == view.verAnswerSet) {
            view.consola.setText(ProjectDeductiveDatabase.cargarAnswerSet());
        } else if (botonAccionado == view.personasExistentes) {
            view.consola.setText(ProjectDeductiveDatabase.cargarPersonas());
        } else if (botonAccionado == view.sintomasDePersonas) {
            view.consola.setText(ProjectDeductiveDatabase.cargarSintomasDePersonas());
        } else if (botonAccionado == view.medicamentosParaEnfermedad) {
            view.consola.setText(ProjectDeductiveDatabase.cargarMedicinaEnfermedad());
        } else if (botonAccionado == view.posiblesEnfermedades) {
            view.consola.setText(ProjectDeductiveDatabase.cargarPuedeEstarEnfermo());
        } else if (botonAccionado == view.puedeTomarUnaPersona) {
            view.consola.setText(ProjectDeductiveDatabase.cargarPosiblesMedicamentos());
        } else if(botonAccionado == view.enfermedadesSinCura){
            view.consola.setText(ProjectDeductiveDatabase.cargarEnfermedadesConCura());
        }else if(botonAccionado == view.liciados){
            view.consola.setText(ProjectDeductiveDatabase.cargarDesahuciado());
        }else if(botonAccionado == view.amigosEnfermos){
            view.consola.setText(ProjectDeductiveDatabase.cargarAmigos());
        }else if(botonAccionado == view.sinCura){
            view.consola.setText(ProjectDeductiveDatabase.cargarEnfermedadesSinCura());
        }else if(botonAccionado == view.buscarPorPalabra){
            view.consola.setText(ProjectDeductiveDatabase.resumenPorPalabra(obtieneDatoDelView()));
        }
    }

    private String obtieneDatoDelView() {
        String aBuscar = view.buscarPorPalabraField.getText();
        return aBuscar;
    }
}
