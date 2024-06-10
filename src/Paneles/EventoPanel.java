/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Entidades.Gestionador_Evento_Deportivo;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Luis
 */
public class EventoPanel extends javax.swing.JPanel{
    private JPanel panel;
    private JFrame frame;
    private Gestionador_Evento_Deportivo gesEvento;
    private EnfrentamientoPanel panelEnfrentamiento;
    private EquipoPanel panelEquipo;
    private ResultadoPanel panelResultado;
    
    
    public EventoPanel(JFrame frame,JPanel p,Gestionador_Evento_Deportivo gesEvento) {
        initComponents();
        this.frame = frame;
        this.panel = p;
        this.gesEvento = gesEvento;
        iniciarPaneles();
    }
    
    private void cambiarPanel(JPanel p){
        p.setSize(760,650); //Se encarga de definir el tamaño de los paneles en Content
        p.setLocation(0,0);
        panel.removeAll();
        panel.add(p,BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }
    
    public final void iniciarPaneles(){
        panelEnfrentamiento = new EnfrentamientoPanel(panel,gesEvento);
        panelEquipo = new EquipoPanel(frame,panel,gesEvento);
        panelResultado = new ResultadoPanel(gesEvento);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbtnInformacion = new javax.swing.JButton();
        jbtnCalendario = new javax.swing.JButton();
        jbtnEnfrentamiento = new javax.swing.JButton();
        jbtnResultados = new javax.swing.JButton();
        jbtnReportes = new javax.swing.JButton();
        jbtnEquipos = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(750, 560));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("Evento Deportivo");

        jbtnInformacion.setText("Información");
        jbtnInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnInformacionActionPerformed(evt);
            }
        });

        jbtnCalendario.setText("Calendario");
        jbtnCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCalendarioActionPerformed(evt);
            }
        });

        jbtnEnfrentamiento.setText("Enfrentamientos");
        jbtnEnfrentamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEnfrentamientoActionPerformed(evt);
            }
        });

        jbtnResultados.setText("Resultados");
        jbtnResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnResultadosActionPerformed(evt);
            }
        });

        jbtnReportes.setText("Reportes");
        jbtnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnReportesActionPerformed(evt);
            }
        });

        jbtnEquipos.setText("Equipos");
        jbtnEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEquiposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtnInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnEnfrentamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jbtnEquipos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnReportes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnCalendario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnEnfrentamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(194, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnReportesActionPerformed

    private void jbtnEnfrentamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEnfrentamientoActionPerformed
        // TODO add your handling code here:
        panelEnfrentamiento.actualizarPartidosPorDia();
        cambiarPanel(panelEnfrentamiento);
    }//GEN-LAST:event_jbtnEnfrentamientoActionPerformed

    private void jbtnInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInformacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnInformacionActionPerformed

    private void jbtnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCalendarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnCalendarioActionPerformed

    private void jbtnResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResultadosActionPerformed
        // TODO add your handling code here:
        panelResultado.actualizarResultados();
        cambiarPanel(panelResultado);
    }//GEN-LAST:event_jbtnResultadosActionPerformed

    private void jbtnEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEquiposActionPerformed
        // TODO add your handling code here:
        cambiarPanel(panelEquipo);
    }//GEN-LAST:event_jbtnEquiposActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtnCalendario;
    private javax.swing.JButton jbtnEnfrentamiento;
    private javax.swing.JButton jbtnEquipos;
    private javax.swing.JButton jbtnInformacion;
    private javax.swing.JButton jbtnReportes;
    private javax.swing.JButton jbtnResultados;
    // End of variables declaration//GEN-END:variables
}
