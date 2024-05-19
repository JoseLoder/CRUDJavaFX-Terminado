package modelo;

public class Persona {

    //Declaración de variables
    private String nombre;
    private String apellido;
    private String dni;

    //Constructor
    public Persona(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede ser nulo o vacío");
        }
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El dni no puede ser nulo o vacío");
        }
        this.dni = dni;
    }

    //Método toString
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + '}';
    }
}
