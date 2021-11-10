/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Lenovo
 */
public class SearchProducerFrame extends javax.swing.JFrame {

    /**
     * Creates new form SearchProducerFrame
     */
    public SearchProducerFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTKNCC1 = new javax.swing.JPanel();
        btnTimDDH1 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        labelTkNCC1 = new javax.swing.JLabel();
        btnThoat1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableNCC1 = new javax.swing.JTable();
        labelMaNCC1 = new javax.swing.JLabel();
        txtMaNCC1 = new javax.swing.JTextField();
        labelTenNCC1 = new javax.swing.JLabel();
        txtTenNCC1 = new javax.swing.JTextField();
        labelDiaChi1 = new javax.swing.JLabel();
        txtDiaChi1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTKNCC1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTimDDH1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTimDDH1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnTimDDH1.setText("Tìm");
        btnTimDDH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimDDH1ActionPerformed(evt);
            }
        });

        labelTkNCC1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelTkNCC1.setText("Tìm kiếm nhà cung cấp");

        btnThoat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/out.png"))); // NOI18N
        btnThoat1.setText("Thoát");
        btnThoat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoat1ActionPerformed(evt);
            }
        });

        tableNCC1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tableNCC1);

        labelMaNCC1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelMaNCC1.setText("Mã nhà cung cấp");

        labelTenNCC1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTenNCC1.setText("Tên nhà cung cấp");

        labelDiaChi1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDiaChi1.setText("Địa chỉ");

        javax.swing.GroupLayout panelTKNCC1Layout = new javax.swing.GroupLayout(panelTKNCC1);
        panelTKNCC1.setLayout(panelTKNCC1Layout);
        panelTKNCC1Layout.setHorizontalGroup(
            panelTKNCC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTKNCC1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTKNCC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addGroup(panelTKNCC1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnThoat1)
                        .addGap(339, 339, 339)
                        .addComponent(labelTkNCC1)
                        .addGap(0, 291, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
            .addGroup(panelTKNCC1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelTKNCC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelTKNCC1Layout.createSequentialGroup()
                        .addComponent(labelDiaChi1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDiaChi1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTKNCC1Layout.createSequentialGroup()
                        .addComponent(labelMaNCC1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(140, 140, 140)
                .addComponent(labelTenNCC1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTimDDH1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        panelTKNCC1Layout.setVerticalGroup(
            panelTKNCC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTKNCC1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTKNCC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTkNCC1)
                    .addComponent(btnThoat1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(panelTKNCC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMaNCC1)
                    .addComponent(txtTenNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTenNCC1)
                    .addComponent(btnTimDDH1))
                .addGap(65, 65, 65)
                .addGroup(panelTKNCC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDiaChi1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTKNCC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTKNCC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimDDH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimDDH1ActionPerformed
        // TODO add your handling code here:
        //    	submitTimKiem();
    }//GEN-LAST:event_btnTimDDH1ActionPerformed

    private void btnThoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoat1ActionPerformed
        // TODO add your handling code here:
        dispose();
        new HomeFrame().setVisible(true);
    }//GEN-LAST:event_btnThoat1ActionPerformed

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
            java.util.logging.Logger.getLogger(SearchProducerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchProducerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchProducerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchProducerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchProducerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThoat1;
    private javax.swing.JButton btnTimDDH;
    private javax.swing.JButton btnTimDDH1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel labelDiaChi;
    private javax.swing.JLabel labelDiaChi1;
    private javax.swing.JLabel labelMaNCC;
    private javax.swing.JLabel labelMaNCC1;
    private javax.swing.JLabel labelTenNCC;
    private javax.swing.JLabel labelTenNCC1;
    private javax.swing.JLabel labelTkNCC;
    private javax.swing.JLabel labelTkNCC1;
    private javax.swing.JPanel panelTKNCC;
    private javax.swing.JPanel panelTKNCC1;
    private javax.swing.JTable tableNCC;
    private javax.swing.JTable tableNCC1;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDiaChi1;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtMaNCC1;
    private javax.swing.JTextField txtTenNCC;
    private javax.swing.JTextField txtTenNCC1;
    // End of variables declaration//GEN-END:variables
}
