package vista;

import controlador.Controlador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import vista.controladores.ControladorEscenarioPrincipal;

//SDK de JavaFX
//https://drive.google.com/file/d/1wVZT3pe-Ajp58jJgLPoLKXTy810iMxr1/view?usp=sharing
public class Vista extends Application {

    //Declaramos de variables
    private Controlador controladorMVC;

    //Constructor
    public Vista() {
    }

    //Setter para el controlador
    public void setControlador(Controlador controlador) {
        this.controladorMVC = controlador;
    }

    //Método para comenzar
    public void comenzar() {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        //Cargamos el archivo FXML y CREAMOS la escena
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/EscenarioPrincipal.fxml"));
        AnchorPane root = loader.load();

//        //YA CREADA le pasamos el controlador y llenamos la tabla
//        ControladorEscenarioPrincipal controlador = loader.getController();
//        controlador.setControladorMVC(controladorMVC);
//        controlador.setListaPersonas(controladorMVC.getListaPersonas());

        stage.setScene(new Scene(root));
        stage.setTitle("Hola Mundo");
        stage.show();



    }
}
