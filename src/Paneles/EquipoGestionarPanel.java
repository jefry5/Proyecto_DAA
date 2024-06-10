/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Entidades.Evento_Deportivo;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Luis
 */
public class EquipoGestionarPanel extends javax.swing.JPanel{
    private Evento_Deportivo gesEvento;
    private JFrame frame;
    private DeportistaAgregarPanel deportistaPanel;
    private DeportistaMostrarPanel panelDeportistaMostrar;
    private JPanel panel;
    /**
     * Creates new form EquipoGestionarPanel
     */
    public EquipoGestionarPanel(JFrame frame,Evento_Deportivo gesEvento, JPanel p) {
        initComponents();   
        this.frame = frame;
        this.gesEvento = gesEvento;
        this.panel = p;
        this.deportistaPanel = new DeportistaAgregarPanel(this.gesEvento);
        this.panelDeportistaMostrar = new DeportistaMostrarPanel(this.gesEvento);
    }

    private void cambiarPanel(JPanel p){
        p.setSize(730,615); //Se encarga de definir el tamaño de los paneles en Content
        p.setLocation(0,0);
        panel.removeAll();
        panel.add(p,BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }

    public void actualizarTablaMostrar(){
        DefaultTableModel model = (DefaultTableModel) jtblMostrar.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de añadir datos
        
        for(int i=0; i<gesEvento.getEquipos().getContadorEquipos(); i++){
            String codigo = gesEvento.getEquipos().getEquipos()[i].getCodigo_Equipo();
            String nombre = gesEvento.getEquipos().getEquipos()[i].getNombre_Equipo();
            String dt = gesEvento.getEquipos().getEquipos()[i].getNombre_DT();
            String provenencia = gesEvento.getEquipos().getEquipos()[i].getProvenencia_Equipo();
            model.addRow(new Object[]{codigo, nombre, dt, provenencia});
        }
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
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblMostrar = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Mostrar Equipos:");

        jButton1.setText("Ordenar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtblMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "DT", "Provenencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblMostrar.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtblMostrar);
        if (jtblMostrar.getColumnModel().getColumnCount() > 0) {
            jtblMostrar.getColumnModel().getColumn(0).setResizable(false);
            jtblMostrar.getColumnModel().getColumn(1).setResizable(false);
            jtblMostrar.getColumnModel().getColumn(2).setResizable(false);
            jtblMostrar.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton2.setText("AgregarDeportistaTabla");
        jButton2.setToolTipText("Seleccione un elemento de la tabla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("MostrarDeportistaTabla");
        jButton3.setToolTipText("Seleccione un elemento de la tabla");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        gesEvento.getEquipos().ordenarLista();
        actualizarTablaMostrar();
        //OTRA LOGICA PARA ORDENAR LA TABLA
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jtblMostrar.getRowCount() > 0 && jtblMostrar.getSelectedRow()!=-1 && jtblMostrar.getSelectedColumn() != -1){  
           deportistaPanel.posicionDeportista(Integer.parseInt(jtblMostrar.getValueAt(jtblMostrar.getSelectedRow(), 0).toString()));
           cambiarPanel(deportistaPanel);
        }else{
            //Validar error
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(jtblMostrar.getRowCount() > 0 && jtblMostrar.getSelectedRow()!=-1 && jtblMostrar.getSelectedColumn() != -1){ 
           panelDeportistaMostrar.posicionEquipo(Integer.parseInt(jtblMostrar.getValueAt(jtblMostrar.getSelectedRow(), 0).toString()));
           panelDeportistaMostrar.actualizarTablaMostrar();
           panelDeportistaMostrar.habilitarBotonExamenMedico();
           cambiarPanel(panelDeportistaMostrar);
        }else{
            //Validar error
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtblMostrar;
    // End of variables declaration//GEN-END:variables
}
