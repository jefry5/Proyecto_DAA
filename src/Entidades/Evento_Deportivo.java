package Entidades;

public class Evento_Deportivo {
    
    private int codigo_Evento;
    private String nombre_Evento;
    private GestionarDeEquipos equiposGes;
    private fixtureArbol enfrentamientosGes;

    public Evento_Deportivo(int codigo, String nombre){
        this.codigo_Evento = codigo;
        this.nombre_Evento = nombre;
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
