package Entidades;

import Herramientas.MergeSortCodigo;
import Herramientas.MergeSortEquipo;
import java.io.Serializable;

public class ArregloDeEquipos implements Serializable{
    private Equipo[] equipos;
    private int contadorEquipos;
    private int max;
    private int[] codigosDeportista;
    private int contadorCodigosDeportista;
    private MergeSortEquipo merge;
    private MergeSortCodigo ordenarCod;
    
    public ArregloDeEquipos(){
        this.max = 8; //Cuartos de eliminatorias
        this.equipos = new Equipo[max]; 
        this.contadorEquipos = 0;
        this.codigosDeportista = new int[200]; // Esta cantidad es para la cantidad de codigos de todos los deportistas (cada equipo)
        this.contadorCodigosDeportista = 0;
        this.merge = new MergeSortEquipo();
        this.ordenarCod = new MergeSortCodigo();
    }

    public int getContadorEquipos() {
        return contadorEquipos;
    }

    public int getMax() {
        return max;
    }
    
    public Equipo[] getEquipos() {
        return equipos;
    }
    
    public Equipo getEquiposPorPosicion(int i) {
        return equipos[i];
    }

    public void agregarEquipo(Equipo eq){
        if(contadorEquipos < max){
            equipos[contadorEquipos] = eq;
            contadorEquipos++;
        }else{
            //Comentario de validación
        }    
    }
    
    public void agregarCodigoDeportista(int codigo){
        codigosDeportista[contadorCodigosDeportista] = codigo;
        contadorCodigosDeportista++;
    }
    
    public boolean existeCodigoDeportista(int codigo){
        if(contadorCodigosDeportista > 0){
            ordenarCod.mergeSort(codigosDeportista, contadorCodigosDeportista);
            
            int izq = 0, der = contadorCodigosDeportista - 1, medio;
            while(der >= izq){
                medio = (izq + der)/2;
                if(codigo == codigosDeportista[medio]){
                    return true;
                }else if (codigo < codigosDeportista[medio]){
                    der = medio - 1;
                }else{
                    izq = medio + 1;
                }       
            }
        }
        return false;
    }
    
    public String mostrarEquipo(){
        String cadena = "";
        for(int i=0; i<contadorEquipos; i++){
            cadena+= "\n"+equipos[i].getCodigo_Equipo()+"\t"+equipos[i].getNombre_Equipo();
        }
        return cadena;
        //Se mostrará en una tabla
    }
    
    public void ordenarLista(){
        merge.mergeSort(equipos, contadorEquipos);
    }
    
    public int busquedaBinariaPorCodigo(int codigo){
        ordenarLista();
        int izq = 0, der = contadorEquipos, medio, pos = -1; //Si no encuentra retorna -1
        while(der >= izq){
            medio = (izq + der)/2;
            if(codigo == Integer.parseInt(equipos[medio].getCodigo_Equipo())){
                pos = medio;
                return pos;
            }else if(codigo < Integer.parseInt(equipos[medio].getCodigo_Equipo())){
                der = medio - izq;
            }else{
                izq = medio + izq;
            }
        }
        return pos;
    }
    
    public boolean existeCodigo(String codigo){
        boolean encontro = false;
        if(contadorEquipos>0){
            int i = 0;
            while(i < contadorEquipos && !encontro){
                if(codigo.equals(equipos[i].getCodigo_Equipo())){
                    encontro = true;
                }
                i++;
            }
        }
        return encontro;
    }
    
    public boolean existeNombre(String nombre){
        boolean encontro = false;
        if(contadorEquipos>0){
            int i = 0;
            while(i < contadorEquipos && !encontro){
                if(nombre.equals(equipos[i].getNombre_Equipo())){
                    encontro = true;
                }
                i++;
            }
        }
        return encontro;
    }
    
}
