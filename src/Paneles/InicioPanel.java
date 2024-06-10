/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Entidades.Evento_Deportivo;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class InicioPanel extends javax.swing.JPanel{
    private Gestionador_Deportivo frame;
    private JPanel panel;
    private Evento_Deportivo gesEvento;
    private CrearEventoPanel panelCrearEvento;
    
    public InicioPanel(Gestionador_Deportivo frame,JPanel p,Evento_Deportivo gesEvento) {
        initComponents();
        this.frame = frame;
        this.gesEvento = gesEvento;
        this.panel = p;
        iniciarPaneles();
    }
    
    private void iniciarPaneles(){
        panelCrearEvento = new CrearEventoPanel(frame,this,panel,gesEvento);
    }

    public CrearEventoPanel getPanelCrearEvento() {
        return panelCrearEvento;
    }

    public void eventoEnColaJlabel(){
        jLabel2.setText("Evento en Cola");
    }
    
    public void deshabilitarBotonCrearEvento(){
        jButton1.setEnabled(false);
    }
    
    private void cambiarPanel(JPanel p){
        p.setSize(730,615); //Se encarga de definir el tamaño de los paneles en Content
        p.setLocation(0,0);
        panel.removeAll();
        panel.add(p,BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
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
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Consultar evento en curso:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Consultar evento finalizado: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(283, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(299, 299, 299))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1)))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cambiarPanel(panelCrearEvento);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // Obtener el objeto gesEvento desde panelCrearEvento
            gesEvento = panelCrearEvento.getGesEvento();
            if (gesEvento != null) {
                // Obtener la ruta del directorio raíz del proyecto
                String rutaProyecto = new File("").getAbsolutePath();

                // Definir la ruta del directorio "src/Archivos"
                String rutaDirectorio = rutaProyecto + File.separator + "src" + File.separator + "Archivos";

                // Crear el directorio si no existe
                File directorio = new File(rutaDirectorio);
                if (!directorio.exists()) {
                    directorio.mkdirs();
                }

                // Crear el archivo en el directorio "Archivos"
                String nombreArchivo = gesEvento.getCodigo_Evento() + ".txt";
                File archivo = new File(directorio, nombreArchivo);

                // Escribir el objeto gesEvento al archivo
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
                oos.writeObject(gesEvento);
                oos.close();

                System.out.println("Archivo guardado en: " + archivo.getAbsolutePath());
            } else {
                // Validar error
                System.out.println("Objeto Null");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InicioPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InicioPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // Obtener el código ingresado por el usuario
            String codigo = jTextField1.getText().trim();

            if (codigo.isEmpty()) {
                jLabel2.setText("Por favor, ingrese un código válido.");
                return;
            }

            // Obtener la ruta del directorio raíz del proyecto
            String rutaProyecto = new File("").getAbsolutePath();

            // Definir la ruta del directorio "src/Archivos"
            String rutaDirectorio = rutaProyecto + File.separator + "src" + File.separator + "Archivos";

            // Crear el objeto File para el directorio
            File directorio = new File(rutaDirectorio);

            // Verificar si el directorio existe y es una carpeta
            if (directorio.exists() && directorio.isDirectory()) {
                // Crear la ruta completa del archivo basado en el código ingresado
                String nombreArchivo = codigo + ".txt";
                File archivoSeleccionado = new File(directorio, nombreArchivo);

                // Verificar si el archivo existe
                if (archivoSeleccionado.exists() && archivoSeleccionado.isFile()) {
                    // Cargar el archivo seleccionado
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoSeleccionado));
                    Evento_Deportivo eventoDeportivo = (Evento_Deportivo) ois.readObject();
                    ois.close();

                    panelCrearEvento.setGesEvento(eventoDeportivo);

                    if (panelCrearEvento.getGesEvento() != null) {
                        jLabel2.setText("Archivo cargado correctamente");
                        deshabilitarBotonCrearEvento();
                        frame.iniciarPanelEvento();
                        frame.getJbtnEvento().setEnabled(true);
                    }
                } else {
                    jLabel2.setText("No existe el archivo con el código especificado.");
                }
            } else {
                jLabel2.setText("La carpeta 'src/Archivos' no existe.");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InicioPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InicioPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InicioPanel.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
