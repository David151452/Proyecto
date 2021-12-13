package modelo;

import ventana.VentanaCliente;

/*
 * @author David Bravo
 * @author Solange Soto
 * @author Orlando Mendoza
 * @author Lucianno Valdebenito
 */
public class Cliente extends Persona {

    //Atributos
    String mascota;
    int presupuesto;
    
    //Constructor con los atributos heredables de la super clase Persona
    public Cliente(String nombre, int edad, String telefono, String rut, String contrasena) {
        super(nombre, edad, telefono, rut, contrasena);
    }
    //Contructor vacio
    public Cliente() {
    }

    //Constructor lleno
    public Cliente(String mascota, int presupuesto) {
        this.mascota = mascota;
        this.presupuesto = presupuesto;
    }

    //Getters and Setters
    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    //ToString
    @Override
    public String toString() {
        return "Cliente{" + "mascota=" + mascota + ", presupuesto=" + presupuesto + '}';
    }
}
