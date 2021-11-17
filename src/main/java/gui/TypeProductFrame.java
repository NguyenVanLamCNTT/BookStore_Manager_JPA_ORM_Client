/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import entity.LoaiSanpham;
import io.github.cdimascio.dotenv.Dotenv;
import service.LoaiSanphamService;

/**
 *
 * @author Lenovo
 */
public class TypeProductFrame extends javax.swing.JFrame {
	Dotenv dotenv = Dotenv.configure()
			  .directory("assets\\.env")
			  .ignoreIfMalformed()
			  .ignoreIfMissing()
			  .load();
	String url = dotenv.get("URL") + "/loaiSanphamService";
	DefaultTableModel tableModel;
	List<LoaiSanpham> listLoaiSP;
    /**
     * Creates new form TypeProductFrame
     */
    public TypeProductFrame() {
        initComponents();
        setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tableCapNhatLoaiSP.getModel();
        showData();
        reset();
    }
    
    private void showData() {
    	try {
			LoaiSanphamService dao = (LoaiSanphamService) Naming.lookup(url);
			listLoaiSP = dao.getLoaiSP();
			tableModel.setRowCount(0);
			for	(LoaiSanpham loaisp : listLoaiSP) {
	    		tableModel.addRow(new Object[] {loaisp.getId(),loaisp.getTenloaisp()});
	    	}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    private void regex() {
    	String malsp = txtMaLoaiSP.getText();
    	String tenloaisp = txtTenLoaiSP.getText();
    	if(malsp.equals("")) {
    		JOptionPane.showMessageDialog(this, "Mã loại sản phẩm không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtMaLoaiSP.setBorder(new LineBorder(Color.red));
    	}else {
			txtMaLoaiSP.setBorder(new LineBorder(Color.green));
		}
    	if(tenloaisp.equals("")) {
    		JOptionPane.showMessageDialog(this, "Tên loại sản phẩm không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtTenLoaiSP.setBorder(new LineBorder(Color.red));
    	}else {
			txtTenLoaiSP.setBorder(new LineBorder(Color.green));
		}
    }
    private boolean checkInput() {
    	String malsp = txtMaLoaiSP.getText();
    	String tenlsp = txtTenLoaiSP.getText();
    	if(malsp.equals("") && tenlsp.equals("")) {
    		return false;
    	}else {
			return true;
		}
    }
    private void reset() {
    	txtMaLoaiSP.setEnabled(false);
    	txtMaLoaiSP.setText("");
    	txtTenLoaiSP.setEnabled(false);
    	txtTenLoaiSP.setText("");
    	btnLuu.setEnabled(false);
    	btnQuayLai.setEnabled(false);
    	btnSua.setEnabled(false);
    	btnXoa.setEnabled(false);
    	txtMaLoaiSP.setBorder(new LineBorder(Color.black));
    	txtTenLoaiSP.setBorder(new LineBorder(Color.black));
    }
    private void clickBtnThem() {
    	reset();
    	txtMaLoaiSP.setEnabled(true);
    	txtTenLoaiSP.setEnabled(true);
    	btnQuayLai.setEnabled(true);
    	btnLuu.setEnabled(true);
    }
    private boolean checkStatusBtnLuu(String malsp) {
    	int select = tableCapNhatLoaiSP.getSelectedRow();
    	if(select == -1) {
    		return false;
    	}else {
			if(malsp.equals(listLoaiSP.get(select).getId())) {
				return true;
			}else {
				return false;
			}
		}
    }
    private boolean checkMaLoaiSP(String malsp) {
    	for(LoaiSanpham loaisp: listLoaiSP) {
    		if(malsp.equals(loaisp.getId())) {
    			JOptionPane.showMessageDialog(this, "Mã loại sản phẩm tồn tại","Error!",JOptionPane.ERROR_MESSAGE);
        		txtMaLoaiSP.setBorder(new LineBorder(Color.red));
    			return true;
    		}
    	}
    	txtMaLoaiSP.setBorder(new LineBorder(Color.green));
    	return false;
    }
    private int notify(String title, String message) {
    	int n = JOptionPane.showConfirmDialog(this, message,title,JOptionPane.YES_NO_OPTION);
    	return n;
    }
    private void clickBtnLuu() {
    	try {
			LoaiSanphamService dao = (LoaiSanphamService) Naming.lookup(url);
			String malsp = txtMaLoaiSP.getText();
	    	String tenlsp = txtTenLoaiSP.getText();
	    	if(checkStatusBtnLuu(malsp) == true) {
	    		regex();
	    		if(checkInput() == true && notify("", "Bạn có chắc muốn lưu thay đổi không?") == 0) {
	    			dao.updateLoaiSP(new LoaiSanpham(malsp,tenlsp));
	    			showData();
	    			reset();
	    			JOptionPane.showMessageDialog(this,"Bạn đã cập nhật thành công!");
	    		}
	    	}else {
				regex();
				if(checkInput() == true && checkMaLoaiSP(malsp) == false && notify("", "Bạn có chắc muốn lưu loại sản phẩm này không") == 0) {
					dao.insertLoaiSP(new LoaiSanpham(malsp,tenlsp));
					showData();
					reset();
					JOptionPane.showMessageDialog(this,"Bạn đã lưu thành công!");
				}
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCapNhatLSP = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        labelCapNhatLSP = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        labelMaLoaiSP = new javax.swing.JLabel();
        txtMaLoaiSP = new javax.swing.JTextField();
        labelTenLoaiSP = new javax.swing.JLabel();
        txtTenLoaiSP = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCapNhatLoaiSP = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelCapNhatLSP.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        labelCapNhatLSP.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelCapNhatLSP.setText("CẬP NHẬT LOẠI SẢN PHẨM");

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/out.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        labelMaLoaiSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelMaLoaiSP.setText("Mã Loại sản phẩm");

        txtMaLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaLoaiSPActionPerformed(evt);
            }
        });

        labelTenLoaiSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTenLoaiSP.setText("Tên loại sản phẩm");

        txtTenLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenLoaiSPActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fix.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save.png"))); // NOI18N
        btnLuu.setText("Lưiu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnQuayLai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnQuayLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnQuayLai.setText("Quay Lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCapNhatLSPLayout = new javax.swing.GroupLayout(panelCapNhatLSP);
        panelCapNhatLSP.setLayout(panelCapNhatLSPLayout);
        panelCapNhatLSPLayout.setHorizontalGroup(
            panelCapNhatLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelCapNhatLSPLayout.createSequentialGroup()
                .addGap(73, 1009, Short.MAX_VALUE)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(panelCapNhatLSPLayout.createSequentialGroup()
                .addGroup(panelCapNhatLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCapNhatLSPLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnThoat)
                        .addGap(323, 323, 323)
                        .addComponent(labelCapNhatLSP))
                    .addGroup(panelCapNhatLSPLayout.createSequentialGroup()
                        .addGroup(panelCapNhatLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelCapNhatLSPLayout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addComponent(labelMaLoaiSP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133)
                                .addComponent(labelTenLoaiSP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(panelCapNhatLSPLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)))
                        .addGroup(panelCapNhatLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        panelCapNhatLSPLayout.setVerticalGroup(
            panelCapNhatLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCapNhatLSPLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelCapNhatLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCapNhatLSP)
                    .addComponent(btnThoat))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelCapNhatLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCapNhatLSPLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(labelMaLoaiSP))
                    .addGroup(panelCapNhatLSPLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelCapNhatLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCapNhatLSPLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(labelTenLoaiSP))
                            .addComponent(txtTenLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(panelCapNhatLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnLuu)
                    .addComponent(btnQuayLai))
                .addGap(75, 75, 75))
        );

        tableCapNhatLoaiSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã loại sản phẩm", "Tên loại sản phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCapNhatLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCapNhatLoaiSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCapNhatLoaiSP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCapNhatLSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCapNhatLSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        dispose();
        new HomeFrame().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThoatActionPerformed

    private void txtMaLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaLoaiSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaLoaiSPActionPerformed

    private void txtTenLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenLoaiSPActionPerformed

    }//GEN-LAST:event_txtTenLoaiSPActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        clickBtnThem();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    	try {
			LoaiSanphamService dao = (LoaiSanphamService) Naming.lookup(url);
			String malsp = txtMaLoaiSP.getText();
	    	if(notify("", "Bạn có chắc muốn xóa nhà cung cấp ngày không ?") == 0) {
	    		boolean success = dao.deleteLoaiSP(malsp);
	    		if(success == true) {
	    			JOptionPane.showMessageDialog(this,"Bạn đã xóa thành công!");
	    			showData();
	    		}else {
	    			JOptionPane.showMessageDialog(this,"Lỗi không thể xóa!","", JOptionPane.ERROR_MESSAGE);
	    			showData();
				}
	    	}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	reset();
        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    	txtTenLoaiSP.setEnabled(true);
    	btnLuu.setEnabled(true);
       
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
    	clickBtnLuu();
    	reset();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        // TODO add your handling code here:
      reset();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void tableCapNhatLoaiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCapNhatLoaiSPMouseClicked
        // TODO add your handling code here:
    	int index = tableCapNhatLoaiSP.getSelectedRow();
    	txtMaLoaiSP.setText(listLoaiSP.get(index).getId());
    	txtTenLoaiSP.setText(listLoaiSP.get(index).getTenloaisp());
    	txtMaLoaiSP.setEnabled(false);
    	txtTenLoaiSP.setEnabled(false);
    	btnSua.setEnabled(true);
    	btnXoa.setEnabled(true);
    	btnQuayLai.setEnabled(true);
    }//GEN-LAST:event_tableCapNhatLoaiSPMouseClicked

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
            java.util.logging.Logger.getLogger(TypeProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TypeProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TypeProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TypeProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TypeProductFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCapNhatLSP;
    private javax.swing.JLabel labelMaLoaiSP;
    private javax.swing.JLabel labelTenLoaiSP;
    private javax.swing.JPanel panelCapNhatLSP;
    private javax.swing.JTable tableCapNhatLoaiSP;
    private javax.swing.JTextField txtMaLoaiSP;
    private javax.swing.JTextField txtTenLoaiSP;
    // End of variables declaration//GEN-END:variables
}
