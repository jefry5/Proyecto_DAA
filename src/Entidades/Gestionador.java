package Entidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Gestionador implements Serializable{
    
    private Evento eventoDeportivo;

    public Gestionador(){
        this.eventoDeportivo = new Evento(-99,"",null,null); //Inicializa el evento con valores nulos
    }

    public Evento getEventoDeportivo() {
        return eventoDeportivo;
    }

    public void setEventoDeportivo(Evento eventoDeportivo) {
        this.eventoDeportivo = eventoDeportivo;
    }

    public String crearListaEnfrentamiento(int cantidadPartidosXFecha){
        return eventoDeportivo.getEnfrentamientosGes().crearListaEnfrentamiento(cantidadPartidosXFecha);
    }
    
    public void definirNuevaEtapa(){
        eventoDeportivo.getEnfrentamientosGes().nuevaEtapa();
    }
    
    public void definirGoles(int[][] goles, int[][] penales){
        eventoDeportivo.getEnfrentamientosGes().definirGoles(goles, penales);
    }
    
    public String mostrarEtapa(){
        return eventoDeportivo.getEnfrentamientosGes().mostrarEtapa();
    }
    
    public String mostrarListaEnfrentamiento(){
        return eventoDeportivo.getEnfrentamientosGes().getEnfrentamientos().mostrarEnfrentamientos();
    }  
    
    public void finalizarEvento(){
        eventoDeportivo.setEventoFinalizado(true);
    }
 
    public String[] listarArchivos(){
        String rutaProyecto = new File("").getAbsolutePath();
        String rutaDirectorio = rutaProyecto + File.separator + "src" + File.separator + "Archivos";
        
        File directorio = new File(rutaDirectorio);
        File[] archivos = directorio.listFiles((dir, name) -> name.endsWith(".txt"));
        
        String[] lista = new String[archivos.length];
        if(archivos != null){
            for(int i=0; i<archivos.length ; i++){
                lista[i] = quitarExtension(archivos[i].getName(),".txt");
            }
        }
        return lista;
    }
    
    public static String quitarExtension(String nombreArchivo, String extension) {
        if (nombreArchivo != null && nombreArchivo.endsWith(extension)) {
            return nombreArchivo.substring(0, nombreArchivo.lastIndexOf(extension));
        }
        return nombreArchivo;
    }  
    
    public String guardarArchivo() throws IOException{
        if (eventoDeportivo.getCodigo_Evento() != -99) {
            String rutaProyecto = new File("").getAbsolutePath();
            String rutaDirectorio = rutaProyecto + File.separator + "src" + File.separator + "Archivos";

            File directorio = new File(rutaDirectorio);
            if (!directorio.exists()) {
                directorio.mkdirs(); //Crea el folder si no existe
            }

            String nombreArchivo = eventoDeportivo.getCodigo_Evento() + ".txt";
            File archivo = new File(directorio, nombreArchivo);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(this.eventoDeportivo);
            oos.close();

            return "Archivo guardado";
        }else{
            return "Cree o cargue un evento";
        }
    }
    
    public Evento cargarArchivo(String codigo) throws FileNotFoundException, IOException, ClassNotFoundException{
        String rutaProyecto = new File("").getAbsolutePath();
        String rutaDirectorio = rutaProyecto + File.separator + "src" + File.separator + "Archivos";
        File directorio = new File(rutaDirectorio);

        if (directorio.exists() && directorio.isDirectory()) {
            String nombreArchivo = codigo + ".txt";
            File archivoSeleccionado = new File(directorio, nombreArchivo);

            if (archivoSeleccionado.exists() && archivoSeleccionado.isFile()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoSeleccionado));
                Evento eventoDeportivoArchivo = (Evento) ois.readObject();
                ois.close();
                
                if (eventoDeportivoArchivo != null) {
                    return eventoDeportivoArchivo;
                }
            }
        }
        return null;
    }
    
    public String buscarDeportista(String codigo){
        String mensaje = "", s;
        int codigoInt = Integer.parseInt(codigo);
        for(int i = 0; i<eventoDeportivo.getEquiposGes().getContadorEquipos(); i++){
            NodoDeportista nodoActual = eventoDeportivo.getEquiposGes().getEquipos()[i].getListaDepor().getCabecera();
            while(nodoActual != null){
                s = nodoActual.getDepor().getCodigo_Deportista();
                int code = Integer.parseInt(s);
                if(codigoInt == code){
                    mensaje = "Deportista encontrado: " + nodoActual.getDepor().getNombre_Deportista() +" "+ nodoActual.getDepor().getApellidoPaterno_Deportista() + " ->  Equipo: " + eventoDeportivo.getEquiposGes().getEquipos()[i].getNombre_Equipo();
                    return mensaje;
                }else{
                    nodoActual = nodoActual.getSiguiente();
                }
            }
        }
        mensaje = "Deportista no registrado!";
        return mensaje;
    }
    
    public int indiceEquipo(String codigo){
        int codigoInt = Integer.parseInt(codigo);
        for(int i = 0; i<eventoDeportivo.getEquiposGes().getContadorEquipos(); i++){
            NodoDeportista nodoActual = eventoDeportivo.getEquiposGes().getEquipos()[i].getListaDepor().getCabecera();
            while(nodoActual != null){
                String s = nodoActual.getDepor().getCodigo_Deportista();
                int code = Integer.parseInt(s);
                if(codigoInt == code){
                    return i;
                }else{
                    nodoActual = nodoActual.getSiguiente();
                }
            }
        }
        return -1; 
    }
    
    public ListaDeportista listarDeportistas(){
        ListaDeportista lista = new ListaDeportista();
        for(int i = 0; i<eventoDeportivo.getEquiposGes().getContadorEquipos(); i++){
            NodoDeportista nodoActual = eventoDeportivo.getEquiposGes().getEquipos()[i].getListaDepor().getCabecera();
            while(nodoActual != null){
                lista.agregarDeportista(nodoActual.getDepor());
                nodoActual = nodoActual.getSiguiente();
            }
        }
        return lista;
    }
    
    public boolean buscarCodigo(String codigo){
        String s;
        int codigoInt = Integer.parseInt(codigo);
        for(int i = 0; i<eventoDeportivo.getEquiposGes().getContadorEquipos(); i++){
            NodoDeportista nodoActual = eventoDeportivo.getEquiposGes().getEquipos()[i].getListaDepor().getCabecera();
            while(nodoActual != null){
                s = nodoActual.getDepor().getCodigo_Deportista();
                int code = Integer.parseInt(s);
                if(codigoInt == code){        
                    return true;
                }else{
                    nodoActual = nodoActual.getSiguiente();
                }
            }
        }
        return false;
    }
    
    public String eliminarDeportista(String codigo, int indice){
        int codigoInt = Integer.parseInt(codigo);
        String mensaje = "";
        mensaje = eventoDeportivo.getEquiposGes().getEquipos()[indice].getListaDepor().eliminarElemento(codigoInt);
        return mensaje;
    }
}
