/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Image;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import entity.Sanpham;
import io.github.cdimascio.dotenv.Dotenv;
import service.SanphamService;
import service.TimKiemService;

/**
 *
 * @author Lenovo
 */
public class SearchBookFrame extends javax.swing.JFrame {

	Dotenv dotenv = Dotenv.configure()
			  .directory("assets\\.env")
			  .ignoreIfMalformed()
			  .ignoreIfMissing()
			  .load();
	String url = dotenv.get("URL") + "/timkiemService";
	String urlSP =  dotenv.get("URL") + "/sanphamService";
	DefaultTableModel tableModel;
	List<Sanpham> listSP;
    /**
     * Creates new form SearchBookFrame
     */
    public SearchBookFrame() {
        initComponents();
        setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tableSP.getModel();
    }
    private void submitTimKiem() {
    	Map<String, String> map = new HashMap<String, String>();
		if(txtMaSP.getText().equals("") == false) {
			map.put("ma_sanpham", txtMaSP.getText());
		}
		if(txtTenSP.getText().equals("") == false) {
			map.put("ten_sp", txtTenSP.getText());
		}
		if(txtTT.getText().equals("") == false) {
			map.put("trangthai",txtTT.getText());
		}
    	if(map.size() == 0) {
    		JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả! Vui lòng nhập lại từ khóa","Error!",JOptionPane.ERROR_MESSAGE);
    	}else {
    		try {
				TimKiemService dao = (TimKiemService) Naming.lookup(url);
				listSP = dao.searchSanPhamDDHT(map);
				if(listSP.size() == 0) {
	        		JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả! Vui lòng nhập lại từ khóa","Error!",JOptionPane.ERROR_MESSAGE);
	        	}else {
	        		tableModel.setRowCount(0);
	        		for(Sanpham sp: listSP) {
	        			tableModel.addRow(new Object[] {sp.getId(),sp.getTenSanpham(),sp.getDongia(),sp.getSoluongton(),sp.getTrangthai()});
	        		}
        		}
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    private void getAnh(int masp) {
    	try {
			SanphamService dao = (SanphamService) Naming.lookup(urlSP);
			Sanpham sp = dao.getSanphamById(masp);
			byte[] hinhanh = sp.getHinhanh();
			ImageIcon icon = new ImageIcon(hinhanh);
			Image img = icon.getImage();
			Image newImg = img.getScaledInstance(labelHinhAnh.getWidth(), labelHinhAnh.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon imgIcon = new ImageIcon(newImg);
			labelHinhAnh.setIcon(imgIcon);
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
        labelTT = new javax.swing.JLabel();
        txtTT = new javax.swing.JTextField();

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
        labelTkSP.setText("Tìm Kiếm Đồ dùng học tập");

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

        labelTT.setText("Trạng thái");

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
                                .addGap(220, 220, 220)
                                .addComponent(labelTkSP)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(panelTKSPLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(labelMaSP)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(labelTenSP)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(labelTT)
                        .addGap(18, 18, 18)
                        .addComponent(txtTT, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
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
                    .addGroup(panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(labelTT)
                            .addComponent(txtTT))
                        .addGroup(panelTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMaSP)
                            .addComponent(txtMaSP)
                            .addComponent(labelTenSP)
                            .addComponent(txtTenSP))))
                .addGap(18, 38, Short.MAX_VALUE)
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
         submitTimKiem();
    }//GEN-LAST:event_btnTimDDHActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
    	new HomeFrame().setVisible(true);
    	dispose();
       
    }//GEN-LAST:event_btnThoatActionPerformed

    private void tableSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSPMouseClicked
        // TODO add your handling code here:
    	int index = tableSP.getSelectedRow();
    	getAnh(listSP.get(index).getId());
    	
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelHinhAnh;
    private javax.swing.JLabel labelMaSP;
    private javax.swing.JLabel labelTT;
    private javax.swing.JLabel labelTenSP;
    private javax.swing.JLabel labelTkSP;
    private javax.swing.JPanel panelTKSP;
    private javax.swing.JTable tableSP;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtTT;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
