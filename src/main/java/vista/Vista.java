package vista;

import controlador.Controlador;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import vista.controladores.ControladorEscenarioPrincipal;

//SDK de JavaFX
//https://drive.google.com/file/d/1wVZT3pe-Ajp58jJgLPoLKXTy810iMxr1/view?usp=sharing
public class Vista extends Application {

    protected Controlador controladorMVC;

    private static Vista instancia=null;

    public Vista()
    {
        if (instancia != null)
        {
            controladorMVC = instancia.controladorMVC;
        }
        else
        {
            instancia = this;
        }
    }

    //Setter para el controlador
    public void setControlador(Controlador controlador) {
        this.controladorMVC = controlador;
        if (controladorMVC != null){
            System.out.println("Controlador seteado en la vista");
        }
    }

    //Método para comenzar
    public void comenzar() {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        //Cargamos el archivo FXML y CREAMOS la escena
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/EscenarioPrincipal.fxml"));

        //Creamos una nueva instancia de ControladorEscenarioPrincipal y le pasamos el controlador
        ControladorEscenarioPrincipal controladorJFX = new ControladorEscenarioPrincipal(controladorMVC);

        //Configuramos el controlador del FXMLLoader
        loader.setController(controladorJFX);
        AnchorPane root = loader.load();

        //Mostramos la escena
        stage.setScene(new Scene(root));
        stage.setTitle("Administración de personas");
        stage.show();

    }
}
