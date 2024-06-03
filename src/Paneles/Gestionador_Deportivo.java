package Paneles;

import Entidades.Evento_Deportivo;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Gestionador_Deportivo extends javax.swing.JFrame{

    private InicioPanel panelInicio;
    private EventoPanel panelEvento;
    private Evento_Deportivo gestionar_eventos;
    
    
    public Gestionador_Deportivo() {
        initComponents();
        //gestionar_eventos = new Evento_Deportivo();
        this.setTitle("Sistema_Deportivo");
        this.setLocationRelativeTo(null);
        panelInicio = new InicioPanel(this,Content,gestionar_eventos);
        cambiarPanel(panelInicio);
        this.jbtnEvento.setEnabled(false);
    }

    public JButton getJbtnEvento() {
        return jbtnEvento;
    }
    
    //Inicia los paneles que se cambiaran
    public void iniciarPanelEvento(){
        panelEvento = new EventoPanel(this,Content,panelInicio.getPanelCrearEvento().getGesEvento());
    }

    private void cambiarPanel(JPanel p){
        p.setSize(730,615); //Se encarga de definir el tamaño de los paneles en Content
        p.setLocation(0,0);
        Content.removeAll();
        Content.add(p,BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Content = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        app_name = new javax.swing.JLabel();
        jbtnEvento = new javax.swing.JButton();
        jbtnInicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Content.setBackground(new java.awt.Color(255, 255, 255));
        Content.setPreferredSize(new java.awt.Dimension(730, 650));

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Menu.setBackground(new java.awt.Color(13, 71, 161));
        Menu.setPreferredSize(new java.awt.Dimension(250, 650));

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        app_name.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        app_name.setForeground(new java.awt.Color(255, 255, 255));
        app_name.setText("sDep");

        jbtnEvento.setBackground(new java.awt.Color(43, 99, 184));
        jbtnEvento.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jbtnEvento.setForeground(new java.awt.Color(255, 255, 255));
        jbtnEvento.setText("Evento");
        jbtnEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEventoActionPerformed(evt);
            }
        });

        jbtnInicio.setBackground(new java.awt.Color(43, 99, 184));
        jbtnInicio.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jbtnInicio.setForeground(new java.awt.Color(255, 255, 255));
        jbtnInicio.setText("Inicio");
        jbtnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbtnEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbtnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(app_name)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(app_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jbtnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jbtnEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(347, 347, 347))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEventoActionPerformed
        // TODO add your handling code here:
        cambiarPanel(panelEvento);
    }//GEN-LAST:event_jbtnEventoActionPerformed

    private void jbtnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInicioActionPerformed
        // TODO add your handling code here:
        cambiarPanel(panelInicio);
    }//GEN-LAST:event_jbtnInicioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gestionador_Deportivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestionador_Deportivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestionador_Deportivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestionador_Deportivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gestionador_Deportivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel app_name;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtnEvento;
    private javax.swing.JButton jbtnInicio;
    // End of variables declaration//GEN-END:variables

}
