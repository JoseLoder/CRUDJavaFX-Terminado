package controlador;

import modelo.Modelo;
import modelo.Persona;
import vista.Vista;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;

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

    public void insertarPersona(String nombre, String apellidos, String dni) throws Exception {
        modelo.insertarPersona(nombre, apellidos, dni);
    }

    public ArrayList<Persona> getPersonas() throws OperationNotSupportedException {
        return modelo.getPersonas();
    }

    public void eliminar(Persona persona) throws OperationNotSupportedException {
        modelo.eliminar(persona);
    }

    public void modificarPersona(Persona persona, String nombre, String apellidos) throws OperationNotSupportedException {
        modelo.modificarPersona(persona, nombre, apellidos);
    }
}
