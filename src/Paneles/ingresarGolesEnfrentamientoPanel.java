package Paneles;

import Entidades.Enfrentamiento;
import Entidades.Gestionador;
import java.awt.*;
import javax.swing.*;

public class ingresarGolesEnfrentamientoPanel extends javax.swing.JPanel{
    private Gestionador gesEvento;
    private ConcatenarIngresarGolesPanel panelaux;
    private JTextField[] jtxtGol;
    private boolean validacionCampos;
    private int contadorEmpate,numEnfrentamientos;
    private int[][] goles, penales;
    
    
    public ingresarGolesEnfrentamientoPanel(ConcatenarIngresarGolesPanel panelaux,Gestionador gesEvento) {
        initComponents();
        this.gesEvento = gesEvento;
        this.panelaux = panelaux;
        this.validacionCampos = false;
        this.contadorEmpate = 0;
        actualizarPanel(gesEvento.getEventoDeportivo().getEnfrentamientosGes().getEnfrentamientos().contarEnfrentamientos());
        anadirElemento(gesEvento.getEventoDeportivo().getEnfrentamientosGes().getEnfrentamientos().contarEnfrentamientos());
    }

    public boolean isValidacionCampos() {
        return validacionCampos;
    }   
    
    public int[][] getGoles() {
        return goles;
    }

    public int[][] getPenales() {
        return penales;
    }

    public int getNumEnfrentamientos() {
        return numEnfrentamientos;
    }
    
    public void actualizarPanel(int partidos){
        this.removeAll();
        this.setLayout(new GridLayout(partidos,4));
        anadirElemento(partidos);
    }
    
    public void actualizarPanelEmpate(int[][] goles){
        this.removeAll();
        this.setLayout(new GridLayout(contadorEmpate,4));
        anadirElemento(contadorEmpate,empate(goles));
    }

    public int getContadorEmpate() {
        return contadorEmpate;
    }
    
    public void anadirElemento(int partidos){
        Enfrentamiento actual = gesEvento.getEventoDeportivo().getEnfrentamientosGes().getEnfrentamientos().getCabecera();
        jtxtGol = new JTextField[partidos * 2];

        for (int i = 0; i < jtxtGol.length; i++) {
            jtxtGol[i] = new JTextField();
        }

        int cont = 0;
        for (int i = 0; i < partidos; i++) {
            this.add(new JLabel(actual.getEquipo1().getNombre_Equipo()));
            this.add(jtxtGol[cont++]);
            this.add(jtxtGol[cont++]);
            this.add(new JLabel(actual.getEquipo2().getNombre_Equipo()));
            actual = actual.getSiguiente_enfrentamiento();
        }

        this.revalidate();
        this.repaint();
    }
    
    public void anadirElemento(int partidos, boolean[] empate){
        Enfrentamiento actual;
        jtxtGol = new JTextField[partidos * 2];

        for (int i = 0; i < jtxtGol.length; i++) {
            jtxtGol[i] = new JTextField();
        }

        int cont = 0;
        for (int i = 0; i < numEnfrentamientos; i++) {
            if(empate[i]){
                actual = gesEvento.getEventoDeportivo().getEnfrentamientosGes().getEnfrentamientos().obtenerEnfrentamientoPorIndice(i);
                this.add(new JLabel(actual.getEquipo1().getNombre_Equipo()+" (P)"));
                this.add(jtxtGol[cont++]);
                this.add(jtxtGol[cont++]);
                this.add(new JLabel(actual.getEquipo2().getNombre_Equipo()+" (P)"));
            }
        }
        
        this.revalidate();
        this.repaint();
    }
    
    public boolean sonTodosNumeros(JTextField[] campos) {
        for (JTextField campo : campos) {
            String texto = campo.getText().trim();
            if (texto.isEmpty()) {
                return false;
            }
            try {
                Integer.valueOf(texto);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
    
    public boolean[] empate(int[][] goles){
        boolean[] esEmpate = new boolean[numEnfrentamientos];
        contadorEmpate = 0;
        for(int i=0; i < numEnfrentamientos; i++){
            if(goles[i][0] == goles[i][1] && (goles[i][0] != -1 && goles[i][1] != -1)){
                esEmpate[i] = true; // significa hay empate
                contadorEmpate++;
            }else{
                esEmpate[i] = false;
            }
        }
        return esEmpate;
    }
    
    public boolean isEmpate(int[][] goles){
        boolean[] esEmpate = empate(goles);
        for(int i=0; i < numEnfrentamientos; i++){
            if(esEmpate[i]){
                return true;
            }
        }
        return false;
    }
    
    public void guardarPenales(int goles[][]){
        this.goles = goles;
        int contEnfrentamiento = 0, contEmp=0;
        boolean sonNumeros = sonTodosNumeros(jtxtGol), repiteEmpate = false;
        boolean[] empate;
        
        while(contEmp < numEnfrentamientos && !repiteEmpate){
            if(penales[contEmp][0] !=-1 && penales[contEmp][1] !=-1){
                repiteEmpate = true;
            }
            contEmp++;
        }   
        
        if(!repiteEmpate){
            empate = empate(goles); //Esto sucede si es la primeraa vez que va a penales
        }else{
            empate = empate(penales);//Si se repite los penales despues de haber sucedido la primera vez
        }
        
        if(sonNumeros){
            for(int i=0; i<numEnfrentamientos; i++){ // No se guarda donde corresponde
                if(empate[i]){
                    penales[i][0] = Integer.parseInt(jtxtGol[contEnfrentamiento++].getText());
                    penales[i][1] = Integer.parseInt(jtxtGol[contEnfrentamiento++].getText());
                }
            }
            gesEvento.definirGoles(this.goles,penales);
            validacionCampos = true;
        }else{
            validacionCampos = false;
        }
        
    }
    
    public void guardarGoles(){
        numEnfrentamientos = gesEvento.getEventoDeportivo().getEnfrentamientosGes().getEnfrentamientos().contarEnfrentamientos();
        goles = new int[numEnfrentamientos][2];
        penales = new int[numEnfrentamientos][2];
        int contEnfrentamiento = 0;
        boolean sonNumeros = sonTodosNumeros(jtxtGol);
        for(int i=0; i<numEnfrentamientos; i++){
            penales[i][0] = -1;
            penales[i][1] = -1;
        }
        
        if(sonNumeros){
            for(int i=0; i<numEnfrentamientos; i++){
                goles[i][0] = Integer.parseInt(jtxtGol[contEnfrentamiento++].getText());
                goles[i][1] = Integer.parseInt(jtxtGol[contEnfrentamiento++].getText());
            }
            gesEvento.definirGoles(goles,penales);
            validacionCampos = true;
        }else{
            validacionCampos = false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
