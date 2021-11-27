/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import entity.Sanpham;
import io.github.cdimascio.dotenv.Dotenv;
import service.ThongKeService;

/**
 *
 * @author Lenovo
 */
public class ProductStatisticsFrame extends javax.swing.JFrame {


	Dotenv dotenv = Dotenv.configure().directory("assets\\.env").ignoreIfMalformed().ignoreIfMissing().load();
	String url = dotenv.get("URL") + "/thongkeService";
	DefaultTableModel tableModel;
	List<List<String>> listSP;
	String sanphambanchaynhat;
	String spbanitnhat;
	int tongspbanduoc;
    /**
     * Creates new form ProductStatisticsFrame
     */
    public ProductStatisticsFrame() {
        initComponents();
        setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tableQuanLySP.getModel();
        dateNgayBatDau.setEnabled(false);
        dateNgayKetThuc.setEnabled(false);
    }

    private void checkLoaiThongKe() {
    	if(cbLoaiThongKe.getSelectedItem().toString().equals("Tùy chọn")){
    		dateNgayBatDau.setEnabled(true);
    		dateNgayKetThuc.setEnabled(true);
    	}else {
    		dateNgayBatDau.setEnabled(false);
    		dateNgayKetThuc.setEnabled(false);
    	}
    }
    private void getSanPham() throws SQLException {
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	if(dateNgayBatDau.getDate() == null || dateNgayKetThuc.getDate() == null) {
    		JOptionPane.showMessageDialog(this, "Bạn chưa nhập đầy đủ các ngày","Error!",JOptionPane.ERROR_MESSAGE);
    	}else if (dateNgayBatDau.getDate().before(dateNgayKetThuc.getDate()) == false) {
    		JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải nhỏ hơn ngày kết thúc","Error!",JOptionPane.ERROR_MESSAGE);
		}else {
			try {
				ThongKeService dao = (ThongKeService) Naming.lookup(url);
				List<Sanpham> lsp = dao.getSanPham();
		    	List<String> listMaSP = new ArrayList<String>();
		    	for(Sanpham sp: lsp) {
		    		listMaSP.add(String.valueOf(sp.getId()));
		    	}
		    	String ngaybatdau = df.format(dateNgayBatDau.getDate());
		    	String ngayketthuc = df.format(dateNgayKetThuc.getDate());
		    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		    	map = dao.getCountSP(listMaSP, ngaybatdau, ngayketthuc);
		    	Set<Integer> set = map.keySet();
		    	listSP = new ArrayList<List<String>>();
		    	for(Sanpham sp: lsp) {
		    		for (Integer key : set) {
		               if(key == sp.getId()) {
		            	   List<String> item = new ArrayList<String>();
		            	   item.add(String.valueOf(sp.getId()));
		            	   item.add(sp.getTenSanpham());
		            	   item.add(String.valueOf(sp.getDongia()));
		            	   item.add(String.valueOf(sp.getSoluongton()));
		            	   item.add(sp.getTrangthai());
		            	   item.add(sp.getTenTacgia());
		            	   item.add(String.valueOf(sp.getSotrang()));
		            	   item.add(sp.getNhaxuatban());
		            	   item.add(String.valueOf(map.get(key)));
		            	   listSP.add(item);
		               }
		            }
		    	}
		    	tableModel.setRowCount(0);
		    	for(List<String> l: listSP) {
		    		tableModel.addRow(new Object[] {l.get(0),l.get(1),l.get(2),l.get(3),l.get(4),l.get(5),l.get(6),l.get(7),l.get(8)});
		    	}
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    }
    public void submirTimKiem() throws SQLException {
    	if(cbLoaiThongKe.getSelectedItem().toString().equals("Thống kê trong ngày")) {
    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    		Date date = new Date();
    		String datenow = df.format(date);
    		try {
				ThongKeService dao = (ThongKeService) Naming.lookup(url);
				List<Sanpham> lsp = dao.getSanPham();
		    	List<String> listMaSP = new ArrayList<String>();
		    	for(Sanpham sp: lsp) {
		    		listMaSP.add(String.valueOf(sp.getId()));
		    	}
		    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		    	map = dao.getCountSP(listMaSP, datenow, datenow);
		    	Set<Integer> set = map.keySet();
		    	listSP = new ArrayList<List<String>>();
		    	for(Sanpham sp: lsp) {
		    		for (Integer key : set) {
		               if(key == sp.getId()) {
		            	   List<String> item = new ArrayList<String>();
		            	   item.add(String.valueOf(sp.getId()));
		            	   item.add(sp.getTenSanpham());
		            	   item.add(String.valueOf(sp.getDongia()));
		            	   item.add(String.valueOf(sp.getSoluongton()));
		            	   item.add(sp.getTrangthai());
		            	   item.add(sp.getTenTacgia());
		            	   item.add(String.valueOf(sp.getSotrang()));
		            	   item.add(sp.getNhaxuatban());
		            	   item.add(String.valueOf(map.get(key)));
		            	   listSP.add(item);
		               }
		            }
		    	}
		    	tableModel.setRowCount(0);
		    	for(List<String> l: listSP) {
		    		tableModel.addRow(new Object[] {l.get(0),l.get(1),l.get(2),l.get(3),l.get(4),l.get(5),l.get(6),l.get(7),l.get(8)});
		    	}
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	if(cbLoaiThongKe.getSelectedItem().toString().equals("Thống kê trong tháng")) {
    		LocalDate initial = LocalDate.now();
    		LocalDate start = initial.withDayOfMonth(1);
    		LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());
    		try {
				ThongKeService dao = (ThongKeService) Naming.lookup(url);
				List<Sanpham> lsp = dao.getSanPham();
		    	List<String> listMaSP = new ArrayList<String>();
		    	for(Sanpham sp: lsp) {
		    		listMaSP.add(String.valueOf(sp.getId()));
		    	}
		    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		    	map = dao.getCountSP(listMaSP, start.toString(), end.toString());
		    	Set<Integer> set = map.keySet();
		    	listSP = new ArrayList<List<String>>();
		    	for(Sanpham sp: lsp) {
		    		for (Integer key : set) {
		               if(key == sp.getId()) {
		            	   List<String> item = new ArrayList<String>();
		            	   item.add(String.valueOf(sp.getId()));
		            	   item.add(sp.getTenSanpham());
		            	   item.add(String.valueOf(sp.getDongia()));
		            	   item.add(String.valueOf(sp.getSoluongton()));
		            	   item.add(sp.getTrangthai());
		            	   item.add(sp.getTenTacgia());
		            	   item.add(String.valueOf(sp.getSotrang()));
		            	   item.add(sp.getNhaxuatban());
		            	   item.add(String.valueOf(map.get(key)));
		            	   listSP.add(item);
		               }
		            }
		    	}
		    	tableModel.setRowCount(0);
		    	for(List<String> l: listSP) {
		    		tableModel.addRow(new Object[] {l.get(0),l.get(1),l.get(2),l.get(3),l.get(4),l.get(5),l.get(6),l.get(7),l.get(8)});
		    	}
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	if(cbLoaiThongKe.getSelectedItem().toString().equals("Thống kê trong năm")) {
    		LocalDate initial = LocalDate.now();
    		LocalDate start = initial.withDayOfYear(1);
    		LocalDate end = initial.withDayOfYear(initial.lengthOfYear());
    		try {
				ThongKeService dao = (ThongKeService) Naming.lookup(url);
				List<Sanpham> lsp = dao.getSanPham();
		    	List<String> listMaSP = new ArrayList<String>();
		    	for(Sanpham sp: lsp) {
		    		listMaSP.add(String.valueOf(sp.getId()));
		    	}
		    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		    	map = dao.getCountSP(listMaSP, start.toString(), end.toString());
		    	Set<Integer> set = map.keySet();
		    	listSP = new ArrayList<List<String>>();
		    	for(Sanpham sp: lsp) {
		    		for (Integer key : set) {
		               if(key == sp.getId()) {
		            	   List<String> item = new ArrayList<String>();
		            	   item.add(String.valueOf(sp.getId()));
		            	   item.add(sp.getTenSanpham());
		            	   item.add(String.valueOf(sp.getDongia()));
		            	   item.add(String.valueOf(sp.getSoluongton()));
		            	   item.add(sp.getTrangthai());
		            	   item.add(sp.getTenTacgia());
		            	   item.add(String.valueOf(sp.getSotrang()));
		            	   item.add(sp.getNhaxuatban());
		            	   item.add(String.valueOf(map.get(key)));
		            	   listSP.add(item);
		               }
		            }
		    	}
		    	tableModel.setRowCount(0);
		    	for(List<String> l: listSP) {
		    		tableModel.addRow(new Object[] {l.get(0),l.get(1),l.get(2),l.get(3),l.get(4),l.get(5),l.get(6),l.get(7),l.get(8)});
		    	}
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	if(cbLoaiThongKe.getSelectedItem().toString().equals("Tùy chọn")) {
    		getSanPham();
    	}
    }
    private PieDataset createDataset() {
    	Double tongsp = 0.0;
    	for(List<String> item: listSP) {
    		tongsp = tongsp + Double.parseDouble(item.get(8));
    	}
    	DefaultPieDataset dataset = new DefaultPieDataset();
    	for(List<String> item: listSP) {
    		dataset.setValue(item.get(1),Double.parseDouble(item.get(8))/tongsp);
    	}
    	return dataset;
    }
    private JFreeChart createChart() {
    	JFreeChart chart = ChartFactory.createPieChart(
                "CƠ CẤU SẢN PHẨM TRONG THỜI GIAN ĐÃ CHỌN", createDataset(), true, true, true);
    	return chart;
    }
    private void xuatBieuDoThongKe() {
    	if(listSP == null) {
    		JOptionPane.showMessageDialog(this, "Bạn cần tìm kiếm khoảng thời gian bạn muốn thống kê","Error!",JOptionPane.ERROR_MESSAGE);
    	}else {
    		JFreeChart pieChart = createChart();
            ChartPanel chartPanel = new ChartPanel(pieChart);
            JFrame frame = new JFrame();
            frame.add(chartPanel);
            frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
            frame.setSize(1000, 500);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
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

        panelThongKe = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        labelThongKeSP = new javax.swing.JLabel();
        labelNgayBatDau = new javax.swing.JLabel();
        dateNgayBatDau = new com.toedter.calendar.JDateChooser();
        labelNgayKetThuc = new javax.swing.JLabel();
        dateNgayKetThuc = new com.toedter.calendar.JDateChooser();
        btnThoat = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        labelLoaiThongKe = new javax.swing.JLabel();
        cbLoaiThongKe = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableQuanLySP = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelThongKe.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        labelThongKeSP.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelThongKeSP.setText("THỐNG KÊ SẢN PHẨM");

        labelNgayBatDau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNgayBatDau.setText("Thống kê từ ngày");

        dateNgayBatDau.setDateFormatString("yyyy-MM-dd");

        labelNgayKetThuc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNgayKetThuc.setText("Đến ngày");

        dateNgayKetThuc.setDateFormatString("yyyy-MM-dd");

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/out.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/product-statistics-1.png"))); // NOI18N
        btnThongKe.setText("Biểu đồ thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        labelLoaiThongKe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelLoaiThongKe.setText("Chọn loại thống kê:");

        cbLoaiThongKe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbLoaiThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống kê trong ngày", "Thống kê trong tháng", "Thống kê trong năm", "Tùy chọn" }));
        cbLoaiThongKe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLoaiThongKeItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelThongKeLayout = new javax.swing.GroupLayout(panelThongKe);
        panelThongKe.setLayout(panelThongKeLayout);
        panelThongKeLayout.setHorizontalGroup(
            panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(panelThongKeLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnThoat)
                .addGap(295, 295, 295)
                .addComponent(labelThongKeSP)
                .addContainerGap(419, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelThongKeLayout.createSequentialGroup()
                        .addComponent(labelNgayBatDau)
                        .addGap(18, 18, 18)
                        .addComponent(dateNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(labelNgayKetThuc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelThongKeLayout.createSequentialGroup()
                        .addComponent(labelLoaiThongKe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbLoaiThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(441, 441, 441)
                        .addComponent(btnTim)
                        .addGap(45, 45, 45)
                        .addComponent(btnThongKe)
                        .addGap(76, 76, 76))))
        );
        panelThongKeLayout.setVerticalGroup(
            panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongKeLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelThongKeSP)
                    .addComponent(btnThoat))
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbLoaiThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelLoaiThongKe))
                    .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThongKe)
                        .addComponent(btnTim)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelNgayKetThuc)
                    .addComponent(dateNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNgayBatDau))
                .addGap(31, 31, 31))
        );

        tableQuanLySP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng tồn", "Trạng thái", "Tên tác giả", "Số trang", "Nhà xuất bản", "Số lượng bán được"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableQuanLySP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
    	 dispose();
         new HomeFrame().setVisible(true);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
    	xuatBieuDoThongKe();
       
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
    	try {
			submirTimKiem();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }//GEN-LAST:event_btnTimActionPerformed

    private void cbLoaiThongKeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLoaiThongKeItemStateChanged
        // TODO add your handling code here:
    	checkLoaiThongKe();
    }//GEN-LAST:event_cbLoaiThongKeItemStateChanged

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
            java.util.logging.Logger.getLogger(ProductStatisticsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductStatisticsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductStatisticsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductStatisticsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductStatisticsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTim;
    private javax.swing.JComboBox<String> cbLoaiThongKe;
    private com.toedter.calendar.JDateChooser dateNgayBatDau;
    private com.toedter.calendar.JDateChooser dateNgayKetThuc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelLoaiThongKe;
    private javax.swing.JLabel labelNgayBatDau;
    private javax.swing.JLabel labelNgayKetThuc;
    private javax.swing.JLabel labelThongKeSP;
    private javax.swing.JPanel panelThongKe;
    private javax.swing.JTable tableQuanLySP;
    // End of variables declaration//GEN-END:variables
}
