package modelo;

/*
 * @author David Bravo
 * @author Solange Soto
 * @author Orlando Mendoza
 * @author Lucianno Valdebenito
 */
public class Veterinario extends Persona {

    //Atributos
    String especialidad;
    String direccion;
    int precio;
    String correo;

    //Constructor con los atributos heredables de la super clase Persona
    public Veterinario(String nombre, int edad, String telefono, String rut, String contrasena) {
        super(nombre, edad, telefono, rut, contrasena);
    }
    
    //Constructor lleno incluyendo los atributos de la super clase Persona
    public Veterinario(String nombre, int edad, String telefono, String rut, String contrasena, String especialidad, String direccion, int precio, String correo) {
        super(nombre, edad, telefono, rut, contrasena);
        this.especialidad = especialidad;
        this.direccion = direccion;
        this.precio = precio;
        this.correo = correo;
    }
    
    //Constructor vacio
    public Veterinario() {
    }

    //Constructor lleno
    public Veterinario(String experiencia, String direccion, int precio, String correo) {
        this.especialidad = especialidad;
        this.direccion = direccion;
        this.precio = precio;
        this.correo = correo;
    }

    //Getters and Setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //ToString
    @Override
    public String toString() {
        return "Veterinario{" + "experiencia=" + especialidad + ", direccion=" + direccion + ", precio=" + precio + ", correo=" + correo + '}';
    }

}
