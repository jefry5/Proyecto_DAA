package Paneles;

import Entidades.Gestionador;
import Entidades.ListaDeportista;
import Entidades.NodoDeportista;
import javax.swing.table.DefaultTableModel;

public class ListaDeportistaPanel extends javax.swing.JPanel{
    private Gestionador gesEvento;
    private int posicionDeBusqueda;
    private ListaDeportista lista;
    
    public ListaDeportistaPanel(Gestionador gesEvento) {
        initComponents();
        this.gesEvento = gesEvento;
    }

    public void posicionEquipo(int codigo){
        this.posicionDeBusqueda = gesEvento.getEventoDeportivo().getEquiposGes().busquedaBinariaPorCodigo(codigo);
    }
    
    public void actualizarListaDeportista(){
        DefaultTableModel model = (DefaultTableModel) jtblMostrar.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de añadir datos
        lista = gesEvento.listarDeportistas();
        NodoDeportista aux = lista.getCabecera();
        while(aux != null){
            String codigo = aux.getDepor().getCodigo_Deportista();
            String nombre = aux.getDepor().getNombre_Deportista();
            String apellidos = aux.getDepor().getApellidoPaterno_Deportista()+ " " + aux.getDepor().getApellidoMaterno_Deportista();
            int edad = aux.getDepor().getEdad_Deportista();
            int indiceEquipo = gesEvento.indiceEquipo(codigo);
            String equipo = gesEvento.getEventoDeportivo().getEquiposGes().getEquipos()[indiceEquipo].getNombre_Equipo();
            model.addRow(new Object[]{codigo, nombre, apellidos, edad, equipo});    
            aux = aux.getSiguiente();
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblMostrar = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        eliminarDepButton = new javax.swing.JButton();
        eliminarDepText = new javax.swing.JTextField();
        salidaEliminarDep = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Mostrar todos los deportistas:");

        jtblMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Apellidos", "Edad", "Equipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            jtblMostrar.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton1.setText("Ordenar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        eliminarDepButton.setText("Eliminar");
        eliminarDepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarDepButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eliminarDepText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarDepButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salidaEliminarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salidaEliminarDep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eliminarDepText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eliminarDepButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        lista.ordenarListaDeportista();
        actualizarListaDeportista();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void eliminarDepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarDepButtonActionPerformed
        // TODO add your handling code here:
        if(eliminarDepText.getText() != ""){
            String codigo = eliminarDepText.getText();
            salidaEliminarDep.setText(gesEvento.eliminarDeportista(codigo,posicionDeBusqueda));
            eliminarDepText.setText("");
            actualizarListaDeportista();
        }else{
            salidaEliminarDep.setText("Introduzca un codigo");
        }
    }//GEN-LAST:event_eliminarDepButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminarDepButton;
    private javax.swing.JTextField eliminarDepText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtblMostrar;
    private javax.swing.JLabel salidaEliminarDep;
    // End of variables declaration//GEN-END:variables
}
