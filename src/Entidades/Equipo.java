package Entidades;


public class Equipo {
    private String codigo_Equipo, nombre_Equipo, nombre_DT, provenencia_Equipo;
    private ListaDeportista listaDepor;
    private int puntuacion;

    public Equipo(String codigo_Equipo, String nombre_Equipo, String nombre_DT, String provenencia_Equipo) {
        this.codigo_Equipo = codigo_Equipo;
        this.nombre_Equipo = nombre_Equipo;
        this.nombre_DT = nombre_DT;
        this.provenencia_Equipo = provenencia_Equipo;
        this.puntuacion = 0;
        listaDepor = new ListaDeportista();
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    public ListaDeportista getListaDepor() {
        return listaDepor;
    }
    
    public String getCodigo_Equipo() {
        return codigo_Equipo;
    }

    public void setCodigo_Equipo(String codigo_Equipo) {
        this.codigo_Equipo = codigo_Equipo;
    }

    public String getNombre_Equipo() {
        return nombre_Equipo;
    }

    public void setNombre_Equipo(String nombre_Equipo) {
        this.nombre_Equipo = nombre_Equipo;
    }

    public String getNombre_DT() {
        return nombre_DT;
    }

    public void setNombre_DT(String nombre_DT) {
        this.nombre_DT = nombre_DT;
    }

    public String getProvenencia_Equipo() {
        return provenencia_Equipo;
    }

    public void setProvenencia_Equipo(String provenencia_Equipo) {
        this.provenencia_Equipo = provenencia_Equipo;
    }
    
}
