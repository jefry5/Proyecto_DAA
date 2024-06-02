package Entidades;

public class NodoDeportista {
    private Deportista depor;
    private NodoDeportista siguiente;

    public NodoDeportista(Deportista dep) {
        this.depor = dep;
        this.siguiente = null;
    }

    public Deportista getDepor() {
        return depor;
    }

    public NodoDeportista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDeportista siguiente) {
        this.siguiente = siguiente;
    }
}
