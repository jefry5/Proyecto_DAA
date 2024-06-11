/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Entidades.Enfrentamiento;
import Entidades.Gestionador;
import java.awt.*;
import javax.swing.*;

public class ingresarGolesEnfrentamientoPanel extends javax.swing.JPanel{
    private Gestionador gesEvento;
    private JTextField[] jtxtGol;
    
    
    public ingresarGolesEnfrentamientoPanel(Gestionador gesEvento) {
        initComponents();
        this.gesEvento = gesEvento;
        actualizarPanel();
        anadirElemento();
    }
    
    public void actualizarPanel(){
        this.removeAll();
        this.setLayout(new GridLayout(this.gesEvento.getEventoDeportivo().getEnfrentamientosGes().getEnfrentamientos().contarEnfrentamientos(),4));
        anadirElemento();
    }
    
    public void anadirElemento(){
        Enfrentamiento actual = gesEvento.getEventoDeportivo().getEnfrentamientosGes().getEnfrentamientos().getCabecera();
        int numEnfrentamientos = gesEvento.getEventoDeportivo().getEnfrentamientosGes().getEnfrentamientos().contarEnfrentamientos();
        jtxtGol = new JTextField[numEnfrentamientos * 2];

        for (int i = 0; i < jtxtGol.length; i++) {
            jtxtGol[i] = new JTextField();
        }

        int cont = 0;
        for (int i = 0; i < numEnfrentamientos; i++) {
            this.add(new JLabel(actual.getEquipo1().getNombre_Equipo()));
            this.add(jtxtGol[cont++]);
            this.add(jtxtGol[cont++]);
            this.add(new JLabel(actual.getEquipo2().getNombre_Equipo()));
            actual = actual.getSiguiente_enfrentamiento();
        }

        this.revalidate();
        this.repaint();
    }
    
    public void guardarGoles(){
        int numEnfrentamientos = gesEvento.getEventoDeportivo().getEnfrentamientosGes().getEnfrentamientos().contarEnfrentamientos();
        int[][] goles = new int[numEnfrentamientos][2];
        int contEnfrentamiento = 0;
        
        for(int i=0; i<numEnfrentamientos; i++){
            goles[i][0] = Integer.parseInt(jtxtGol[contEnfrentamiento++].getText());
            goles[i][1] = Integer.parseInt(jtxtGol[contEnfrentamiento++].getText());
        }
        gesEvento.definirNuevaEtapa(goles);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
