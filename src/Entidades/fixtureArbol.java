package Entidades;

import Herramientas.NumeroAleatorioRango;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;

public class fixtureArbol implements Serializable{
    
    private ListaEnfrentamiento listaEnfrentamientos;
    private GestionarDeEquipos equipos;
    private NumeroAleatorioRango aleatorio;
    private ListaResultados listaResultados;
    private Calendar fecha_inicio, fecha_fin;
    private Calendar[] fechas;
    private int contadorFechasEnfrentamientos;

    public fixtureArbol(GestionarDeEquipos e, Calendar inicio, Calendar fin){
        this.equipos = e;
        this.fecha_inicio = inicio;
        this.fecha_fin = fin;
        this.listaEnfrentamientos = new ListaEnfrentamiento();
        this.listaResultados = new ListaResultados();
        this.contadorFechasEnfrentamientos = 0;
    }

    public ListaEnfrentamiento getEnfrentamientos() {
        return listaEnfrentamientos;
    }

    public ListaResultados getListaResultados() {
        return listaResultados;
    }
    
    public void verificarFechaEnfrentamiento(int indice){
        if(indice == 0){
            fechas[indice] = (Calendar)fecha_inicio.clone();
        }else{
            fechas[indice] = (Calendar) fechas[indice-1].clone();
            fechas[indice].add(Calendar.DAY_OF_MONTH, 1);
        }
    }
    
    
    public String crearListaEnfrentamiento(){
        listaEnfrentamientos.eliminarLista();
        int contadorEquiposRegistrados = 0; //Se aumentara con cada equipo ingresado 
        contadorFechasEnfrentamientos = 0; //Inicializamos las fechas
        String mensaje = "No hay equipos registrados";
        
        //Enfrentamiento aleatorios
        aleatorio = new NumeroAleatorioRango(0,equipos.getContadorEquipos()-1);
        int[] aleatorios = new int[equipos.getContadorEquipos()];
        aleatorios = aleatorio.generarAleatoriosSinRepetir(equipos.getContadorEquipos());
        System.out.println("ALEATORIOS: "+Arrays.toString(aleatorios));
        
        if(equipos.getContadorEquipos()>1){
            fechas = new Calendar[equipos.getContadorEquipos()-1]; //Cantidad de fechas de enfrentamiento
            for(int i=0; i<fechas.length; i++){
                fechas[i] = Calendar.getInstance();
            }
        }
        
        while(contadorEquiposRegistrados < equipos.getContadorEquipos()){
            Equipo equipoVisitante, equipoLocal; 
            equipoLocal = equipos.getEquiposPorPosicion(aleatorios[contadorEquiposRegistrados]);
            
            if(contadorEquiposRegistrados < equipos.getContadorEquipos()-1){
                contadorEquiposRegistrados++;
                equipoVisitante = equipos.getEquiposPorPosicion(aleatorios[contadorEquiposRegistrados]);
            }else{
                equipoVisitante = equipos.getEquiposPorPosicion(aleatorios[aleatorios.length-1]); //El ultimo nodo agarra dos veces al mismo equipo si la cantida de equipos es impar
            }
            contadorEquiposRegistrados++;
            
            if(equipoLocal.getListaDepor().contarNodos() <= 11 || equipoVisitante.getListaDepor().contarNodos() <= 11){
                verificarFechaEnfrentamiento(contadorFechasEnfrentamientos);
                Enfrentamiento enfrentamiento = new Enfrentamiento(equipoLocal, equipoVisitante, fechas[contadorFechasEnfrentamientos++]);
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
                verificarFechaEnfrentamiento(contadorFechasEnfrentamientos);
                nuevaEtapa.agregarEnfrentamiento(new Enfrentamiento(enfrentamientoActual.getGanador(),enfrentamientoActual.getSiguiente_enfrentamiento().getGanador(),fechas[contadorFechasEnfrentamientos++]));
                enfrentamientoActual = enfrentamientoActual.getSiguiente_enfrentamiento().getSiguiente_enfrentamiento();
            }
        }else{
            Enfrentamiento auxUltimo = listaEnfrentamientos.getUltimo(); //MOSTRAR CUANDO SON NODOS IMPARES (PASE DIRECTO)
            listaEnfrentamientos.eliminarUltimoNodo();
            
            while(enfrentamientoActual != null){
                verificarFechaEnfrentamiento(contadorFechasEnfrentamientos);
                nuevaEtapa.agregarEnfrentamiento(new Enfrentamiento(enfrentamientoActual.getGanador(),enfrentamientoActual.getSiguiente_enfrentamiento().getGanador(),fechas[contadorFechasEnfrentamientos++]));
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
