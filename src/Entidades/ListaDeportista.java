package Entidades;

import Herramientas.MergeSortListaDeportista;
import java.io.Serializable;

public class ListaDeportista implements Serializable{
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
            cadena+= "\n" + aux.getDepor().getCodigo_Deportista() +"\t"+ aux.getDepor().getNombre_Deportista();
            aux = aux.getSiguiente();
        }
        return cadena;
    }
    
    public NodoDeportista obtenerDeportistaPorIndice(int i){
        NodoDeportista deportista;
        if(i < contarNodos()){
            deportista = cabecera;
            for(int j=0; j<i; j++){
                deportista = deportista.getSiguiente();
            }
        }else{
            //validar error
            deportista = null;
        }
        return deportista;
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