package Herramientas;

import Entidades.Enfrentamiento;

public class PilaEnfrentamiento {
    private Enfrentamiento tope;
    
    public PilaEnfrentamiento() {
        this.tope = null;
    }
    
    public boolean estaVacia() {
        return tope == null;
    }

    public void push(Enfrentamiento enfrentamiento) {
        Enfrentamiento nuevoNodo = enfrentamiento;
        if (estaVacia()) {
            tope = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente_enfrentamiento(enfrentamiento);
            tope = nuevoNodo;
        }
    }

    public Enfrentamiento pop() {
        if (estaVacia()) {
            return null; 
        } else {
            Enfrentamiento enfrentamiento = tope;
            tope = enfrentamiento.getSiguiente_enfrentamiento();
            return enfrentamiento;
        }
    }
}
