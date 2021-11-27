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
public class SearchBookFrame extends javax.swing.JFrame {

    /**
     * Creates new form SearchBookFrame
     */
    public SearchBookFrame() {
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

        panelTKSP = new javax.swing.JPanel();
        btnTimDDH = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        labelTkSP = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        labelHinhAnh = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSP = new javax.swing.JTable();
        txtMaSP = new javax.swing.JTextField();
        labelMaSP = new javax.swing.JLabel();
        labelTenSP = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        labelDonGia = new javax.swing.JLabel();
        cbDonGia = new javax.swing.JComboBox<>();
        labelLoaiSP = new javax.swing.JLabel();
        txtLoaiSP = new javax.swing.JTextField();
        labelNCC = new javax.swing.JLabel();
        txtNCC = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTKSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTimDDH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTimDDH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnTimDDH.setText("Tìm");
        btnTimDDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimDDHActionPerformed(evt);
            }
        });

        labelTkSP.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelTkSP.setText("Tìm kiếm sách");

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/out.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        labelHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHinhAnh.setText("Ảnh");
        labelHinhAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tableSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSP);

        labelMaSP.setText("Mã sản phẩm");

        labelTenSP.setText("Tên sản phẩm");

        labelDonGia.setText("Đơn giá");

        cbDonGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelLoaiSP.setText("Loại sản phẩm");

        labelNCC.setText("Nhà cung cấp");

        javax.swing.GroupLayout panelTKSPLayout = new javax.swing.GroupLayout(panelTKSP);
        panelTKSP.setLayout(panelTKSPLayout);
        panelTKSPLayout.setHorizontalGroup(
            panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTKSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTKSPLayout.createSequentialGroup()
                        .addGroup(panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4)
                            .addGroup(panelTKSPLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnThoat)
                                .addGap(339, 339, 339)
                                .addComponent(labelTkSP)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(panelTKSPLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelTKSPLayout.createSequentialGroup()
                                .addComponent(labelMaSP)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTKSPLayout.createSequentialGroup()
                                .addComponent(labelNCC)
                                .addGap(18, 18, 18)
                                .addComponent(txtNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52)
                        .addGroup(panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelTKSPLayout.createSequentialGroup()
                                .addComponent(labelDonGia)
                                .addGap(18, 18, 18)
                                .addComponent(cbDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTKSPLayout.createSequentialGroup()
                                .addComponent(labelTenSP)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addComponent(labelLoaiSP)
                        .addGap(18, 18, 18)
                        .addComponent(txtLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimDDH, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTKSPLayout.createSequentialGroup()
                        .addComponent(labelHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        panelTKSPLayout.setVerticalGroup(
            panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTKSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTkSP)
                    .addComponent(btnThoat))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimDDH)
                    .addGroup(panelTKSPLayout.createSequentialGroup()
                        .addGroup(panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(labelMaSP)
                            .addComponent(txtMaSP)
                            .addComponent(labelTenSP)
                            .addComponent(txtTenSP)
                            .addComponent(labelLoaiSP)
                            .addComponent(txtLoaiSP))
                        .addGap(39, 39, 39)
                        .addGroup(panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(labelNCC)
                                .addComponent(txtNCC))
                            .addGroup(panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelDonGia)
                                .addComponent(cbDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTKSPLayout.createSequentialGroup()
                        .addComponent(labelHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTKSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTKSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimDDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimDDHActionPerformed
        // TODO add your handling code here:
        //    	submitTimKiem();
    }//GEN-LAST:event_btnTimDDHActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        dispose();
        new HomeFrame().setVisible(true);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void tableSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableSPMouseClicked

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
            java.util.logging.Logger.getLogger(SearchBookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchBookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchBookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchBookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchBookFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimDDH;
    private javax.swing.JComboBox<String> cbDonGia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelDonGia;
    private javax.swing.JLabel labelHinhAnh;
    private javax.swing.JLabel labelLoaiSP;
    private javax.swing.JLabel labelMaSP;
    private javax.swing.JLabel labelNCC;
    private javax.swing.JLabel labelTenSP;
    private javax.swing.JLabel labelTkSP;
    private javax.swing.JPanel panelTKSP;
    private javax.swing.JTable tableSP;
    private javax.swing.JTextField txtLoaiSP;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNCC;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
