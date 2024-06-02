package Entidades;

import Herramientas.MergeSortListaDeportista;

public class ListaDeportista {
    private NodoDeportista cabecera;
    private NodoDeportista ultimo;
    private MergeSortListaDeportista ordenar;
 
    public NodoDeportista getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoDeportista cabecera) {
        this.cabecera = cabecera;
    }

    public NodoDeportista getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoDeportista ultimo) {
        this.ultimo = ultimo;
    }

    public ListaDeportista(){
        this.cabecera = null;
        this.ultimo = null;
        this.ordenar = new MergeSortListaDeportista();
    }
    
    public void agregarDeportista(Deportista dep){
        NodoDeportista nuevo_Deportista = new NodoDeportista(dep);
        if(cabecera == null){
            cabecera = nuevo_Deportista;
        }else{
            ultimo.setSiguiente(nuevo_Deportista);
        }
        ultimo = nuevo_Deportista;
    }
    
    public String listarDeportista(){
        NodoDeportista aux;
        String cadena = "";
        aux = cabecera;
        while(aux != null){
            cadena+= "\n" + aux.getDepor().getDni_Deportista() +"\t"+ aux.getDepor().getNombre_Deportista();
            aux = aux.getSiguiente();
        }
        return cadena;
    }
    
    public void ordenarListaDeportista(){
        ordenar.mergeSort(this, this.contarNodos());
    }
    
    //////////////////////////////////////////////////////////////
    public int contarNodos() {
        int contador = 0;
        NodoDeportista aux = cabecera;
        while(aux != null){
            contador++;
            aux = aux.getSiguiente();
        }
        return contador;
    }
}