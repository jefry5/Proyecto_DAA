package Entidades;

import java.io.Serializable;


public class NodoResultado implements Serializable{
    private String resultado;
    private NodoResultado siguiente;

    public NodoResultado(String cad){
        this.resultado = cad;
    }
    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public NodoResultado getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoResultado siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
