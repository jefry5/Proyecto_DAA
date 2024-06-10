package Entidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;

public class Gestionador_Evento_Deportivo implements Serializable{
    
    private Evento_Deportivo eventoDeportivo;
    private GestionarDeEquipos equiposGes;
    private fixtureArbol enfrentamientosGes;

    public Gestionador_Evento_Deportivo(){
        this.equiposGes = new GestionarDeEquipos(); 
        this.eventoDeportivo = new Evento_Deportivo(-99,"",null,null);
        this.enfrentamientosGes = new fixtureArbol(equiposGes,null,null);
    }

    public Evento_Deportivo getEventoDeportivo() {
        return eventoDeportivo;
    }

    public GestionarDeEquipos getGesEquipos() {
        return equiposGes;
    }

    public fixtureArbol getEnfrentamientos() {
        return enfrentamientosGes;
    }
    
    public void iniciarEventoDeportivo(int codigo, String nombre, Calendar fInicio, Calendar fFin){
        this.eventoDeportivo.setCodigo_Evento(codigo);
        this.eventoDeportivo.setNombre_Evento(nombre);
        this.eventoDeportivo.setFecha_Inicio_Evento(fInicio);
        this.eventoDeportivo.setFecha_Fin_Evento(fFin);
        
        this.enfrentamientosGes.setFecha_inicio(fInicio);
        this.enfrentamientosGes.setFecha_fin(fFin);
    }
    
    public String crearListaEnfrentamiento(int cantidadPartidosXFecha){
        return enfrentamientosGes.crearListaEnfrentamiento(cantidadPartidosXFecha);
    }
    
    public void definirNuevaEtapa(int[][] goles){
        enfrentamientosGes.definirEtapas(goles);
    }
    
    public String mostrarEtapa(){
        return enfrentamientosGes.mostrarEtapa();
    }
    
    public String mostrarListaEnfrentamiento(){
        return enfrentamientosGes.getEnfrentamientos().mostrarEnfrentamientos();
    }
    
    public String guardarArchivo() throws IOException{
        if (this != null) {
            String rutaProyecto = new File("").getAbsolutePath();
            String rutaDirectorio = rutaProyecto + File.separator + "src" + File.separator + "Archivos";

            File directorio = new File(rutaDirectorio);
            if (!directorio.exists()) {
                directorio.mkdirs(); //Crea el folder si no existe
            }

            String nombreArchivo = eventoDeportivo.getCodigo_Evento() + ".txt";
            File archivo = new File(directorio, nombreArchivo);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(this);
            oos.close();

            return "Archivo guardado";
        }else{
            // Validar error
            return "Objeto Null";
        }
    }
    
    public Gestionador_Evento_Deportivo cargarArchivo(String codigo) throws FileNotFoundException, IOException, ClassNotFoundException{
        String rutaProyecto = new File("").getAbsolutePath();
        String rutaDirectorio = rutaProyecto + File.separator + "src" + File.separator + "Archivos";
        File directorio = new File(rutaDirectorio);

        if (directorio.exists() && directorio.isDirectory()) {
            String nombreArchivo = codigo + ".txt";
            File archivoSeleccionado = new File(directorio, nombreArchivo);

            if (archivoSeleccionado.exists() && archivoSeleccionado.isFile()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoSeleccionado));
                Gestionador_Evento_Deportivo eventoDeportivoArchivo = (Gestionador_Evento_Deportivo) ois.readObject();
                ois.close();
                
                if (eventoDeportivoArchivo != null) {
                    return eventoDeportivoArchivo;
                }
            }
        }
        return null;
    }
}
