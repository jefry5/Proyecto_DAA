package Paneles;

import Entidades.Gestionador_Evento_Deportivo;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CrearEventoPanel extends javax.swing.JPanel{

    private Gestionador_Evento_Deportivo gesEvento;
    private JPanel panel;
    private InicioPanel panelAux;
    private Gestionador_Deportivo frame;
    private Calendar calendario;
    
    public CrearEventoPanel(Gestionador_Deportivo frame,InicioPanel panelAux, JPanel p, Gestionador_Evento_Deportivo gesEvento) {
        initComponents();
        this.frame = frame;
        this.panelAux = panelAux;
        this.panel = p;
        this.gesEvento = gesEvento;
        this.calendario = Calendar.getInstance();
        
        diasSegunMes(jcmbDiaInicio,"Enero");
        diasSegunMes(jcmbDiaFin,"Enero");
        
        jcmbMesInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el elemento seleccionado
                String selectedItem = (String) jcmbMesInicio.getSelectedItem();
                
                // Actualizar el JLabel con la información del elemento seleccionado
                jcmbDiaInicio.removeAllItems();
                diasSegunMes(jcmbDiaInicio,selectedItem);
                jcmbDiaInicio.setSelectedIndex(0);
            }
        });
        
        jcmbMesFin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el elemento seleccionado
                String selectedItem = (String) jcmbMesFin.getSelectedItem();
                
                // Actualizar el JLabel con la información del elemento seleccionado
                jcmbDiaFin.removeAllItems();
                diasSegunMes(jcmbDiaFin,selectedItem);
                jcmbDiaFin.setSelectedIndex(0);
            }
        });
        
        iniciarAnios(jcmbAnioInicio);
        iniciarAnios(jcmbAnioFin);
    }

    public Gestionador_Evento_Deportivo getGesEvento() {
        return gesEvento;
    }

    public void setGesEvento(Gestionador_Evento_Deportivo gesEvento) {
        this.gesEvento = gesEvento;
    }

    public void cambiarPanel(JPanel p){
        p.setSize(760,650); //Se encarga de definir el tamaño de los paneles en Content
        p.setLocation(0,0);
        panel.removeAll();
        panel.add(p,BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }
    
    public void iniciarAnios(JComboBox j){
        int anioActual = calendario.get(Calendar.YEAR);
        for(int i=anioActual; i<=anioActual + 2; i++){ //La suma es la cantidad de años extras desde el año actual
            j.addItem(String.valueOf(i));
        }
    }
    
    public void anadirDiasAComboBox(JComboBox j, int nDias){
        for(int i=1; i<=nDias; i++){
            j.addItem(String.valueOf(i));
        }
    }
    
    public void diasSegunMes(JComboBox j,String mes){
        switch (mes){
            case "Enero": anadirDiasAComboBox(j,31);
                          break;
            case "Febrero": anadirDiasAComboBox(j,28);
                            break;
            case "Marzo": anadirDiasAComboBox(j,31);
                          break;    
            case "Abril": anadirDiasAComboBox(j,30);
                          break;
            case "Mayo": anadirDiasAComboBox(j,31);
                          break;       
            case "Junio": anadirDiasAComboBox(j,30);
                          break; 
            case "Julio": anadirDiasAComboBox(j,31);
                          break;     
            case "Agosto": anadirDiasAComboBox(j,31);
                          break;
            case "Septiembre": anadirDiasAComboBox(j,30);
                               break;    
            case "Octubre": anadirDiasAComboBox(j,31);
                            break;
            case "Noviembre": anadirDiasAComboBox(j,30);
                              break; 
            case "Diciembre": anadirDiasAComboBox(j,31);
                              break;                   
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcmbMesInicio = new javax.swing.JComboBox<>();
        jcmbAnioInicio = new javax.swing.JComboBox<>();
        jcmbDiaInicio = new javax.swing.JComboBox<>();
        jcmbDiaFin = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jcmbMesFin = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jcmbAnioFin = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Codigo");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Fecha Inicio");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Fecha Fin");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Crear Evento Deportivo");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("/");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("/");

        jcmbMesInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jcmbDiaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbDiaInicioActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("/");

        jcmbMesFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("/");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(292, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(283, 283, 283))))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcmbDiaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcmbMesFin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcmbAnioFin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcmbDiaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcmbMesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcmbAnioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(246, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jcmbMesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcmbAnioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcmbDiaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jcmbMesFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcmbAnioFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcmbDiaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(68, 68, 68)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Calendar inicio = Calendar.getInstance();
        int AnioInicio = Integer.parseInt(String.valueOf(jcmbAnioInicio.getSelectedItem())), MesInicio = jcmbMesInicio.getSelectedIndex(), DiaInicio = Integer.parseInt(String.valueOf(jcmbDiaInicio.getSelectedItem()));
        Calendar fin = Calendar.getInstance();
        
        int AnioFin = Integer.parseInt(String.valueOf(jcmbAnioFin.getSelectedItem())), MesFin = jcmbMesFin.getSelectedIndex(), DiaFin = Integer.parseInt(String.valueOf(jcmbDiaFin.getSelectedItem()));
        inicio.set(AnioInicio,MesInicio,DiaInicio);
        fin.set(AnioFin,MesFin,DiaFin);
        
        if(!fin.before(inicio) && !jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty()){
            gesEvento.iniciarEventoDeportivo(Integer.parseInt(jTextField1.getText()),jTextField2.getText(),inicio,fin);
            frame.iniciarPanelEvento();
            frame.getJbtnEvento().setEnabled(true);
            panelAux.eventoEnColaJlabel();
            panelAux.deshabilitarBotonCrearEvento();
            cambiarPanel(panelAux);
        }else{
            //Validar error
            System.out.println("Fechas invalidas o campo incompleto");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jcmbDiaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbDiaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmbDiaInicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox<String> jcmbAnioFin;
    private javax.swing.JComboBox<String> jcmbAnioInicio;
    private javax.swing.JComboBox<String> jcmbDiaFin;
    private javax.swing.JComboBox<String> jcmbDiaInicio;
    private javax.swing.JComboBox<String> jcmbMesFin;
    private javax.swing.JComboBox<String> jcmbMesInicio;
    // End of variables declaration//GEN-END:variables
}
