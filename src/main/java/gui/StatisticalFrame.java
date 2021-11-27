/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import entity.Hoadon;
import io.github.cdimascio.dotenv.Dotenv;
import service.ThongKeService;

/**
 *
 * @author Lenovo
 */
public class StatisticalFrame extends javax.swing.JFrame {

	Dotenv dotenv = Dotenv.configure().directory("assets\\.env").ignoreIfMalformed().ignoreIfMissing().load();
	String url = dotenv.get("URL") + "/thongkeService";
	DefaultTableModel tableModel;
	List<Hoadon> listHD;
	DefaultCategoryDataset dataset = new DefaultCategoryDataset();

	/**
	 * Creates new form StatisticalFrame
	 */
	public StatisticalFrame() {
		initComponents();
		setLocationRelativeTo(null);
		tableModel = (DefaultTableModel) tableThongKe.getModel();
		dateNgayBatDau.setEnabled(false);
		dateNgayKetThuc.setEnabled(false);
		labelValueDoanhThu.setText("0");
	}

	private String formatMoney(double tien) {
		String matter;
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		matter = formatter.format(tien);
		return matter;
	}

	private void checkLoaiThongKe() {
		if (cbLoaiThongKe.getSelectedItem().toString().equals("Tùy chọn")) {
			dateNgayBatDau.setEnabled(true);
			dateNgayKetThuc.setEnabled(true);
		} else {
			dateNgayBatDau.setEnabled(false);
			dateNgayKetThuc.setEnabled(false);
		}
	}
    private void searchHDTheoNgay() throws SQLException {
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	if(dateNgayBatDau.getDate() == null || dateNgayKetThuc.getDate() == null) {
    		JOptionPane.showMessageDialog(this, "Bạn chưa nhập đầy đủ các ngày","Error!",JOptionPane.ERROR_MESSAGE);
    	}else if (dateNgayBatDau.getDate().before(dateNgayKetThuc.getDate()) == false) {
    		JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải nhỏ hơn ngày kết thúc","Error!",JOptionPane.ERROR_MESSAGE);
		}else {
			String ngaybatdau = df.format(dateNgayBatDau.getDate());
	    	String ngayketthuc = df.format(dateNgayKetThuc.getDate());
	    	try {
				ThongKeService dao = (ThongKeService) Naming.lookup(url);
				listHD = dao.searchHDTheoNgay(ngaybatdau, ngayketthuc);
		    	if(listHD.size() == 0) {
		    		JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả! Vui lòng nhập lại","Error!",JOptionPane.ERROR_MESSAGE);
		    	}
		    	tableModel.setRowCount(0);
		    	for(Hoadon l: listHD) {
		    		tableModel.addRow(new Object[] {l.getMahd(),l.getNhanvien().getTenNhanvien(),l.getKhachhang().getTenkh(),l.getKhachhang().getSodienthoai(),l.getKhachhang().getDiachi(),l.getKhachhang().getEmail(),l.getNgaylapHd(),l.getTongtien()});
		    	}
		    	dataset = createDataset(ngaybatdau, ngayketthuc);
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
    }
    private void submitTimKiem() throws SQLException {
    	if(cbLoaiThongKe.getSelectedItem().toString().equals("Thống kê trong ngày")) {
    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    		Date date = new Date();
    		String datenow = df.format(date);
    		try {
				ThongKeService dao = (ThongKeService) Naming.lookup(url);
				listHD = dao.searchHDTheoNgay(datenow, datenow);
	    		if(listHD.size() == 0) {
		    		JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả! Vui lòng nhập lại","Error!",JOptionPane.ERROR_MESSAGE);
		    	}
		    	tableModel.setRowCount(0);
		    	for(Hoadon l: listHD) {
		    		tableModel.addRow(new Object[] {l.getMahd(),l.getNhanvien().getTenNhanvien(),l.getKhachhang().getTenkh(),l.getKhachhang().getSodienthoai(),l.getKhachhang().getDiachi(),l.getKhachhang().getEmail(),l.getNgaylapHd(),l.getTongtien()});
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
				listHD = dao.searchHDTheoNgay(start.toString(), end.toString());
	    		if(listHD.size() == 0) {
		    		JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả! Vui lòng nhập lại","Error!",JOptionPane.ERROR_MESSAGE);
		    	}
		    	tableModel.setRowCount(0);
		    	for(Hoadon l: listHD) {
		    		tableModel.addRow(new Object[] {l.getMahd(),l.getNhanvien().getTenNhanvien(),l.getKhachhang().getTenkh(),l.getKhachhang().getSodienthoai(),l.getKhachhang().getDiachi(),l.getKhachhang().getEmail(),l.getNgaylapHd(),l.getTongtien()});
		    	}
		    	dataset = createDataset(start.toString(), end.toString());
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
				listHD = dao.searchHDTheoNgay(start.toString(), end.toString());
	    		if(listHD.size() == 0) {
		    		JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả! Vui lòng nhập lại","Error!",JOptionPane.ERROR_MESSAGE);
		    	}
		    	tableModel.setRowCount(0);
		    	for(Hoadon l: listHD) {
		    		tableModel.addRow(new Object[] {l.getMahd(),l.getNhanvien().getTenNhanvien(),l.getKhachhang().getTenkh(),l.getKhachhang().getSodienthoai(),l.getKhachhang().getDiachi(),l.getKhachhang().getEmail(),l.getNgaylapHd(),l.getTongtien()});
		    	}
		    	dataset = createDataset(start.toString(), end.toString());
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	if(cbLoaiThongKe.getSelectedItem().toString().equals("Tùy chọn")) {
    		searchHDTheoNgay();
    	}
    	
    }
    private DefaultCategoryDataset createDataset(String ngaybatdau, String ngayketthuc) throws SQLException {
    	DefaultCategoryDataset dataset_1 = new DefaultCategoryDataset();
    	try {
			ThongKeService dao = (ThongKeService) Naming.lookup(url);
			Map<Date, Double> map = dao.getthongkeHDtheongay(ngaybatdau, ngayketthuc);
	    	Set<Date> set = map.keySet();
	    	 TreeMap<Date, Double> sorted = new TreeMap<Date, Double>(map);
	    	 Set<Map.Entry<Date, Double>> mappings = sorted.entrySet();
	    	 for (Map.Entry<Date, Double> mapping : mappings) {
	    		 dataset_1.addValue(mapping.getValue(), "Tổng tiền", mapping.getKey().toString());
	    	  }   
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return dataset_1;
    }
    private JFreeChart createLineChart() throws SQLException {
    	JFreeChart lineChart = ChartFactory.createLineChart(
    			"Biều đồ thống kê doanh thu".toUpperCase(),
    			"Ngày","Tổng tiền",dataset,
    			PlotOrientation.VERTICAL,false,false,false
    			);
    	return lineChart;
    }
    
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelThongKe1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        labelThongKe1 = new javax.swing.JLabel();
        btnIn = new javax.swing.JButton();
        labelNgayBatDau = new javax.swing.JLabel();
        dateNgayBatDau = new com.toedter.calendar.JDateChooser();
        labelNgayKetThuc = new javax.swing.JLabel();
        dateNgayKetThuc = new com.toedter.calendar.JDateChooser();
        btnThoat1 = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        cbLoaiThongKe = new javax.swing.JComboBox<>();
        labelLoaiThongKe = new javax.swing.JLabel();
        labelTongDoanhThu = new javax.swing.JLabel();
        labelValueDoanhThu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableThongKe = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelThongKe1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        labelThongKe1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelThongKe1.setText("THỐNG KÊ DOANH THU");

        btnIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/printer.png"))); // NOI18N
        btnIn.setText("In thống kê");
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        labelNgayBatDau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNgayBatDau.setText("Thống kê từ ngày");

        dateNgayBatDau.setDateFormatString("yyyy-MM-dd");

        labelNgayKetThuc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNgayKetThuc.setText("Đến ngày");

        dateNgayKetThuc.setDateFormatString("yyyy-MM-dd");

        btnThoat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/out.png"))); // NOI18N
        btnThoat1.setText("Thoát");
        btnThoat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoat1ActionPerformed(evt);
            }
        });

        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/analytics-1.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
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

        cbLoaiThongKe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbLoaiThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống kê trong ngày", "Thống kê trong tháng", "Thống kê trong năm", "Tùy chọn" }));
        cbLoaiThongKe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLoaiThongKeItemStateChanged(evt);
            }
        });

