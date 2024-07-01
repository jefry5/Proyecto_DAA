package Entidades;

import Herramientas.MergeSortEquipo;
import java.io.Serializable;

public class ArregloDeEquipos implements Serializable{
    private Equipo[] equipos;
    private int contadorEquipos;
    private int max;
    private MergeSortEquipo merge;
    
    public ArregloDeEquipos(){
        this.max = 8; //Cuartos de eliminatorias
        this.equipos = new Equipo[max]; 
        this.contadorEquipos = 0;
        this.merge = new MergeSortEquipo();
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

    public String agregarEquipo(Equipo eq){
        String mensaje;
        if(!existeCodigo(eq.getCodigo_Equipo())){
            if(!existeNombre(eq.getNombre_Equipo())){
                if(contadorEquipos < max){
                    equipos[contadorEquipos] = eq;
                    contadorEquipos++;
                    mensaje = "Equipos registrado correctamente";
                }else{
                    mensaje = "Equipos completos";
                }
            }else{
                mensaje = "Nombres ya existentes";
            }
        }else{
            mensaje = "Codigo ya existente";
        }
        return mensaje;
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
    
    public String eliminarEquipo(String codigo) {
        int index = -1;
        for (int i = 0; i < contadorEquipos; i++) {
            if (equipos[i].getCodigo_Equipo().equals(codigo)) {
                index = i;
                break;
            }
        }
        
        if (index != -1) {
            for (int i = index; i < contadorEquipos - 1; i++) {
                equipos[i] = equipos[i + 1];
            }
            equipos[contadorEquipos - 1] = null; // Eliminar la referencia al último elemento
            contadorEquipos--;
            return "Equipo eliminado con exito.";
        } else {
            return "Equipo no encontrado.";
        }
    }
}
