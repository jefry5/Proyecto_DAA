package Paneles;

import Entidades.Gestionador;
import java.text.SimpleDateFormat;

public class InformacionPanel extends javax.swing.JPanel {
    private Gestionador gesEvento;
    
    public InformacionPanel(Gestionador gesEvento) {
        this.gesEvento = gesEvento;
        initComponents();
    }
    
    public void actualizarInformacion(){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        jLabel1.setText(String.valueOf(gesEvento.getEventoDeportivo().getCodigo_Evento()));
        jLabel2.setText(gesEvento.getEventoDeportivo().getNombre_Evento());
        jLabel4.setText(formatoFecha.format(gesEvento.getEventoDeportivo().getFecha_Inicio_Evento().getTime()));
        jLabel3.setText(formatoFecha.format(gesEvento.getEventoDeportivo().getFecha_Fin_Evento().getTime()));
        if(!gesEvento.getEventoDeportivo().isEventoFinalizado()){
            jLabel5.setText("En curso");
        }else{
            jLabel5.setText("Finalizado");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblTitulo = new javax.swing.JLabel();
        jlblEvento = new javax.swing.JLabel();
        jlblFin = new javax.swing.JLabel();
        jlblInicio = new javax.swing.JLabel();
        jlblCodigo = new javax.swing.JLabel();
        jlblEstado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jlblTitulo.setFont(new java.awt.Font("Comic Sans MS", 2, 24)); // NOI18N
        jlblTitulo.setText("Información");

        jlblEvento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlblEvento.setText("Evento:");

        jlblFin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlblFin.setText("Fin:");

        jlblInicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlblInicio.setText("Inicio:");

        jlblCodigo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlblCodigo.setText("Código:");

        jlblEstado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlblEstado.setText("Estado:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("jLabel1");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("jLabel1");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("jLabel1");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(jlblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblInicio)
                            .addComponent(jlblEvento)
                            .addComponent(jlblFin)
                            .addComponent(jlblEstado)
                            .addComponent(jlblCodigo))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))))
                .addContainerGap(317, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jlblTitulo)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCodigo)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblEvento)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblInicio)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblFin)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblEstado)
                    .addComponent(jLabel5))
                .addContainerGap(350, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jlblCodigo;
    private javax.swing.JLabel jlblEstado;
    private javax.swing.JLabel jlblEvento;
    private javax.swing.JLabel jlblFin;
    private javax.swing.JLabel jlblInicio;
    private javax.swing.JLabel jlblTitulo;
    // End of variables declaration//GEN-END:variables
}
