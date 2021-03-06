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
public class HomeFrame extends javax.swing.JFrame {

    /**
     * Creates new form HomeFrame
     */
    public HomeFrame() {
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

        panelManHinhChinh = new javax.swing.JPanel();
        labelManHinhChinh = new javax.swing.JLabel();
        btnQuanLySP = new javax.swing.JButton();
        btnQuanLyDH = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        btnQuanLyNV = new javax.swing.JButton();
        btnBanHang = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnCapNhatNCC = new javax.swing.JButton();
        btnCapNhatLSP = new javax.swing.JButton();
        btnThongKeSP = new javax.swing.JButton();
        labelHoTenNV = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnThongKeDT = new javax.swing.JButton();
        panelDongHo = new javax.swing.JPanel();
        labelDongHo = new javax.swing.JLabel();
        btnChamCong = new javax.swing.JButton();
        labelvalueTenNV = new javax.swing.JLabel();
        menuBarHome = new javax.swing.JMenuBar();
        mnuDanhMuc = new javax.swing.JMenu();
        mnuItemSP = new javax.swing.JMenuItem();
        mnuItemDH = new javax.swing.JMenuItem();
        mnuItemNV = new javax.swing.JMenuItem();
        mnuItemLSP = new javax.swing.JMenuItem();
        mnuItemNCC = new javax.swing.JMenuItem();
        mnuTmKiem = new javax.swing.JMenu();
        mnuItemTKSP = new javax.swing.JMenuItem();
        mnuItemTKHD = new javax.swing.JMenuItem();
        mnuItemTKDH = new javax.swing.JMenuItem();
        mnuItemTKNCC = new javax.swing.JMenuItem();
        mnuitemTKLSP = new javax.swing.JMenuItem();
        mnuXuLy = new javax.swing.JMenu();
        mnuItemChamCong = new javax.swing.JMenuItem();
        mnuItemBanHang = new javax.swing.JMenuItem();
        mnuItemDoiMatKhau = new javax.swing.JMenuItem();
        mnuItemDatHang = new javax.swing.JMenuItem();
        mnuThongKe = new javax.swing.JMenu();
        mnuItemThongKeSP = new javax.swing.JMenuItem();
        mnuItemThongKeDT = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelManHinhChinh.setBackground(new java.awt.Color(204, 255, 204));
        panelManHinhChinh.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        labelManHinhChinh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelManHinhChinh.setForeground(new java.awt.Color(102, 102, 102));
        labelManHinhChinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bookstore.png"))); // NOI18N
        labelManHinhChinh.setText("QU???N L?? HI???U S??CH");

        btnQuanLySP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnQuanLySP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/product.png"))); // NOI18N
        btnQuanLySP.setText("Qu???n l?? s???n ph???m");
        btnQuanLySP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuanLySP.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQuanLySP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLySPActionPerformed(evt);
            }
        });

        btnQuanLyDH.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnQuanLyDH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trolley.png"))); // NOI18N
        btnQuanLyDH.setText("Qu???n l?? ????n h??ng");
        btnQuanLyDH.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuanLyDH.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQuanLyDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyDHActionPerformed(evt);
            }
        });

        btnDangXuat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout.png"))); // NOI18N
        btnDangXuat.setText("????ng xu???t");
        btnDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDangXuat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnQuanLyNV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnQuanLyNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/best-employee.png"))); // NOI18N
        btnQuanLyNV.setText("Qu???n L?? nh??n vi??n");
        btnQuanLyNV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuanLyNV.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQuanLyNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyNVActionPerformed(evt);
            }
        });

        btnBanHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/money.png"))); // NOI18N
        btnBanHang.setText("B??n H??ng");
        btnBanHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBanHang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/multiply-1.png"))); // NOI18N
        btnThoat.setText("Tho??t");
        btnThoat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThoat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnCapNhatNCC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCapNhatNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/producer.png"))); // NOI18N
        btnCapNhatNCC.setText("C???p nh???t nh?? cung c???p");
        btnCapNhatNCC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCapNhatNCC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCapNhatNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatNCCActionPerformed(evt);
            }
        });

        btnCapNhatLSP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCapNhatLSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/update.png"))); // NOI18N
        btnCapNhatLSP.setText("C???p nh???t lo???i s???n ph???m");
        btnCapNhatLSP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCapNhatLSP.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCapNhatLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatLSPActionPerformed(evt);
            }
        });

        btnThongKeSP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThongKeSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/product-statistics.png"))); // NOI18N
        btnThongKeSP.setText("Th???ng k?? s???n ph???m");
        btnThongKeSP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThongKeSP.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThongKeSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeSPActionPerformed(evt);
            }
        });

        labelHoTenNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelHoTenNV.setText("Nh??n vi??n: ");

        btnThongKeDT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThongKeDT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/analytics.png"))); // NOI18N
        btnThongKeDT.setText("Th???ng k?? doanh thu");
        btnThongKeDT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThongKeDT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThongKeDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeDTActionPerformed(evt);
            }
        });

        panelDongHo.setBackground(new java.awt.Color(153, 255, 153));

        labelDongHo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelDongHo.setForeground(new java.awt.Color(0, 0, 204));
        labelDongHo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDongHo.setText("7:40:00 AM");
        labelDongHo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panelDongHoLayout = new javax.swing.GroupLayout(panelDongHo);
        panelDongHo.setLayout(panelDongHoLayout);
        panelDongHoLayout.setHorizontalGroup(
            panelDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDongHoLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(labelDongHo, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panelDongHoLayout.setVerticalGroup(
            panelDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDongHoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDongHo, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnChamCong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnChamCong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/attendance.png"))); // NOI18N
        btnChamCong.setText("Ch???m c??ng");
        btnChamCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChamCongActionPerformed(evt);
            }
        });

        labelvalueTenNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelvalueTenNV.setText("value t??n nh??n vi??n");

        javax.swing.GroupLayout panelManHinhChinhLayout = new javax.swing.GroupLayout(panelManHinhChinh);
        panelManHinhChinh.setLayout(panelManHinhChinhLayout);
        panelManHinhChinhLayout.setHorizontalGroup(
            panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManHinhChinhLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelManHinhChinhLayout.createSequentialGroup()
                        .addGroup(panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQuanLyNV, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelManHinhChinhLayout.createSequentialGroup()
                                .addComponent(btnThongKeDT, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThongKeSP, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelManHinhChinhLayout.createSequentialGroup()
                                .addComponent(btnCapNhatNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnQuanLyDH, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(63, 63, 63)
                        .addGroup(panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCapNhatLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuanLySP, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelManHinhChinhLayout.createSequentialGroup()
                        .addComponent(labelManHinhChinh)
                        .addGap(271, 271, 271)
                        .addGroup(panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(panelManHinhChinhLayout.createSequentialGroup()
                                .addGroup(panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelManHinhChinhLayout.createSequentialGroup()
                                        .addComponent(labelHoTenNV)
                                        .addGap(28, 28, 28)
                                        .addComponent(labelvalueTenNV))
                                    .addGroup(panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panelDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelManHinhChinhLayout.setVerticalGroup(
            panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelManHinhChinhLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelManHinhChinh)
                    .addGroup(panelManHinhChinhLayout.createSequentialGroup()
                        .addGroup(panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelHoTenNV)
                            .addComponent(labelvalueTenNV))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(panelDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelManHinhChinhLayout.createSequentialGroup()
                        .addGroup(panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapNhatNCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelManHinhChinhLayout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addGroup(panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelManHinhChinhLayout.createSequentialGroup()
                                .addComponent(btnQuanLyDH, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btnThongKeSP, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnQuanLyNV, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelManHinhChinhLayout.createSequentialGroup()
                                .addGroup(panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCapNhatLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnQuanLySP, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(panelManHinhChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnThongKeDT, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(29, Short.MAX_VALUE))))
        );

        mnuDanhMuc.setText("Danh m???c");

        mnuItemSP.setText("S???n ph???m");
        mnuItemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemSPActionPerformed(evt);
            }
        });
        mnuDanhMuc.add(mnuItemSP);

        mnuItemDH.setText("????n h??ng");
        mnuItemDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemDHActionPerformed(evt);
            }
        });
        mnuDanhMuc.add(mnuItemDH);

        mnuItemNV.setText("Nh??n vi??n");
        mnuItemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemNVActionPerformed(evt);
            }
        });
        mnuDanhMuc.add(mnuItemNV);

        mnuItemLSP.setText("Lo???i s???n ph???m");
        mnuItemLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemLSPActionPerformed(evt);
            }
        });
        mnuDanhMuc.add(mnuItemLSP);

        mnuItemNCC.setText("Nh?? cung c???p");
        mnuItemNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemNCCActionPerformed(evt);
            }
        });
        mnuDanhMuc.add(mnuItemNCC);

        menuBarHome.add(mnuDanhMuc);

        mnuTmKiem.setText("T??m ki???m");

        mnuItemTKSP.setText("T??m ki???m s???n ph???m");
        mnuItemTKSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemTKSPActionPerformed(evt);
            }
        });
        mnuTmKiem.add(mnuItemTKSP);

        mnuItemTKHD.setText("T??m ki???m h??a ????n");
        mnuItemTKHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemTKHDActionPerformed(evt);
            }
        });
        mnuTmKiem.add(mnuItemTKHD);

        mnuItemTKDH.setText("T??m ki???m ????n h??ng");
        mnuItemTKDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemTKDHActionPerformed(evt);
            }
        });
        mnuTmKiem.add(mnuItemTKDH);

        mnuItemTKNCC.setText("T??m ki???m nh?? cung c???p");
        mnuItemTKNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemTKNCCActionPerformed(evt);
            }
        });
        mnuTmKiem.add(mnuItemTKNCC);

        mnuitemTKLSP.setText("T??m ki???m lo???i s???n ph???m");
        mnuitemTKLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuitemTKLSPActionPerformed(evt);
            }
        });
        mnuTmKiem.add(mnuitemTKLSP);

        menuBarHome.add(mnuTmKiem);

        mnuXuLy.setText("X??? l??");

        mnuItemChamCong.setText("Ch???m c??ng");
        mnuItemChamCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemChamCongActionPerformed(evt);
            }
        });
        mnuXuLy.add(mnuItemChamCong);

        mnuItemBanHang.setText("B??n h??ng");
        mnuItemBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemBanHangActionPerformed(evt);
            }
        });
        mnuXuLy.add(mnuItemBanHang);

        mnuItemDoiMatKhau.setText("?????i m???t kh???u");
        mnuItemDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemDoiMatKhauActionPerformed(evt);
            }
        });
        mnuXuLy.add(mnuItemDoiMatKhau);

        mnuItemDatHang.setText("?????t h??ng");
        mnuItemDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemDatHangActionPerformed(evt);
            }
        });
        mnuXuLy.add(mnuItemDatHang);

        menuBarHome.add(mnuXuLy);

        mnuThongKe.setText("Th???ng k??");

        mnuItemThongKeSP.setText("Th???ng k?? s???n ph???m");
        mnuItemThongKeSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemThongKeSPActionPerformed(evt);
            }
        });
        mnuThongKe.add(mnuItemThongKeSP);

        mnuItemThongKeDT.setText("Th???ng k?? doanh thu");
        mnuItemThongKeDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemThongKeDTActionPerformed(evt);
            }
        });
        mnuThongKe.add(mnuItemThongKeDT);

        menuBarHome.add(mnuThongKe);

        setJMenuBar(menuBarHome);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelManHinhChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelManHinhChinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuanLySPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLySPActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnQuanLySPActionPerformed

    private void btnQuanLyDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyDHActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnQuanLyDHActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code her
        
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnQuanLyNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyNVActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnQuanLyNVActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnCapNhatNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatNCCActionPerformed
        // TODO add your handling code here:
       
      
    }//GEN-LAST:event_btnCapNhatNCCActionPerformed

    private void btnCapNhatLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatLSPActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnCapNhatLSPActionPerformed

    private void btnThongKeSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeSPActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnThongKeSPActionPerformed

    private void btnThongKeDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeDTActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnThongKeDTActionPerformed

    private void btnChamCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamCongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChamCongActionPerformed

    private void mnuItemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemSPActionPerformed
       

    }//GEN-LAST:event_mnuItemSPActionPerformed

    private void mnuItemDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemDHActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mnuItemDHActionPerformed

    private void mnuItemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemNVActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_mnuItemNVActionPerformed

    private void mnuItemLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemLSPActionPerformed
        // TODO add your handling code here:
       

    }//GEN-LAST:event_mnuItemLSPActionPerformed

    private void mnuItemNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemNCCActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_mnuItemNCCActionPerformed

    private void mnuItemTKSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemTKSPActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_mnuItemTKSPActionPerformed

    private void mnuItemTKHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemTKHDActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_mnuItemTKHDActionPerformed

    private void mnuItemTKDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemTKDHActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_mnuItemTKDHActionPerformed

    private void mnuItemTKNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemTKNCCActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_mnuItemTKNCCActionPerformed

    private void mnuitemTKLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuitemTKLSPActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_mnuitemTKLSPActionPerformed

    private void mnuItemChamCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemChamCongActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_mnuItemChamCongActionPerformed

    private void mnuItemBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemBanHangActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_mnuItemBanHangActionPerformed

    private void mnuItemDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemDoiMatKhauActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_mnuItemDoiMatKhauActionPerformed

    private void mnuItemDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemDatHangActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mnuItemDatHangActionPerformed

    private void mnuItemThongKeSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemThongKeSPActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mnuItemThongKeSPActionPerformed

    private void mnuItemThongKeDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemThongKeDTActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_mnuItemThongKeDTActionPerformed

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
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnCapNhatLSP;
    private javax.swing.JButton btnCapNhatNCC;
    private javax.swing.JButton btnChamCong;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnQuanLyDH;
    private javax.swing.JButton btnQuanLyNV;
    private javax.swing.JButton btnQuanLySP;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThongKeDT;
    private javax.swing.JButton btnThongKeSP;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelDongHo;
    private javax.swing.JLabel labelHoTenNV;
    private javax.swing.JLabel labelManHinhChinh;
    private javax.swing.JLabel labelvalueTenNV;
    private javax.swing.JMenuBar menuBarHome;
    private javax.swing.JMenu mnuDanhMuc;
    private javax.swing.JMenuItem mnuItemBanHang;
    private javax.swing.JMenuItem mnuItemChamCong;
    private javax.swing.JMenuItem mnuItemDH;
    private javax.swing.JMenuItem mnuItemDatHang;
    private javax.swing.JMenuItem mnuItemDoiMatKhau;
    private javax.swing.JMenuItem mnuItemLSP;
    private javax.swing.JMenuItem mnuItemNCC;
    private javax.swing.JMenuItem mnuItemNV;
    private javax.swing.JMenuItem mnuItemSP;
    private javax.swing.JMenuItem mnuItemTKDH;
    private javax.swing.JMenuItem mnuItemTKHD;
    private javax.swing.JMenuItem mnuItemTKNCC;
    private javax.swing.JMenuItem mnuItemTKSP;
    private javax.swing.JMenuItem mnuItemThongKeDT;
    private javax.swing.JMenuItem mnuItemThongKeSP;
    private javax.swing.JMenu mnuThongKe;
    private javax.swing.JMenu mnuTmKiem;
    private javax.swing.JMenu mnuXuLy;
    private javax.swing.JMenuItem mnuitemTKLSP;
    private javax.swing.JPanel panelDongHo;
    private javax.swing.JPanel panelManHinhChinh;
    // End of variables declaration//GEN-END:variables
}