        labelLoaiThongKe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelLoaiThongKe.setText("Chọn loại thống kê:");

        javax.swing.GroupLayout panelThongKe1Layout = new javax.swing.GroupLayout(panelThongKe1);
        panelThongKe1.setLayout(panelThongKe1Layout);
        panelThongKe1Layout.setHorizontalGroup(
            panelThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(panelThongKe1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnThoat1)
                .addGap(289, 289, 289)
                .addComponent(labelThongKe1)
                .addContainerGap(397, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelThongKe1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLoaiThongKe)
                    .addComponent(labelNgayBatDau))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelThongKe1Layout.createSequentialGroup()
                        .addComponent(dateNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(labelNgayKetThuc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelThongKe1Layout.createSequentialGroup()
                        .addComponent(cbLoaiThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(383, 383, 383)
                        .addComponent(btnTim)
                        .addGap(25, 25, 25)
                        .addComponent(btnThongKe)
                        .addGap(45, 45, 45)
                        .addComponent(btnIn)))
                .addContainerGap())
        );
        panelThongKe1Layout.setVerticalGroup(
            panelThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelThongKe1Layout.createSequentialGroup()
                .addGroup(panelThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelThongKe1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelNgayKetThuc)
                            .addComponent(dateNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelThongKe1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelThongKe1)
                            .addComponent(btnThoat1))
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelThongKe1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(panelThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnIn)
                                    .addComponent(btnThongKe)
                                    .addComponent(btnTim)
                                    .addComponent(cbLoaiThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelThongKe1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(labelLoaiThongKe)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(panelThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNgayBatDau)
                            .addComponent(dateNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38))
        );

        labelTongDoanhThu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelTongDoanhThu.setText("Tổng doanh thu:");

        labelValueDoanhThu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelValueDoanhThu.setText("valueDoanhThu");

        tableThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa đơn", "Tên nhân viên", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Email", "Ngày lập hóa đơn", "Tổng tiền hóa đơn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableThongKe);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelThongKe1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelTongDoanhThu)
                        .addGap(28, 28, 28)
                        .addComponent(labelValueDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelThongKe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTongDoanhThu)
                    .addComponent(labelValueDoanhThu))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbLoaiThongKeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLoaiThongKeItemStateChanged
        // TODO add your handling code here:
    	checkLoaiThongKe();
    }//GEN-LAST:event_cbLoaiThongKeItemStateChanged

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        // TODO add your handling code here:
    	if(listHD == null) {
    		JOptionPane.showMessageDialog(this, "Bạn cần tìm kiếm khoảng thời gian bạn muốn thống kê","Error!",JOptionPane.ERROR_MESSAGE);
    	}else {
    		Double tong = 0.0;
        	for(Hoadon i: listHD) {
        		tong = tong + i.getTongtien();
        	}
        	
        	labelValueDoanhThu.setText(formatMoney(tong) + " VND");
		}
    }//GEN-LAST:event_btnInActionPerformed

	private void btnThoat1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThoat1ActionPerformed
		// TODO add your handling code here:
		dispose();
		new HomeFrame().setVisible(true);
	}// GEN-LAST:event_btnThoat1ActionPerformed

	private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThongKeActionPerformed
		// TODO add your handling code here:
		if(cbLoaiThongKe.getSelectedItem().toString().equals("Thống kê trong ngày")) {
    		JOptionPane.showMessageDialog(this, "Hệ thống không hỗ trợ biểu đồ thống kê trong ngày","Error!",JOptionPane.ERROR_MESSAGE);
    	}else {
    		if(listHD == null) {
        		JOptionPane.showMessageDialog(this, "Bạn cần tìm kiếm khoảng thời gian bạn muốn thống kê","Error!",JOptionPane.ERROR_MESSAGE);
        	}else {
        		ChartPanel chartPanel;
				try {
					chartPanel = new ChartPanel(createLineChart());
					chartPanel.setPreferredSize(new Dimension(1000,600));
	            	JFrame frame = new JFrame();
	            	frame = new JFrame();
	            	frame.add(chartPanel);
	            	frame.setSize(2000,1000);
	            	frame.setLocationRelativeTo(null);
	                frame.setResizable(false);
	                frame.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            
    		}
		}

	}// GEN-LAST:event_btnThongKeActionPerformed

	private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTimActionPerformed
		// TODO add your handling code here:
		try {
			submitTimKiem();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// GEN-LAST:event_btnTimActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(StatisticalFrame.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(StatisticalFrame.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(StatisticalFrame.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(StatisticalFrame.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new StatisticalFrame().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnThoat1;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTim;
    private javax.swing.JComboBox<String> cbLoaiThongKe;
    private com.toedter.calendar.JDateChooser dateNgayBatDau;
    private com.toedter.calendar.JDateChooser dateNgayKetThuc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelLoaiThongKe;
    private javax.swing.JLabel labelNgayBatDau;
    private javax.swing.JLabel labelNgayKetThuc;
    private javax.swing.JLabel labelThongKe1;
    private javax.swing.JLabel labelTongDoanhThu;
    private javax.swing.JLabel labelValueDoanhThu;
    private javax.swing.JPanel panelThongKe1;
    private javax.swing.JTable tableThongKe;
    // End of variables declaration//GEN-END:variables
}
