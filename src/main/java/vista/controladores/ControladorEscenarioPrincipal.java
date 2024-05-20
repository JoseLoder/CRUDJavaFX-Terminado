package vista.controladores;

import controlador.Controlador;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Persona;
import modelo.Personas;

import java.util.ArrayList;

public class ControladorEscenarioPrincipal {

    // Declaramos el controlador
    private Controlador controladorMVC;

    // Constructor
    public ControladorEscenarioPrincipal(Controlador controlador) {
        this.controladorMVC = controlador;

    }
    // Setter para el controlador que nos va a pasar la vista
    public void setControladorMVC(Controlador controlador) {
        this.controladorMVC = controlador;
    }

    // Método que se ejecuta nada más cargar
    @FXML
    void initialize() {
    // Creación de la tabla de personas
        // Configuramos las columnas de la tabla
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcApellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tcDni.setCellValueFactory(new PropertyValueFactory<>("dni"));

        // Cargamos los datos de la tabla
        try{
            tvListaPersonas.getItems().addAll(controladorMVC.getPersonas());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


//CRUD

    // CREATE
    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtDni;

    @FXML
    private TextField txtNombre;

    @FXML
    void crearPersona(ActionEvent event) {

        //Obtenemos los datos de los campos de texto
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String dni = txtDni.getText();

        //Si alguno de los campos está vacío, no hacemos nada
        if(nombre.isEmpty() || apellidos.isEmpty() || dni.isEmpty()){
            return;
        }

        //Llamamos al método insertarPersona del controlador
        try {
            controladorMVC.insertarPersona(nombre, apellidos, dni);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Limpiamos los campos de texto
        txtNombre.clear();
        txtApellidos.clear();
        txtDni.clear();

        //Actualizamos la tabla
        tvListaPersonas.getItems().clear();
        try{
            tvListaPersonas.getItems().addAll(controladorMVC.getPersonas());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        tvListaPersonas.refresh();
    }

    // READ
    @FXML
    private TableColumn<Persona, String> tcApellidos;

    @FXML
    private TableColumn<Persona, String> tcDni;

    @FXML
    private TableColumn<Persona, String> tcNombre;

    @FXML
    private TableView<Persona> tvListaPersonas;

    // UPDATE
    @FXML
    void modificarPersona(ActionEvent event) {
    //Obtenemos la persona seleccionada en la tabla
    Persona persona = tvListaPersonas.getSelectionModel().getSelectedItem();

    //Si no hay ninguna persona seleccionada, no hacemos nada
    if(persona == null){
        return;
    }

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/EscenarioSecundario.fxml"));
    ControladorEscenarioSecundario controladorModificar = new ControladorEscenarioSecundario(controladorMVC, persona);
    try{
        loader.setController(controladorModificar);
        AnchorPane root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Modificar persona");
        stage.showAndWait();

        //Actualizamos la tabla
        tvListaPersonas.getItems().clear();
        tvListaPersonas.getItems().addAll(controladorMVC.getPersonas());
        tvListaPersonas.refresh();

    }catch (Exception e){
        System.out.println(e.getMessage());
    }
}

    // DELETE
    @FXML
    void borrarPersona(ActionEvent event) {
        Persona persona = tvListaPersonas.getSelectionModel().getSelectedItem();

        if(persona == null){
            return;
        }

        try {
            controladorMVC.eliminar(persona);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        tvListaPersonas.getItems().clear();
        try{
            tvListaPersonas.getItems().addAll(controladorMVC.getPersonas());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        tvListaPersonas.refresh();

    }
}
