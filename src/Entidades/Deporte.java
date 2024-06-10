package Entidades;

import java.io.Serializable;

public class Deporte implements Serializable{
    private String codigo_Deporte, nombre_Deporte;

    public Deporte(String codigo_Deporte, String nombre_Deporte) {
        this.codigo_Deporte = codigo_Deporte;
        this.nombre_Deporte = nombre_Deporte;
    }

    public String getCodigo_Deporte() {
        return codigo_Deporte;
    }

    public void setCodigo_Deporte(String codigo_Deporte) {
        this.codigo_Deporte = codigo_Deporte;
    }

    public String getNombre_Deporte() {
        return nombre_Deporte;
    }

    public void setNombre_Deporte(String nombre_Deporte) {
        this.nombre_Deporte = nombre_Deporte;
    } 
    
}
