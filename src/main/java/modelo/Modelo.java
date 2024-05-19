package modelo;

import javax.naming.OperationNotSupportedException;

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
    public void aniadir(Persona persona) throws OperationNotSupportedException {
        personas.aniadirPersona(persona);
    }

    //Read
    public Personas getPersonas() throws OperationNotSupportedException {
        return personas;
    }

    //Update
    public void modificar(Persona persona) throws OperationNotSupportedException {
        personas.modificarPersona(persona);
    }

    //Delete
    public void eliminar(Persona persona) throws OperationNotSupportedException {
        personas.eliminarPersona(persona);
    }
}
