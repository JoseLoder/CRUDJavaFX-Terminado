package vista.controladores;

import controlador.Controlador;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import modelo.Persona;

import java.util.ArrayList;

public class ControladorEscenarioPrincipal {

//    // Declaramos el controlador
//    private Controlador controladorMVC;
//
//    // Setter para el controlador
//    public void setControladorMVC(Controlador controlador) {
//        this.controladorMVC = controlador;
//    }
//
//    // Setter para el ObservableList
//    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
//        // TODO Aquí se debe cargar la tabla
//    }

    @FXML
    private Label lblHolaMundo;

    @FXML
    void mostrarHolaMundo(ActionEvent event) {
        lblHolaMundo.setText("Hola Mundo");
    }

}
