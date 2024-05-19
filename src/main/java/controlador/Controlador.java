package controlador;

import modelo.Modelo;
import vista.Vista;

public class Controlador {

    private Vista vista;
    private Modelo modelo;

    public Controlador(Modelo modelo,Vista vista) {
        if (modelo == null) {
            throw new NullPointerException("El modelo no puede ser nulo");
        }
        if (vista == null) {
            throw new NullPointerException("La vista no puede ser nula");
        }
        this.modelo = modelo;
        this.vista = vista;
        vista.setControlador(this);
    }

    //Comenzar
    public void comenzar() {
        vista.comenzar();
    }
}
