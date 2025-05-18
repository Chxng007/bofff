package View;

//import com.formdev.flatlaf.FlatLightLaf;
import Controller.UsuarioController;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends javax.swing.JFrame {


    private void renderizarTabla() {
        for (String[] usuario : UsuarioController.mostrarPersonasTabla()) {
            obtenerModeloTabla().addRow(usuario);
        }
    }

    private void reiniciarTabla() {
        obtenerModeloTabla().setRowCount(0);
    }

    private DefaultTableModel obtenerModeloTabla() {
        return (DefaultTableModel) jTablePeticiones1.getModel();
    }

    private void eliminar() {
        String usuario = jTextField1.getText();
        if (!usuario.isEmpty()) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Deseas eliminar el registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                UsuarioController.eliminarUsuario(usuario);
                JOptionPane.showMessageDialog(this, usuario, "Usuario Eliminado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelado", JOptionPane.ERROR_MESSAGE);
            }

            reiniciarTabla();
            renderizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Dashboard() {
        initComponents();
        UsuarioController.cargarUsuarios();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        PeticionesBtn = new javax.swing.JButton();
        atrasbtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePeticiones1 = new javax.swing.JTable();
        btnRevisado = new javax.swing.JButton();
        jButtonLimpiarTabla = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 102, 0));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Fira Code", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("HOME");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        PeticionesBtn.setBackground(new java.awt.Color(255, 255, 255));
        PeticionesBtn.setFont(new java.awt.Font("Fira Code", 1, 12)); // NOI18N
        PeticionesBtn.setForeground(new java.awt.Color(0, 0, 0));
        PeticionesBtn.setText("PETICIONES");
        PeticionesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PeticionesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PeticionesBtnActionPerformed(evt);
            }
        });

        atrasbtn.setBackground(new java.awt.Color(255, 255, 255));
        atrasbtn.setFont(new java.awt.Font("Fira Code", 1, 12)); // NOI18N
        atrasbtn.setForeground(new java.awt.Color(0, 0, 0));
        atrasbtn.setText("Atras");
        atrasbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atrasbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PeticionesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(atrasbtn))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(atrasbtn)
                .addGap(191, 191, 191)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PeticionesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("HOME", jPanel4);

        jTablePeticiones1.setBackground(new java.awt.Color(255, 255, 255));
        jTablePeticiones1.setFont(new java.awt.Font("Fira Code", 1, 12)); // NOI18N
        jTablePeticiones1.setForeground(new java.awt.Color(0, 0, 0));
        jTablePeticiones1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Usuario", "Contraseña", "Correo", "Telefono", "Peticion", "Direccion", "Pago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePeticiones1.getTableHeader().setReorderingAllowed(false);
        jTablePeticiones1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePeticiones1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTablePeticiones1);
        if (jTablePeticiones1.getColumnModel().getColumnCount() > 0) {
            jTablePeticiones1.getColumnModel().getColumn(0).setResizable(false);
            jTablePeticiones1.getColumnModel().getColumn(1).setResizable(false);
            jTablePeticiones1.getColumnModel().getColumn(2).setResizable(false);
            jTablePeticiones1.getColumnModel().getColumn(3).setResizable(false);
            jTablePeticiones1.getColumnModel().getColumn(4).setResizable(false);
            jTablePeticiones1.getColumnModel().getColumn(5).setResizable(false);
            jTablePeticiones1.getColumnModel().getColumn(6).setResizable(false);
            jTablePeticiones1.getColumnModel().getColumn(7).setResizable(false);
            jTablePeticiones1.getColumnModel().getColumn(7).setPreferredWidth(40);
        }

        btnRevisado.setBackground(new java.awt.Color(255, 255, 255));
        btnRevisado.setFont(new java.awt.Font("Fira Code", 1, 12)); // NOI18N
        btnRevisado.setForeground(new java.awt.Color(0, 0, 0));
        btnRevisado.setText("Revisado");
        btnRevisado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRevisado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevisadoActionPerformed(evt);
            }
        });

        jButtonLimpiarTabla.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLimpiarTabla.setFont(new java.awt.Font("Fira Code", 1, 12)); // NOI18N
        jButtonLimpiarTabla.setForeground(new java.awt.Color(0, 0, 0));
        jButtonLimpiarTabla.setText("Limpiar Tabla");
        jButtonLimpiarTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarTablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btnRevisado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonLimpiarTabla)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRevisado)
                    .addComponent(jButtonLimpiarTabla)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PETICIONES", jPanel7);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void atrasbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasbtnActionPerformed
        Login lg = new Login();
        lg.setVisible(true);
        dispose();
    }//GEN-LAST:event_atrasbtnActionPerformed

    private void PeticionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PeticionesBtnActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        reiniciarTabla();
        renderizarTabla();

    }//GEN-LAST:event_PeticionesBtnActionPerformed

    private void jTablePeticiones1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePeticiones1MouseClicked
        int indice = jTablePeticiones1.rowAtPoint(evt.getPoint());

        jTextField1.setText((String) jTablePeticiones1.getValueAt(indice, 1));

    }//GEN-LAST:event_jTablePeticiones1MouseClicked

    private void btnRevisadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevisadoActionPerformed
        eliminar();
        jTextField1.setText("");
    }//GEN-LAST:event_btnRevisadoActionPerformed

    private void jButtonLimpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarTablaActionPerformed
        reiniciarTabla();
    }//GEN-LAST:event_jButtonLimpiarTablaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//         try {
        ////            UIManager.setLookAndFeel(new FlatLightLaf());
////               FlatLightLaf.setup();
//        } catch (Exception ex) {
//            System.err.println("Failed to initialize LaF");
//        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PeticionesBtn;
    private javax.swing.JButton atrasbtn;
    private javax.swing.JButton btnRevisado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonLimpiarTabla;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablePeticiones1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
