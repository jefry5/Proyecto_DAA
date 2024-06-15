/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Entidades.Gestionador;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class InicioPanel extends javax.swing.JPanel{
    private Gestionador_Deportivo frame;
    private JPanel panel;
    private Gestionador gesEvento;
    private CrearEventoPanel panelCrearEvento;
    private cargarEventoPanel panelCargarEvento;
    
    public InicioPanel(Gestionador_Deportivo frame,JPanel p,Gestionador gesEvento) throws IOException, ClassNotFoundException {
        initComponents();
        this.frame = frame;
        this.gesEvento = gesEvento;
        this.panel = p;
        iniciarPaneles();
    }
    
    private void iniciarPaneles() throws IOException, FileNotFoundException, ClassNotFoundException{
        panelCrearEvento = new CrearEventoPanel(frame,this,panel,gesEvento);
        panelCargarEvento = new cargarEventoPanel(this,panel,gesEvento);
        panelCargarEvento.actualizarTablaEvento();
    }

    public CrearEventoPanel getPanelCrearEvento() {
        return panelCrearEvento;
    }

    public void setGesEventoEnCrearEvento(Gestionador gesEvento){
        panelCrearEvento.setGesEvento(gesEvento);
    }
    
    public void eventoEnColaJlabel(){
        jLabel2.setText("Evento en Cola");
    }
    
    public void deshabilitarBotonCrearEvento(){
        jButton1.setEnabled(false);
    }
    
    private void cambiarPanel(JPanel p){
        p.setSize(760,650); //Se encarga de definir el tamaño de los paneles en Content
        p.setLocation(0,0);
        panel.removeAll();
        panel.add(p,BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }
    
    public void cargarArchivoPanel(String cod){
        String codigo = cod;
        
        if (!codigo.isEmpty()) {
            try {
                if (gesEvento.cargarArchivo(codigo) != null) {
                    setGesEventoEnCrearEvento(gesEvento.cargarArchivo(codigo));
                    deshabilitarBotonCrearEvento();
                    frame.iniciarPanelEvento();
                    frame.getJbtnEvento().setEnabled(true);
                    jLabel2.setText("Archivo cargado correctamente");
                } else {
                    jLabel2.setText("No existe Archivo");
                }
            } catch (IOException ex) {
                Logger.getLogger(InicioPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InicioPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            jLabel2.setText("Ingrese un código válido");
            return;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("Eventos Deportivos");

        jButton1.setText("Crear Evento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Historial de Eventos");

        jButton3.setText("Cargar Evento");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Guardar Evento");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(283, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(299, 299, 299))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cambiarPanel(panelCrearEvento);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        gesEvento = panelCrearEvento.getGesEvento();
        try{
            jLabel2.setText(gesEvento.guardarArchivo());
        }catch (IOException ex) {
            Logger.getLogger(InicioPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            panelCargarEvento.actualizarTablaEvento();
        } catch (IOException ex) {
            Logger.getLogger(InicioPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InicioPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        cambiarPanel(panelCargarEvento);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
