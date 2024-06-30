package Entidades;

import Herramientas.PilaEnfrentamiento;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class ListaEnfrentamiento implements Serializable{
    
    private Enfrentamiento cabecera;
    private Enfrentamiento ultimo;

    public ListaEnfrentamiento() {
        this.cabecera = null;
        this.ultimo = null;
    }

    public Enfrentamiento getCabecera() {
        return cabecera;
    }

    public void setCabecera(Enfrentamiento cabecera) {
        this.cabecera = cabecera;
    }

    public Enfrentamiento getUltimo() {
        return ultimo;
    }

    public void setUltimo(Enfrentamiento ultimo) {
        this.ultimo = ultimo;
    }
    
    public void agregarEnfrentamiento(Enfrentamiento e){
        if(cabecera == null){
            cabecera = e;
        }else{
            ultimo.setSiguiente_enfrentamiento(e);
        }
        ultimo = e;
    }
    
    public String mostrarEnfrentamientos(){
        String total = "";
        Enfrentamiento aux1 = cabecera;
        while(aux1 != null){
            total += aux1.getEquipo1().getNombre_Equipo() + "\t" + "vs" + "\t" + aux1.getEquipo2().getNombre_Equipo()+"\n";
            aux1 = aux1.getSiguiente_enfrentamiento();
        }
        return total;
    }
    
    public int contarEnfrentamientos(){
        int contador = 0;
        Enfrentamiento aux = cabecera;
        while(aux != null){
            contador++;
            aux = aux.getSiguiente_enfrentamiento();
        }
        return contador;
    }
    
    public void eliminarUltimoNodo(){
        if (cabecera == null){
            return;
        }
        if (cabecera == ultimo){
            cabecera = null;
            ultimo = null;
        }else {
            Enfrentamiento actual = cabecera;
            while (actual.getSiguiente_enfrentamiento() != ultimo) {
                actual = actual.getSiguiente_enfrentamiento();
            }
            actual.setSiguiente_enfrentamiento(null);
            ultimo = actual;
        } 
    }
    
    public Enfrentamiento obtenerEnfrentamientoPorIndice(int i){
        Enfrentamiento actual;
        if(i < contarEnfrentamientos()){
            actual = cabecera;
            for(int j=0; j<i; j++){
                actual = actual.getSiguiente_enfrentamiento();
            }
        }else{
            //validar error
            actual = null;
        }
        return actual;
    }
    
    
    public void eliminarLista() {
        Enfrentamiento actual = cabecera;
        while (actual != null) {
            Enfrentamiento siguiente = actual.getSiguiente_enfrentamiento();
            actual.setSiguiente_enfrentamiento(null);
            actual = siguiente;
        }
        cabecera = null;
    }
      
}
