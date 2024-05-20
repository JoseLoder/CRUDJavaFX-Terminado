package modelo;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;

public class Modelo {

    //Declaración de variables
    private Personas personas;

    //Constructor
    public Modelo() {
        comenzar();
    }

    //Comenzar
    private void comenzar() {
        personas = new Personas();
        personas.aniadirPersona(new Persona("Juan", "García", "12345678A"));
        personas.aniadirPersona(new Persona("María", "López", "87654321B"));
        personas.aniadirPersona(new Persona("Luis", "Martínez", "45678912C"));
    }
    //CRUD

    //Create
    public void insertarPersona(String nombre, String apellidos, String dni) throws OperationNotSupportedException {
        Persona persona = new Persona(nombre,apellidos,dni);
        personas.aniadirPersona(persona);
    }

    //Read
    public ArrayList<Persona> getPersonas() throws OperationNotSupportedException {
        return personas.getListaPersonas();
    }

    //Update
    public void modificarPersona(Persona persona, String nombre, String apellidos) throws OperationNotSupportedException {
        personas.modificarPersona(persona,nombre,apellidos);
    }

    //Delete
    public void eliminar(Persona persona) throws OperationNotSupportedException {
        personas.eliminarPersona(persona);
    }



}
