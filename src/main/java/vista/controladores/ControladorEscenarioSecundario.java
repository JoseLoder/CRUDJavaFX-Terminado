package vista.controladores;

import controlador.Controlador;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import modelo.Persona;

public class ControladorEscenarioSecundario {

    // Declaramos el controlador
    private Controlador controladorMVC;
    private Persona persona;

    // Constructor
    public ControladorEscenarioSecundario(Controlador controlador,Persona persona) {
        setControladorMVC(controlador);
        this.persona = persona;

    }
    // Setter para el controlador que nos va a pasar la vista
    public void setControladorMVC(Controlador controlador) {
        this.controladorMVC = controlador;
    }

    @FXML
    void initialize() {
        txtNombre.setText(persona.getNombre());
        txtApellidos.setText(persona.getApellido());
        txtDni.setText(persona.getDni());
    }

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtDni;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnModificar;

    @FXML
    void modificar(ActionEvent event) {
        try {
            controladorMVC.modificarPersona(persona,txtNombre.getText(),txtApellidos.getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Cerramos la ventana
        Stage stage=(Stage) btnModificar.getScene().getWindow();
        stage.close();

    }

}
