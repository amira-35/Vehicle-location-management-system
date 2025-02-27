package mainpage;


import database.connexion;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author aymen
 */
public class talbeClient extends javax.swing.JDialog {
    String [][] data;
    private String Tempo;
    /**
     * Creates new form talbeClient
     */
    public talbeClient(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        UpdateTable();
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Permis", "Nom", "Prénom", "Genre", "Adresse", "Téléphone"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton2.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jButton2.setText("Selectionner");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(241, 241, 241))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
       int column = 0;
        int row = jTable1.getSelectedRow();
        this.Tempo = jTable1.getModel().getValueAt(row, column).toString();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2MouseClicked
    public String showDialog() {
    setVisible(true);
    return this.Tempo;
}

    /**
     * @param args the command line arguments
     */
    private void UpdateTable() throws SQLException{
        connexion cnx = new connexion();
        this.data =  cnx.AfficherClient(cnx.countClients());
        String [] col = {"Permis","prénom","Nom","Genre","Adresse","Téléphone"};
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                            this.data,col){ boolean[] canEdit = new boolean [] {false, false, false,false, false, false};
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];}});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
