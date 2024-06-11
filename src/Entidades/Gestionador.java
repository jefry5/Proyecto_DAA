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
    
    public String crearListaEnfrentamiento(int cantidadPartidosXFecha){
        return eventoDeportivo.getEnfrentamientosGes().crearListaEnfrentamiento(cantidadPartidosXFecha);
    }
    
    public void definirNuevaEtapa(int[][] goles){
        eventoDeportivo.getEnfrentamientosGes().definirEtapas(goles);
    }
    
    public String mostrarEtapa(){
        return eventoDeportivo.getEnfrentamientosGes().mostrarEtapa();
    }
    
    public String mostrarListaEnfrentamiento(){
        return eventoDeportivo.getEnfrentamientosGes().getEnfrentamientos().mostrarEnfrentamientos();
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
            oos.writeObject(this);
            oos.close();

            return "Archivo guardado";
        }else{
            // Validar error
            return "Cree o cargue un evento";
        }
    }
    
    public Gestionador cargarArchivo(String codigo) throws FileNotFoundException, IOException, ClassNotFoundException{
        String rutaProyecto = new File("").getAbsolutePath();
        String rutaDirectorio = rutaProyecto + File.separator + "src" + File.separator + "Archivos";
        File directorio = new File(rutaDirectorio);

        if (directorio.exists() && directorio.isDirectory()) {
            String nombreArchivo = codigo + ".txt";
            File archivoSeleccionado = new File(directorio, nombreArchivo);

            if (archivoSeleccionado.exists() && archivoSeleccionado.isFile()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoSeleccionado));
                Gestionador eventoDeportivoArchivo = (Gestionador) ois.readObject();
                ois.close();
                
                if (eventoDeportivoArchivo != null) {
                    return eventoDeportivoArchivo;
                }
            }
        }
        return null;
    }
}
