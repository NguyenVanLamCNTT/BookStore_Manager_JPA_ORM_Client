/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entity.LoaiSanpham;
import entity.Nhacungcap;
import entity.Sanpham;
import service.SanphamService;

/**
 *
 * @author Lenovo
 */
public class BookFrame extends javax.swing.JFrame {

	/**
	 * Creates new form BookFrame
	 */
	private SecurityManager securityManager;
	private SanphamService sanphamDao;
	int chucnang = 0;
	String path = "";
	byte[] hinhanh = null;

	public BookFrame() {
		initComponents();
		this.setLocationRelativeTo(null);
		this.securityManager = System.getSecurityManager();
		if (this.securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			sanphamDao = (SanphamService) Naming.lookup("rmi://192.168.1.6:1099/sanphamService");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		disabled();
		showProduct();
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

        panelQuanLySP = new javax.swing.JPanel();
        labelQLSP = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnThoat = new javax.swing.JButton();
        labelHinhAnh = new javax.swing.JLabel();
        labelMaSP = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        labelTenSP = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        labelDonGia = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        labelSoLuongTon = new javax.swing.JLabel();
        txtSoLuongTon = new javax.swing.JTextField();
        labelTrangThai = new javax.swing.JLabel();
        txtTrangThai = new javax.swing.JTextField();
        labelMaNCC = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtTenSPTimKiem = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        labelTenSPTimKiem = new javax.swing.JLabel();
        labelLoaiSP = new javax.swing.JLabel();
        btnChonanh = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        cbLoaiSanpham = new javax.swing.JComboBox<>();
        cbNhacungcap = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSP = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelQuanLySP.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        labelQLSP.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelQLSP.setText("QUẢN LÝ DỤNG CỤ HỌC TẬP");

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

        labelMaSP.setText("Mã sản phẩm");

        labelTenSP.setText("Tên sản phẩm");

        labelDonGia.setText("Đơn giá");

        labelSoLuongTon.setText("Sô lượng tồn");

        labelTrangThai.setText("Trạng thái");

        labelMaNCC.setText("Mã nhà cung cấp");

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
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnReset.setText("Quay lại");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        labelTenSPTimKiem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTenSPTimKiem.setText("Tên Sản Phẩm");

        labelLoaiSP.setText("Loại sản phẩm");

        btnChonanh.setText("Chọn ảnh");
        btnChonanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonanhActionPerformed(evt);
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

        cbLoaiSanpham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLoaiSanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLoaiSanphamActionPerformed(evt);
            }
        });

        cbNhacungcap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelQuanLySPLayout = new javax.swing.GroupLayout(panelQuanLySP);
        panelQuanLySP.setLayout(panelQuanLySPLayout);
        panelQuanLySPLayout.setHorizontalGroup(
            panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelQuanLySPLayout.createSequentialGroup()
                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                        .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                        .addComponent(labelLoaiSP)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbLoaiSanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                        .addComponent(labelDonGia)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                        .addComponent(labelMaNCC)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbNhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(168, 168, 168)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                        .addComponent(labelMaSP)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                        .addComponent(labelSoLuongTon)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 255, Short.MAX_VALUE))
                            .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnChonanh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQuanLySPLayout.createSequentialGroup()
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                        .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(txtTenSPTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(labelTenSPTimKiem))))
                            .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQuanLySPLayout.createSequentialGroup()
                                    .addComponent(labelTenSP)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQuanLySPLayout.createSequentialGroup()
                                    .addComponent(labelTrangThai)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(48, Short.MAX_VALUE))))
            .addGroup(panelQuanLySPLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnThoat)
                .addGap(310, 310, 310)
                .addComponent(labelQLSP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelQuanLySPLayout.setVerticalGroup(
            panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuanLySPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThoat)
                    .addComponent(labelQLSP))
                .addGap(23, 23, 23)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                        .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(labelMaSP)
                            .addComponent(txtMaSP)
                            .addComponent(labelTenSP)
                            .addComponent(txtTenSP)
                            .addComponent(labelLoaiSP)
                            .addComponent(cbLoaiSanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDonGia)
                            .addComponent(txtDonGia)
                            .addComponent(labelSoLuongTon)
                            .addComponent(txtSoLuongTon)
                            .addComponent(labelTrangThai)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMaNCC)
                            .addComponent(cbNhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                        .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTim, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQuanLySPLayout.createSequentialGroup()
                                .addComponent(labelTenSPTimKiem)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenSPTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSua)
                            .addComponent(btnLuu)
                            .addComponent(btnReset)
                            .addComponent(btnXoa)
                            .addComponent(btnThem)))
                    .addComponent(btnChonanh))
                .addContainerGap())
        );

        tableSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Loại sản phẩm", "Nhà cung cấp", "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng tồn", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelQuanLySP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelQuanLySP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSPMouseClicked
        // TODO add your handling code here:
    	mouseClickTableSanpham();
    }//GEN-LAST:event_tableSPMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
       try {
		deleteSanpham(Integer.parseInt(txtMaSP.getText().toString()));
	} catch (HeadlessException | NumberFormatException | RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }//GEN-LAST:event_btnXoaActionPerformed

	private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThoatActionPerformed
		dispose();
		new HomeFrame().setVisible(true);
	}// GEN-LAST:event_btnThoatActionPerformed

	private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuaActionPerformed
		chucnang =2;
		btnThem.setEnabled(false);
		btnLuu.setEnabled(true);
		enabled();
	}// GEN-LAST:event_btnSuaActionPerformed

	private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLuuActionPerformed
		if(chucnang ==1 ) {
			try {
				insertSanpham();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (chucnang == 2) {
			try {
				updateSanpham();
			} catch (HeadlessException | RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		refesh();
		disabled();
	}// GEN-LAST:event_btnLuuActionPerformed

	private void btnInActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInActionPerformed

	}// GEN-LAST:event_btnInActionPerformed

	private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnResetActionPerformed
		refesh();
	}// GEN-LAST:event_btnResetActionPerformed

	private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTimActionPerformed
		// TODO add your handling code here:
		String tukhoa = txtTenSPTimKiem.getText();
		try {
			List<Sanpham> dsSanpham = sanphamDao.getDodunghoctap(tukhoa);
			if(dsSanpham.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm!");
			}
			DefaultTableModel model = new DefaultTableModel(new Object[] { "Loại sản phẩm", "Nhà cung cấp",
					"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng tồn", "Trạng thái" }, 0);
			for (Sanpham sanpham : dsSanpham) {
				Object[] obj = { sanpham.getLoaisanpham().getTenloaisp(), sanpham.getNhacungcap().getTenNhaCC(),
						sanpham.getId(), sanpham.getTenSanpham(), sanpham.getDongia(),sanpham.getSoluongton(), sanpham.getTrangthai() };
				model.addRow(obj);
			}
			tableSP.setModel(model);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// GEN-LAST:event_btnTimActionPerformed

	private void btnChonanhActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChonanhActionPerformed
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		chooser.setDialogTitle("Chọn ảnh");

		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg", "png");
		chooser.addChoosableFileFilter(filter);

		int result = chooser.showSaveDialog(null);
		File file = chooser.getSelectedFile();
		String filename = file.getName();
		if (filename.endsWith(".jpg") || filename.endsWith(".JPG") || filename.endsWith(".png")
				|| filename.endsWith(".PNG")) {
			if (result == JFileChooser.APPROVE_OPTION) {
				path = file.getAbsolutePath();
				ImageIcon imgIcon = new ImageIcon(path);
				Image img = imgIcon.getImage();

				Image newImg = img.getScaledInstance(labelHinhAnh.getWidth(), labelHinhAnh.getHeight(),
						Image.SCALE_SMOOTH);

				ImageIcon icon = new ImageIcon(newImg);
				labelHinhAnh.setIcon(icon);
				hinhanh = null;
			}
		} else
			JOptionPane.showMessageDialog(this, "Chọn sai tệp, vui lòng chọn tệp hình ảnh");
	}// GEN-LAST:event_btnChonanhActionPerformed

	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
		int yes = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm sản phẩm mới", "Hỏi nhắc", JOptionPane.YES_NO_CANCEL_OPTION);
		if(yes == JOptionPane.YES_OPTION) {
			 chucnang =1;
			 btnLuu.setEnabled(true);
			 btnSua.setEnabled(false);
			 btnXoa.setEnabled(false);
			 labelHinhAnh.setIcon(null);
			 enabled();
		}
	}// GEN-LAST:event_btnThemActionPerformed

	private void cbLoaiSanphamActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbLoaiSanphamActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_cbLoaiSanphamActionPerformed

	
	
	
	/**
	 * @throws RemoteException 
	 * @throws HeadlessException 
	 * 
	 */
	private void updateSanpham() throws RemoteException, HeadlessException {
		Sanpham sanpham = new Sanpham();
		String tenLoaiSP = cbLoaiSanpham.getSelectedItem().toString();
		String tenNhaCC = cbNhacungcap.getSelectedItem().toString();
		List<LoaiSanpham> dsLoaiSanpham = sanphamDao.getLoaiSanphams();
		List<Nhacungcap> dsNhacungcap = sanphamDao.getNhacungcapServices();
		
		for(LoaiSanpham lsp : dsLoaiSanpham) {
			if(lsp.getTenloaisp().equals(tenLoaiSP)) {
				sanpham.setLoaisanpham(new LoaiSanpham(lsp.getId(), lsp.getTenloaisp()));
			}
		}
		for (Nhacungcap nhacungcap : dsNhacungcap) {
			if(nhacungcap.getTenNhaCC().equals(tenNhaCC)) {
				sanpham.setNhacungcap(new Nhacungcap(nhacungcap.getId(), nhacungcap.getTenNhaCC(), nhacungcap.getDiachi()));
			}
		}

		sanpham.setId(Integer.parseInt(txtMaSP.getText().trim()));
		sanpham.setTenSanpham(txtTenSP.getText().trim());
		sanpham.setDongia(Double.parseDouble(txtDonGia.getText().trim()));
		sanpham.setSoluongton(Integer.parseInt(txtSoLuongTon.getText().trim()));
		sanpham.setTrangthai(txtTrangThai.getText());

		if (hinhanh != null) {
			sanpham.setHinhanh(hinhanh);
		} else {
			File file = new File(path);
			byte[] hinhanh = new byte[(int) file.length()];
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				fileInputStream.read(hinhanh);
				fileInputStream.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			sanpham.setHinhanh(hinhanh);
		}
		if (sanphamDao.updateSanpham(sanpham)) {
			JOptionPane.showMessageDialog(this, "Sản phẩm đã được cập nhật thành công!");
		} else {
			JOptionPane.showMessageDialog(this, "Sản phẩm không cập nhật thành công!\nVui lòng kiểm tra lại");
		}
	}
	
	
	
	
	
	/**
	 * @param args the command line arguments
	 * @throws RemoteException 
	 * @throws HeadlessException 
	 */
	
	
	private void deleteSanpham(int id) throws HeadlessException, RemoteException {
		int yes = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sản phẩm này?", "Cảnh báo",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (yes == JOptionPane.YES_OPTION) {
			if (sanphamDao.deleteSanpham(id)) {
				JOptionPane.showMessageDialog(this, "Sản phẩm được xóa thành công!");
			} else {
				JOptionPane.showMessageDialog(this, "Sản phẩm xóa không thành công!\nVui lòng kiểm tra lại");
			}
		}
		refesh();
		disabled();
	}
	

	/**
	 * Them san pham
	 * @throws RemoteException
	 */
	private void insertSanpham() throws RemoteException {
		String tenLoaiSP = cbLoaiSanpham.getSelectedItem().toString();
		String tenNhaCC = cbNhacungcap.getSelectedItem().toString();
		Sanpham sanpham = new Sanpham();
		List<LoaiSanpham> dsLoaiSanpham = sanphamDao.getLoaiSanphams();
		List<Nhacungcap> dsNhacungcap = sanphamDao.getNhacungcapServices();
		
		for(LoaiSanpham lsp : dsLoaiSanpham) {
			if(lsp.getTenloaisp().equals(tenLoaiSP)) {
				sanpham.setLoaisanpham(new LoaiSanpham(lsp.getId(), lsp.getTenloaisp()));
			}
		}
		for (Nhacungcap nhacungcap : dsNhacungcap) {
			if(nhacungcap.getTenNhaCC().equals(tenNhaCC)) {
				sanpham.setNhacungcap(new Nhacungcap(nhacungcap.getId(), nhacungcap.getTenNhaCC(), nhacungcap.getDiachi()));
			}
		}
		if (Integer.parseInt(txtSoLuongTon.getText().trim()) > 0) {
			txtTrangThai.setText("Còn hàng");
		} else {
			txtTrangThai.setText("Hết hàng");
		}
		sanpham.setTenSanpham(txtTenSP.getText().trim());
		sanpham.setDongia(Double.parseDouble(txtDonGia.getText().trim()));
		sanpham.setSoluongton(Integer.parseInt(txtSoLuongTon.getText().trim()));
		sanpham.setTrangthai(txtTrangThai.getText());	
		File file = new File(path);
		byte[] hinhanh = new byte[(int) file.length()];
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(hinhanh);
			fileInputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sanpham.setHinhanh(hinhanh);
		if (sanphamDao.insertSanpham(sanpham)) {
			JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!!");
			showProduct();
		} else {
			JOptionPane.showMessageDialog(this, "Thêm không thành công! Vui lòng kiểm tra lại");
		}
		
	}
	/**
	 * Refesh
	 * 
	 */
	
	
	private void refesh() {
		disabled();
		btnThem.setEnabled(true);
		txtDonGia.setText("");
		txtMaSP.setText("");
		txtSoLuongTon.setText("");
		txtSoLuongTon.setText("");
		txtTenSP.setText("");
		txtTenSPTimKiem.setText("");
		txtTrangThai.setText("");
		cbLoaiSanpham.setSelectedIndex(0);
		cbNhacungcap.setSelectedIndex(0);
		labelHinhAnh.setIcon(null);
		showProduct();
	}
	
	
	/**
	 * Mouse Click TabelSanpham
	 */
	private void mouseClickTableSanpham() {

		int click = tableSP.getSelectedRow();
		TableModel tableModel = tableSP.getModel();
		cbLoaiSanpham.setSelectedItem(tableModel.getValueAt(click, 0).toString());
		txtMaSP.setText(tableModel.getValueAt(click, 2).toString());
		txtTenSP.setText(tableSP.getValueAt(click, 3).toString());
		txtDonGia.setText(tableModel.getValueAt(click, 4).toString());
		txtSoLuongTon.setText(tableModel.getValueAt(click, 5).toString());
		if (Integer.parseInt(tableModel.getValueAt(click, 5).toString()) > 0) {
			txtTrangThai.setText("Còn hàng");
		} else
			txtTrangThai.setText("Hết hàng");
		cbNhacungcap.setSelectedItem(tableModel.getValueAt(click, 1).toString());
		btnSua.setEnabled(true);
		btnXoa.setEnabled(true);
		try {
			Sanpham sanpham = sanphamDao.getSanphamById(Integer.parseInt(tableModel.getValueAt(click, 2).toString()));
			hinhanh = sanpham.getHinhanh();
			ImageIcon icon = new ImageIcon(hinhanh);
			Image img = icon.getImage();
			Image newImg = img.getScaledInstance(labelHinhAnh.getWidth(), labelHinhAnh.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon imgIcon = new ImageIcon(newImg);
			labelHinhAnh.setIcon(imgIcon);
		} catch (NumberFormatException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * enebles
	 */
	
	private void enabled() {
		txtDonGia.setEnabled(true);
		txtSoLuongTon.setEnabled(true);
		txtTenSP.setEnabled(true);
		txtTenSPTimKiem.setEnabled(true);
		btnChonanh.setEnabled(true);
		cbLoaiSanpham.setEnabled(true);
		cbNhacungcap.setEnabled(true);
	}

	/**
	 * disabled
	 */
	private void disabled() {
		txtDonGia.setEnabled(false);
		txtMaSP.setEnabled(false);
		txtSoLuongTon.setEnabled(false);
		txtTenSP.setEnabled(false);
		txtTrangThai.setEnabled(false);
		btnLuu.setEnabled(false);
		btnSua.setEnabled(false);
		btnChonanh.setEnabled(false);
		btnXoa.setEnabled(false);
		cbLoaiSanpham.setEnabled(false);
		cbNhacungcap.setEnabled(false);

	}

	/**
	 * Hien thi san pham
	 */
	private void showProduct() {
		try {
			cbLoaiSanpham.removeAllItems();
			cbNhacungcap.removeAllItems();
			List<LoaiSanpham> dsLoaisp = sanphamDao.getLoaiSanphams();
			List<Nhacungcap> dsNhaCC = sanphamDao.getNhacungcapServices();
			for (LoaiSanpham loaisp : dsLoaisp) {
				cbLoaiSanpham.addItem(loaisp.getTenloaisp());

			}
			for (Nhacungcap nhacc : dsNhaCC) {
				cbNhacungcap.addItem(nhacc.getTenNhaCC());
			}

			DefaultTableModel model = new DefaultTableModel(new Object[] { "Loại sản phẩm", "Nhà cung cấp",
					"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng tồn", "Trạng thái" }, 0);
			List<Sanpham> dsSanpham = sanphamDao.getSanpham();
			for (Sanpham sanpham : dsSanpham) {
				Object[] obj = { sanpham.getLoaisanpham().getTenloaisp(), sanpham.getNhacungcap().getTenNhaCC(),
						sanpham.getId(), sanpham.getTenSanpham(), sanpham.getDongia(),sanpham.getSoluongton(), sanpham.getTrangthai() };
				model.addRow(obj);
			}
			tableSP.setModel(model);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

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
			java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new BookFrame().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonanh;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbLoaiSanpham;
    private javax.swing.JComboBox<String> cbNhacungcap;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelDonGia;
    private javax.swing.JLabel labelHinhAnh;
    private javax.swing.JLabel labelLoaiSP;
    private javax.swing.JLabel labelMaNCC;
    private javax.swing.JLabel labelMaSP;
    private javax.swing.JLabel labelQLSP;
    private javax.swing.JLabel labelSoLuongTon;
    private javax.swing.JLabel labelTenSP;
    private javax.swing.JLabel labelTenSPTimKiem;
    private javax.swing.JLabel labelTrangThai;
    private javax.swing.JPanel panelQuanLySP;
    private javax.swing.JTable tableSP;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenSPTimKiem;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
