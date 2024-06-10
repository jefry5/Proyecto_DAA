package Entidades;

import java.io.Serializable;
import java.util.Calendar;

public class Evento_Deportivo implements Serializable{
    
    private int codigo_Evento;
    private String nombre_Evento;
    private Calendar fecha_Inicio_Evento, fecha_Fin_Evento;
    
    public Evento_Deportivo(int codigo, String nombre, Calendar fInicio, Calendar fFin){
        this.codigo_Evento = codigo;
        this.nombre_Evento = nombre;
        this.fecha_Inicio_Evento = fInicio;
        this.fecha_Fin_Evento = fFin;
    }

    public int getCodigo_Evento() {
        return codigo_Evento;
    }

    public String getNombre_Evento() {
        return nombre_Evento;
    }

    public Calendar getFecha_Inicio_Evento() {
        return fecha_Inicio_Evento;
    }

    public Calendar getFecha_Fin_Evento() {
        return fecha_Fin_Evento;
    }

    public void setCodigo_Evento(int codigo_Evento) {
        this.codigo_Evento = codigo_Evento;
    }

    public void setNombre_Evento(String nombre_Evento) {
        this.nombre_Evento = nombre_Evento;
    }

    public void setFecha_Inicio_Evento(Calendar fecha_Inicio_Evento) {
        this.fecha_Inicio_Evento = fecha_Inicio_Evento;
    }

    public void setFecha_Fin_Evento(Calendar fecha_Fin_Evento) {
        this.fecha_Fin_Evento = fecha_Fin_Evento;
    }
    
}
