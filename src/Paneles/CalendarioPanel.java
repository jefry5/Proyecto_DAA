package Paneles;

import Entidades.Gestionador;
import static Paneles.cargarEventoPanel.quitarExtension;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class CalendarioPanel extends javax.swing.JPanel {

    private Gestionador gesEvento;
    
    public CalendarioPanel(Gestionador gesEvento) {
        this.gesEvento = gesEvento;
        initComponents();
        jTable1.setRowSelectionAllowed(false);
        jTable1.setColumnSelectionAllowed(false);
    }
    
    public void actualizarCalendario(){
        int nEnfrentamientos = gesEvento.getEventoDeportivo().getEnfrentamientosGes().getEnfrentamientos().contarEnfrentamientos();
        if(nEnfrentamientos > 0){
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            model.setRowCount(0); // Limpiar la tabla antes de añadir datos
            for(int i=0; i<nEnfrentamientos; i++){
                String equipo1 = gesEvento.getEventoDeportivo().getEnfrentamientosGes().getEnfrentamientos().obtenerEnfrentamientoPorIndice(i).getEquipo1().getNombre_Equipo();
                String equipo2 = gesEvento.getEventoDeportivo().getEnfrentamientosGes().getEnfrentamientos().obtenerEnfrentamientoPorIndice(i).getEquipo2().getNombre_Equipo();
                String fecha = formatoFecha.format(gesEvento.getEventoDeportivo().getEnfrentamientosGes().getEnfrentamientos().obtenerEnfrentamientoPorIndice(i).getFecha_Enfrentamiento().getTime());
                model.addRow(new Object[]{equipo1,"vs",equipo2,fecha});
            }
        }else{
            //validar error
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jlblTitulo.setFont(new java.awt.Font("Comic Sans MS", 2, 24)); // NOI18N
        jlblTitulo.setText("Calendario");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipo", "", "Equipo", "Fecha"
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
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jlblTitulo)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jlblTitulo)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlblTitulo;
    // End of variables declaration//GEN-END:variables
}
