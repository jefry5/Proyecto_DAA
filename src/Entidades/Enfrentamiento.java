package Entidades;

import java.io.Serializable;
import java.util.Calendar;

public class Enfrentamiento implements Serializable{
    
    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo ganador;
    private int goles_equipo1;
    private int goles_equipo2;
    private int goles_penales_equipo1;
    private int goles_penales_equipo2;
    private Calendar fecha_Enfrentamiento;
    private Enfrentamiento partido_prev_1;
    private Enfrentamiento partido_prev_2;
    private Enfrentamiento siguiente_enfrentamiento;
    
    public Enfrentamiento(Equipo e1, Equipo e2, Calendar fecha_Enfrentamiento){
        this.goles_equipo1 = 0;
        this.goles_equipo2 = 0;
        this.goles_penales_equipo1 = 0;
        this.goles_penales_equipo2 = 0;
        this.fecha_Enfrentamiento = fecha_Enfrentamiento;
        this.ganador = null;
        this.equipo1 = e1;
        this.equipo2 = e2;
        this.partido_prev_1 = null;
        this.partido_prev_2 = null;
        this.siguiente_enfrentamiento = null;
    }

    public Calendar getFecha_Enfrentamiento() {
        return fecha_Enfrentamiento;
    }

    public void setFecha_Enfrentamiento(Calendar fecha_Enfrentamiento) {
        this.fecha_Enfrentamiento = fecha_Enfrentamiento;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public Equipo getGanador() {
        return ganador;
    }

    public void setGanador(Equipo ganador) {
        this.ganador = ganador;
    }

    public int getGoles_equipo1() {
        return goles_equipo1;
    }

    public void setGoles_equipo1(int goles_equipo1) {
        this.goles_equipo1 = goles_equipo1;
    }

    public int getGoles_equipo2() {
        return goles_equipo2;
    }

    public void setGoles_equipo2(int goles_equipo2) {
        this.goles_equipo2 = goles_equipo2;
    }

    public Enfrentamiento getPartido_prev_1() {
        return partido_prev_1;
    }

    public void setPartido_prev_1(Enfrentamiento partido_prev_1) {
        this.partido_prev_1 = partido_prev_1;
    }

    public Enfrentamiento getPartido_prev_2() {
        return partido_prev_2;
    }

    public void setPartido_prev_2(Enfrentamiento partido_prev_2) {
        this.partido_prev_2 = partido_prev_2;
    }

    public Enfrentamiento getSiguiente_enfrentamiento() {
        return siguiente_enfrentamiento;
    }

    public void setSiguiente_enfrentamiento(Enfrentamiento siguiente_enfrentamiento) {
        this.siguiente_enfrentamiento = siguiente_enfrentamiento;
    }

    public int getGoles_penales_equipo1() {
        return goles_penales_equipo1;
    }

    public void setGoles_penales_equipo1(int goles_penales_equipo1) {
        this.goles_penales_equipo1 = goles_penales_equipo1;
    }

    public int getGoles_penales_equipo2() {
        return goles_penales_equipo2;
    }

    public void setGoles_penales_equipo2(int goles_penales_equipo2) {
        this.goles_penales_equipo2 = goles_penales_equipo2;
    }
    
    public void definirGanador(int g_equipo1, int g_equipo2, int g_p_equipo1, int g_p_equipo2){
        goles_equipo1 = g_equipo1;
        goles_equipo2 = g_equipo2;
        goles_penales_equipo1 = g_p_equipo1;
        goles_penales_equipo2 = g_p_equipo2;
        
        if(goles_equipo1 == goles_equipo2){
            if(goles_penales_equipo1 > goles_penales_equipo2){
                this.ganador = equipo1;
            }else if(goles_penales_equipo1 < goles_penales_equipo2){
                this.ganador = equipo2;
            }
        }else{
            if(goles_equipo1 > goles_equipo2){
                this.ganador = equipo1;
            }else if(goles_equipo1 < goles_equipo2){
                this.ganador = equipo2;
            }
        }  
    }

    public String mostrarResultados(){
        String resultado;
        if(goles_equipo1 == goles_equipo2){
            resultado = equipo1.getNombre_Equipo()+"\t"+goles_equipo1+"("+goles_penales_equipo1+")\n"
                    +equipo2.getNombre_Equipo()+"\t"+goles_equipo2+"("+goles_penales_equipo2+")\n";
            if (ganador != null) {
                resultado += "Ganador: " + ganador.getNombre_Equipo() + "\n\n";
            }
                    
        }else{
            resultado = equipo1.getNombre_Equipo()+"\t"+goles_equipo1+"\n"
                    +equipo2.getNombre_Equipo()+"\t"+goles_equipo2+"\n"
                    +"Ganador: "+ganador.getNombre_Equipo()+"\n\n";
        }
        return resultado;
    }

}
