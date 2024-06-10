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
    private int contadorFechasEnfrentamientos, contadorPartidosPorDia, partidosPorFecha;

    public fixtureArbol(GestionarDeEquipos e, Calendar inicio, Calendar fin){
        this.equipos = e;
        this.fecha_inicio = inicio;
        this.fecha_fin = fin;
        this.listaEnfrentamientos = new ListaEnfrentamiento();
        this.listaResultados = new ListaResultados();
        this.contadorFechasEnfrentamientos = 0;
        this.contadorPartidosPorDia = 0 ;
        this.partidosPorFecha = 0;
    }

    public void setFecha_inicio(Calendar fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_fin(Calendar fecha_fin) {
        this.fecha_fin = fecha_fin;
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
            contadorPartidosPorDia++;
        }else{
            fechas[indice] = (Calendar) fechas[indice-1].clone();
            if(contadorPartidosPorDia < partidosPorFecha){
                contadorPartidosPorDia++;
            }else{
                fechas[indice].add(Calendar.DAY_OF_MONTH, 1);
                contadorPartidosPorDia = 1;
            }
        }
    }
    
    public int cantidadDeDiasEvento(){
        Calendar inicioAux = (Calendar) fecha_inicio.clone();
        Calendar finAux = (Calendar) fecha_fin.clone();
        int cantidadDias = 1;
        
        while (inicioAux.before(finAux)) {
            inicioAux.add(Calendar.DAY_OF_MONTH, 1);
            cantidadDias++;
        }
        return cantidadDias;
    }
    
    public String crearListaEnfrentamiento(int cantidadPartidosXFecha){
        listaEnfrentamientos.eliminarLista();
        int contadorEquiposRegistrados = 0; //Se aumentara con cada equipo ingresado y contara los partidos por día
        int numeroEnfrentamientos = equipos.getContadorEquipos()-1;
        contadorFechasEnfrentamientos = 0; //Inicializamos las fechas
        contadorPartidosPorDia = 0; partidosPorFecha = cantidadPartidosXFecha; //Inicializamos el contador de partidos por fecha
        String mensaje = "No hay equipos registrados";
        
        //Enfrentamiento aleatorios
        aleatorio = new NumeroAleatorioRango(0,numeroEnfrentamientos);
        int[] aleatorios = new int[equipos.getContadorEquipos()];
        aleatorios = aleatorio.generarAleatoriosSinRepetir(equipos.getContadorEquipos());
        System.out.println("ALEATORIOS: "+Arrays.toString(aleatorios));
        
        //Inicializa los objetos de fecha
        if(equipos.getContadorEquipos()>1){
            fechas = new Calendar[equipos.getContadorEquipos()-1]; //Cantidad de fechas de enfrentamiento
            for(int i=0; i<fechas.length; i++){
                fechas[i] = Calendar.getInstance();
            }
        }
        
        //Validar que la cantidad de dias del evento alcanze para la cantidad de partidos  por día
        int diasEvento = cantidadDeDiasEvento(), duracionEventoSegunPartidosXFecha = 1;
        if(cantidadPartidosXFecha == 1 || cantidadPartidosXFecha == numeroEnfrentamientos){
            duracionEventoSegunPartidosXFecha = numeroEnfrentamientos/cantidadPartidosXFecha;
        }else{
            duracionEventoSegunPartidosXFecha = numeroEnfrentamientos/cantidadPartidosXFecha + 1;
        }
        
        if(duracionEventoSegunPartidosXFecha <= diasEvento){
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

                if(equipoLocal.getListaDepor().contarNodos() <= 11 || equipoVisitante.getListaDepor().contarNodos() <= 11){ //Cantidad de jugadores permitidos
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
        }else{
            mensaje = "No hay suficientes días para la cantidad de "+cantidadPartidosXFecha+" partidos por fecha";
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
