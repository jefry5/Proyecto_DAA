package Entidades;

import java.util.Calendar;

public class Evento_Deportivo {
    
    private int codigo_Evento;
    private String nombre_Evento;
    private Calendar fecha_Inicio_Evento, fecha_Fin_Evento;
    private GestionarDeEquipos equiposGes;
    private fixtureArbol enfrentamientosGes;

    public Evento_Deportivo(int codigo, String nombre, Calendar fInicio, Calendar fFin){
        this.codigo_Evento = codigo;
        this.nombre_Evento = nombre;
        this.fecha_Inicio_Evento = fInicio;
        this.fecha_Fin_Evento = fFin;
        this.equiposGes = new GestionarDeEquipos();
        this.enfrentamientosGes = new fixtureArbol(equiposGes,fecha_Inicio_Evento,fecha_Fin_Evento);
    }

    public GestionarDeEquipos getEquipos() {
        return equiposGes;
    }

    public fixtureArbol getEnfrentamientos() {
        return enfrentamientosGes;
    }
    
    public String crearListaEnfrentamiento(){
        return enfrentamientosGes.crearListaEnfrentamiento();
    }
    
    public void definirNuevaEtapa(int[][] goles){
        enfrentamientosGes.definirEtapas(goles);
    }
    
    public String mostrarEtapa(){
        return enfrentamientosGes.mostrarEtapa();
    }
    
    public String mostrarListaEnfrentamiento(){
        return enfrentamientosGes.getEnfrentamientos().mostrarEnfrentamientos();
    }
}
