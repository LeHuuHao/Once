/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jmaster.io.view;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jmaster.io.model.MatHang;
import jmaster.io.model.Oto;
import jmaster.io.service.MatHangService;
import jmaster.io.utils.IDGenerator;
import jmaster.io.utils.Validator;

/**
 *
 * @author dinhd
 */
public class DanhSachMatHangView extends javax.swing.JFrame {

    /**
     * Creates new form DanhSachMatHang
     */
    public DanhSachMatHangView() {
        initComponents();
        initScreen();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rowPopupMenu = new javax.swing.JPopupMenu();
        deleteMenuItem = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        mhTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        maOtotxt = new javax.swing.JTextField();
        themMHBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        maOtotxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        giaThueTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        soLuongXeTxt = new javax.swing.JTextField();
        nhomHangComboBox = new javax.swing.JComboBox<>();

        deleteMenuItem.setText("Xoa");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        rowPopupMenu.add(deleteMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mhTable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        mhTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        mhTable.setComponentPopupMenu(rowPopupMenu);
        mhTable.setEditingRow(0);
        mhTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(mhTable);

        backBtn.setBackground(new java.awt.Color(255, 153, 153));
        backBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        backBtn.setText("Quay ve");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        refreshBtn.setBackground(new java.awt.Color(153, 204, 255));
        refreshBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Nhom xe");

        maOtotxt.setEditable(false);
        maOtotxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        themMHBtn.setBackground(new java.awt.Color(153, 204, 255));
        themMHBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        themMHBtn.setText("Them Oto");
        themMHBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themMHBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Kieu xe");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Ma oto");

        maOtotxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Gia thue");
       
        giaThueTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("so luong xe");
        
        soLuongXeTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        nhomHangComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        nhomHangComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "xe ban tai", "xe sedan", "xe suv", "xe tai" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(giaThueTxt)
                    .addComponent(nhomHangComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(themMHBtn)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(maOtotxt, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(maOtotxt, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(47, 47, 47)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(maOtotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nhomHangComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(giaThueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(themMHBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(maOtotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(286, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshBtn)
                        .addGap(18, 18, 18)
                        .addComponent(backBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(refreshBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        new MainView().setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        refreshData();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void themMHBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themMHBtnActionPerformed
        themMatHang();
    }//GEN-LAST:event_themMHBtnActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
        // TODO add your handling code here:
        deleteItem();
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JTextField giaThueTxt;
    private javax.swing.JTextField soLuongXeTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField maOtotxt;//maHangTxt
    private javax.swing.JTable mhTable;
    private javax.swing.JComboBox<String> nhomHangComboBox;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JPopupMenu rowPopupMenu;
//    private javax.swing.JTextField tenOtotxt;//tenMH
    private javax.swing.JButton themMHBtn;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel tableModel = new DefaultTableModel();
    private MatHangService matHangService = new MatHangService();

    private void initScreen() {
        mhTable.setModel(tableModel);
        //set ten cot
        tableModel.addColumn("ma oto");
        tableModel.addColumn("kieu xe");
        tableModel.addColumn("so tien thue");
        tableModel.addColumn("so luong xe");
        //set du lieu
        refreshData();

        //set ID mac dinh
        maOtotxt.setText(String.valueOf(IDGenerator.getMHID()));
    }

    private void refreshData() {
        try {
            tableModel.setRowCount(0);//xoa du lieu cu
            ArrayList<Oto> matHangList= matHangService.findAll();

            for (Oto oto : matHangList) {
                tableModel.addRow(new Object[]{
                    oto.getMaOto(),
                    oto.getKieuXe(),
                    oto.getSoTienThue(),
                    oto.getSoXe()
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(DanhSachMatHangView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Loi du lieu", "Loi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void themMatHang() {
    	Oto oto = new Oto();

        oto.setMaOto(Integer.parseInt(maOtotxt.getText()));

        String kieuXe = maOtotxt.getText();
        if (Validator.isRequiredString(kieuXe)) {
            oto.setKieuXe(kieuXe);
        } else {
            JOptionPane.showMessageDialog(this, "Vui long nhap lai", "Loi", JOptionPane.ERROR_MESSAGE);
            return;//ko cho chay tiep
        }

        oto.setKieuXe(nhomHangComboBox.getSelectedItem().toString());

        String giaBanStr = giaThueTxt.getText();

        if (Validator.isValidInteger(giaBanStr)) {
            oto.setSoTienThue(Integer.parseInt(giaBanStr));
        } else {
            JOptionPane.showMessageDialog(this, "Vui long nhap lai", "Loi", JOptionPane.ERROR_MESSAGE);
            return;//ko cho chay tiep
        }

        try {
            matHangService.create(oto);

            //reload lai data
            refreshData();
            //set ID mac dinh
            maOtotxt.setText(String.valueOf(IDGenerator.getMHID()));
        } catch (Exception ex) {
            Logger.getLogger(DanhSachMatHangView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Loi du lieu", "Loi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteItem() {
        int selectedRow = mhTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui long nhap laij", "Loi", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Ban chac chan muon dat hang ko");
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    //lay cot so 0 cua dong duoc chon chinh la cot MaKH
                    int maHang = (Integer) mhTable.getValueAt(selectedRow, 0);
                    matHangService.delete(maHang);

                    //reload lai data
                    refreshData();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Loi doc du lieu", "Loi", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
