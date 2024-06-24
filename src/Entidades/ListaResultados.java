package Entidades;

import java.io.Serializable;

public class ListaResultados implements Serializable{
    private NodoResultado cabecera;
    private NodoResultado ultimo;

    public NodoResultado getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoResultado cabecera) {
        this.cabecera = cabecera;
    }

    public NodoResultado getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoResultado ultimo) {
        this.ultimo = ultimo;
    }
    
    public int contarResultados(){
        int contador = 0;
        NodoResultado aux = cabecera;
        while(aux != null){
            contador++;
            aux = aux.getSiguiente();
        }
        return contador;
    }
    
    public void agregarNodo(String cad){
        NodoResultado nuevoResultado = new NodoResultado(cad);
        if(cabecera == null){
            cabecera = nuevoResultado;
        }else{
            ultimo.setSiguiente(nuevoResultado);
        }
        ultimo = nuevoResultado;    
    }
    
    public void eliminarLista() {
        NodoResultado actual = cabecera;
        while (actual != null) {
            NodoResultado siguiente = actual.getSiguiente();
            actual.setSiguiente(null);
            actual = siguiente;
        }
        cabecera = null;
    }
    
}
