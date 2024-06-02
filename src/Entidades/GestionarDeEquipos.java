package Entidades;

import Herramientas.MergeSortEquipo;

public class GestionarDeEquipos {
    private Equipo[] equipos;
    private int contadorEquipos;
    private int max;
    private MergeSortEquipo merge;
    
    public GestionarDeEquipos(){
        this.max = 8; //Cuartos de eliminatorias
        this.equipos = new Equipo[max]; 
        this.contadorEquipos = 0;
        merge = new MergeSortEquipo();
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
}
