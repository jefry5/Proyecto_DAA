package Entidades;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;

public class Evento implements Serializable{
    
    private int codigo_Evento;
    private String nombre_Evento;
    private Calendar fecha_Inicio_Evento, fecha_Fin_Evento;
    private ArregloDeEquipos equiposGes;
    private Fixture enfrentamientosGes;
    private boolean eventoFinalizado;
    
    public Evento(int codigo, String nombre, Calendar fInicio, Calendar fFin){
        this.codigo_Evento = codigo;
        this.nombre_Evento = nombre;
        this.fecha_Inicio_Evento = fInicio;
        this.fecha_Fin_Evento = fFin;
        this.eventoFinalizado = false;
    }
    
    public void iniciarEnfrentamientos(){
        this.equiposGes = new ArregloDeEquipos();
        this.enfrentamientosGes = new Fixture(equiposGes,fecha_Inicio_Evento,fecha_Fin_Evento);
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

    public boolean isEventoFinalizado() {
        return eventoFinalizado;
    }

    public void setEventoFinalizado(boolean eventoFinalizado) {
        this.eventoFinalizado = eventoFinalizado;
    }
    
    public ArregloDeEquipos getEquiposGes() {
        return equiposGes;
    }

    public Fixture getEnfrentamientosGes() {
        return enfrentamientosGes;
    }
    
    public Calendar fechaMayor(Gestionador gesEvento) throws IOException, FileNotFoundException, ClassNotFoundException{
        String[] archivos = gesEvento.listarArchivos();
        Calendar fechaMayor = null;
        if(archivos.length > 0){
            Gestionador aux = new Gestionador();
            aux.setEventoDeportivo(gesEvento.cargarArchivo(archivos[0]));
            fechaMayor = aux.getEventoDeportivo().getFecha_Fin_Evento();
            for(int i=1 ; i<archivos.length; i++){
                aux.setEventoDeportivo(gesEvento.cargarArchivo(archivos[i]));
                Calendar fechaAux = aux.getEventoDeportivo().getFecha_Fin_Evento();
                if(fechaAux.compareTo(fechaMayor)>0){
                    fechaMayor = fechaAux;
                }
            } 
        }
        return fechaMayor;
    }
    
    public boolean antesUltimoEvento(Calendar fecha, Gestionador gesEvento) throws IOException, FileNotFoundException, ClassNotFoundException{ 
        Calendar fechaMayor = fechaMayor(gesEvento);
        if(fechaMayor != null){
            fechaMayor.add(Calendar.DAY_OF_MONTH, 1);
            return fecha.before(fechaMayor);
        }else{
            return false;
        }
    }
    
    public boolean existeCodigo(int codigo, Gestionador gesEvento) throws IOException, FileNotFoundException, ClassNotFoundException{
        String[] archivos = gesEvento.listarArchivos();
        boolean encontro = false;
        if(archivos.length > 0){
            int i = 0;
            Gestionador aux = new Gestionador();
            while (i < archivos.length && !encontro){
                aux.setEventoDeportivo(gesEvento.cargarArchivo(archivos[i]));
                int codigoAux = aux.getEventoDeportivo().getCodigo_Evento();
                if(codigo == codigoAux){
                    encontro = true;
                }
                i++;
            }
        }
        return encontro;
    }
    
}
