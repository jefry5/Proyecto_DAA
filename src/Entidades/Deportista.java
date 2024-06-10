package Entidades;

import java.io.Serializable;
import java.util.Date;

public class Deportista implements Serializable{
    private String dni_Deportista, nombre_Deportista, apellidoPaterno_Deportista, apellidoMaterno_Deportista;
    private int edad_Deportista;
    private Date FechaNacimiento_Deportista;

    public Deportista(String dni_Deportista, String nombre_Deportista, String apellidoPaterno_Deportista, String apellidoMaterno_Deportista, int edad_Deportista/*, Date FechaNacimiento_Deportista*/) {
        this.dni_Deportista = dni_Deportista;
        this.nombre_Deportista = nombre_Deportista;
        this.apellidoPaterno_Deportista = apellidoPaterno_Deportista;
        this.apellidoMaterno_Deportista = apellidoMaterno_Deportista;
        this.edad_Deportista = edad_Deportista;
        /*this.FechaNacimiento_Deportista = FechaNacimiento_Deportista;*/
    }

    public String getDni_Deportista() {
        return dni_Deportista;
    }

    public void setDni_Deportista(String dni_Deportista) {
        this.dni_Deportista = dni_Deportista;
    }

    public String getNombre_Deportista() {
        return nombre_Deportista;
    }

    public void setNombre_Deportista(String nombre_Deportista) {
        this.nombre_Deportista = nombre_Deportista;
    }

    public String getApellidoPaterno_Deportista() {
        return apellidoPaterno_Deportista;
    }

    public void setApellidoPaterno_Deportista(String apellidoPaterno_Deportista) {
        this.apellidoPaterno_Deportista = apellidoPaterno_Deportista;
    }

    public String getApellidoMaterno_Deportista() {
        return apellidoMaterno_Deportista;
    }

    public void setApellidoMaterno_Deportista(String apellidoMaterno_Deportista) {
        this.apellidoMaterno_Deportista = apellidoMaterno_Deportista;
    }

    public int getEdad_Deportista() {
        return edad_Deportista;
    }

    public void setEdad_Deportista(int edad_Deportista) {
        this.edad_Deportista = edad_Deportista;
    }

    public Date getFechaNacimiento_Deportista() {
        return FechaNacimiento_Deportista;
    }

    public void setFechaNacimiento_Deportista(Date FechaNacimiento_Deportista) {
        this.FechaNacimiento_Deportista = FechaNacimiento_Deportista;
    }

}
