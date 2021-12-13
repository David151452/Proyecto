
package modelo;

/*
 * @author David Bravo
 * @author Solange Soto
 * @author Orlando Mendoza
 * @author Lucianno Valdebenito
 */
public class Persona {
    
    //Atributos
    String nombre;
    int edad;
    String telefono;
    String rut;
    String contrasena;
    
    //Constructor lleno
    public Persona(String nombre, int edad, String telefono, String rut, String contrasena) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.rut = rut;
        this.contrasena = contrasena;
    }
    //Contructor vacio
    public Persona() {
    }
    
    //Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
   
    
    
    //ToString
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", telefono=" + telefono + ", rut=" + rut + ", contrasena=" + contrasena + '}';
    }
}
