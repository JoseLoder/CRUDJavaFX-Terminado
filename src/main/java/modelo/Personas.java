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
    public void modificarPersona(Persona persona) {
        if (persona == null) {
            throw new NullPointerException("La persona no puede ser nula");
        }
        for (Persona p : listaPersonas) {
            if (p.getDni().equals(persona.getDni())) {
                p.setNombre(persona.getNombre());
                p.setApellido(persona.getApellido());
                p.setDni(persona.getDni());
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
