/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Herramientas.NumeroAleatorioRango;

public class fixtureArbol {
    
    private ListaEnfrentamiento listaEnfrentamientos;
    private GestionarDeEquipos equipos;
    private final NumeroAleatorioRango aleatorio;
    private ListaResultados listaResultados;

    public fixtureArbol(GestionarDeEquipos e){
        //crearListaEnfrentamiento();
        this.equipos = e;
        this.listaEnfrentamientos = new ListaEnfrentamiento();
        this.listaResultados = new ListaResultados();
        aleatorio = new NumeroAleatorioRango(0,equipos.getContadorEquipos());
    }

    public ListaEnfrentamiento getEnfrentamientos() {
        return listaEnfrentamientos;
    }

    public ListaResultados getListaResultados() {
        return listaResultados;
    }
    
    public String crearListaEnfrentamiento(){
        listaEnfrentamientos.eliminarLista();
        int contadorEquiposRegistrados = 0; //Se aumentara con cada equipo ingresado 
        String mensaje = "No hay equipos registrados";
        
        while(contadorEquiposRegistrados < equipos.getContadorEquipos()){
            Equipo equipoVisitante, equipoLocal;
            
            equipoLocal = equipos.getEquiposPorPosicion(contadorEquiposRegistrados);

            if(contadorEquiposRegistrados < equipos.getContadorEquipos()-1){
                contadorEquiposRegistrados++;
                equipoVisitante = equipos.getEquiposPorPosicion(contadorEquiposRegistrados);
            }else{
                equipoVisitante = equipos.getEquiposPorPosicion(equipos.getContadorEquipos()-1); //El ultimo nodo agarra dos veces al mismo equipo si la cantida de equipos es impar
            }
            contadorEquiposRegistrados++;
            
            if(equipoLocal.getListaDepor().contarNodos() >= 11 || equipoVisitante.getListaDepor().contarNodos() >= 11){
                Enfrentamiento enfrentamiento = new Enfrentamiento(equipoLocal, equipoVisitante);
                listaEnfrentamientos.agregarEnfrentamiento(enfrentamiento);
                mensaje = "Se creo enfrentamiento correctamente";
            }else{
                contadorEquiposRegistrados = contadorEquiposRegistrados - 2;
                mensaje = "Numero de integrantes incompletos "+equipoLocal.getNombre_Equipo()+"("+equipoLocal.getListaDepor().contarNodos()+")"+" || "
                            +equipoVisitante.getNombre_Equipo()+"("+equipoVisitante.getListaDepor().contarNodos()+")";
                break;
            } 
        }
        return mensaje;
    }
    
    public void definirEtapas(int[][] goles){ 
        int i = 0;
        ListaEnfrentamiento nuevaEtapa = new ListaEnfrentamiento();
        Enfrentamiento enfrentamientoActual = listaEnfrentamientos.getCabecera();
        
        String concatenar = "";
        
        while(enfrentamientoActual != null){
            enfrentamientoActual.definirGanador(goles[i][0], goles[i][1]);
            concatenar = concatenar + enfrentamientoActual.mostrarResultados();
            enfrentamientoActual = enfrentamientoActual.getSiguiente_enfrentamiento();
            i++;
        }
        listaResultados.agregarNodo(concatenar);
        
        //Se crea la nueva etapa
        enfrentamientoActual = listaEnfrentamientos.getCabecera();
        if(listaEnfrentamientos.contarEnfrentamientos() == 1){
            //definir ganador
            System.out.println("Ganador: "+enfrentamientoActual.getGanador().getNombre_Equipo());
        }else if(listaEnfrentamientos.contarEnfrentamientos() % 2 == 0){
            while(enfrentamientoActual != null){
                nuevaEtapa.agregarEnfrentamiento(new Enfrentamiento(enfrentamientoActual.getGanador(),enfrentamientoActual.getSiguiente_enfrentamiento().getGanador()));
                enfrentamientoActual = enfrentamientoActual.getSiguiente_enfrentamiento().getSiguiente_enfrentamiento();
            }
        }else{
            Enfrentamiento auxUltimo = listaEnfrentamientos.getUltimo(); //MOSTRAR CUANDO SON NODOS IMPARES (PASE DIRECTO)
            listaEnfrentamientos.eliminarUltimoNodo();
            
            while(enfrentamientoActual != null){
                nuevaEtapa.agregarEnfrentamiento(new Enfrentamiento(enfrentamientoActual.getGanador(),enfrentamientoActual.getSiguiente_enfrentamiento().getGanador()));
                enfrentamientoActual = enfrentamientoActual.getSiguiente_enfrentamiento().getSiguiente_enfrentamiento();
            }
            listaEnfrentamientos.agregarEnfrentamiento(auxUltimo);
        }
        
        listaEnfrentamientos.eliminarLista();
        listaEnfrentamientos.setCabecera(nuevaEtapa.getCabecera());
    }
    
    public String mostrarEtapa(){
        NodoResultado actual = listaResultados.getCabecera();
        String retultados_totales = "";
        for(int i=0; i<listaResultados.contarResultados(); i++){
            retultados_totales = retultados_totales + "Etapa " + (i+1) + ": \n" +
                                 actual.getResultado() + "\n";  
            actual = actual.getSiguiente();
        }
        return retultados_totales;
    }
}
