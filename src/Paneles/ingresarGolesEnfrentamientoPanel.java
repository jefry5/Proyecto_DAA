package Paneles;

import Entidades.Enfrentamiento;
import Entidades.Gestionador;
import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

public class ingresarGolesEnfrentamientoPanel extends javax.swing.JPanel{
    private Gestionador gesEvento;
    private ConcatenarIngresarGolesPanel panelaux;
    private JTextField[] jtxtGol;
    private boolean validacionCampos;
    private int contadorEmpate,numEnfrentamientos;
    private int[][] goles, penales;
    private int[] indiceEmpate;
    
    
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
    
    public void actualizarPanelEmpate(int[][] goles,int partidos){
        this.removeAll();
        this.setLayout(new GridLayout(partidos,4));
        anadirElemento(partidos,indiceEmpate);
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
    
    public void anadirElemento(int partidos, int[] empate){
        Enfrentamiento actual;
        jtxtGol = new JTextField[partidos * 2];

        for (int i = 0; i < jtxtGol.length; i++) {
            jtxtGol[i] = new JTextField();
        }
        
        System.out.println(Arrays.toString(empate));

        int cont = 0;
        for (int i = 0; i < contadorEmpate; i++) {
            if(empate[i]!=-1){
                actual = gesEvento.getEventoDeportivo().getEnfrentamientosGes().getEnfrentamientos().obtenerEnfrentamientoPorIndice(empate[i]);
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
    
    public void empate(int[][] goles, int nEnfrentamientos){
        indiceEmpate = new int[numEnfrentamientos];
        contadorEmpate = 0;
        for(int i=0; i < numEnfrentamientos; i++){
            indiceEmpate[i] = -1;
        }
        
        for(int i=0; i < numEnfrentamientos; i++){
            if(goles[i][0] == goles[i][1]){
                indiceEmpate[contadorEmpate++] = i;
            }
        }
    }
    
    public boolean isEmpate(int[][] goles, int nEnfrentamientos){
        empate(goles,nEnfrentamientos);
        for(int i=0; i < contadorEmpate; i++){
            if(indiceEmpate[i] != -1){
                return true;
            }
        }
        return false;
    }
    
    public void guardarPenales(int goles[][], int nEnfrentamientos){
        numEnfrentamientos = gesEvento.getEventoDeportivo().getEnfrentamientosGes().getEnfrentamientos().contarEnfrentamientos();
        this.goles = goles;
        penales = new int[numEnfrentamientos][2];
        /*for(int i=0; i<penales.length; i++){
            penales[i][0]=-1;
            penales[i][1]=-1;
        }*/
        int contEnfrentamiento = 0;
        boolean sonNumeros = sonTodosNumeros(jtxtGol);
        
        if(sonNumeros){
            for(int i=0; i<nEnfrentamientos; i++){
                penales[i][0] = Integer.parseInt(jtxtGol[contEnfrentamiento++].getText());
                penales[i][1] = Integer.parseInt(jtxtGol[contEnfrentamiento++].getText());
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
