package modelo;

import java.util.ArrayList;

public class Personas {

    //Declaración de variables
    private ArrayList<Persona> listaPersonas;

    //Constructor
    public Personas() {
        listaPersonas = new ArrayList<>();
    }

    //CRUD

    //Create
    public void aniadirPersona(Persona persona) {
        if (persona == null) {
            throw new NullPointerException("La persona no puede ser nula");
        }
        listaPersonas.add(persona);
    }

    //Read
    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    //Update
    public void modificarPersona(Persona persona, String nombre, String apellido) {
        if (persona == null) {
            throw new NullPointerException("La persona no puede ser nula");
        }

        for (Persona p : listaPersonas) {
            if (p.equals(persona)) {
                p.setNombre(nombre);
                p.setApellido(apellido);
            }
        }
    }


    //Delete
    public void eliminarPersona(Persona persona) {
        if (persona == null) {
            throw new NullPointerException("La persona no puede ser nula");
        }
        listaPersonas.remove(persona);
    }

}
