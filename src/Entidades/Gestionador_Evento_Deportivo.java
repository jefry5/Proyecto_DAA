package Entidades;

public class Gestionador_Evento_Deportivo {
    
    private GestionarDeEquipos equiposGes;
    private fixtureArbol enfrentamientosGes;

    public Gestionador_Evento_Deportivo(){
        this.equiposGes = new GestionarDeEquipos();
        this.enfrentamientosGes = new fixtureArbol(equiposGes);
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
