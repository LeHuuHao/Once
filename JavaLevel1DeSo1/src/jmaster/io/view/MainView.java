/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jmaster.io.view;

/**
 *
 * @author dinhd
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public MainView() {
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

        mainPanel = new javax.swing.JPanel();
        themMHBtn = new javax.swing.JButton();
        themKHBtn = new javax.swing.JButton();
        dsmhBtn = new javax.swing.JButton();
        hoaDonBtn = new javax.swing.JButton();
        quitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quan ly thue xe");
        setMinimumSize(new java.awt.Dimension(500, 500));

        mainPanel.setMinimumSize(new java.awt.Dimension(300, 300));

        themMHBtn.setBackground(new java.awt.Color(102, 204, 255));
        themMHBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        themMHBtn.setText("Mat hang");
        themMHBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themMHBtnActionPerformed(evt);
            }
        });

        themKHBtn.setBackground(new java.awt.Color(102, 204, 255));
        themKHBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        themKHBtn.setText("Khach hang");
        themKHBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themKHBtnActionPerformed(evt);
            }
        });

        dsmhBtn.setBackground(new java.awt.Color(102, 204, 255));
        dsmhBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        dsmhBtn.setText("Danh sach mua hang");
        dsmhBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dsmhBtnActionPerformed(evt);
            }
        });

        hoaDonBtn.setBackground(new java.awt.Color(102, 204, 255));
        hoaDonBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        hoaDonBtn.setText("Hoa don");
        hoaDonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoaDonBtnActionPerformed(evt);
            }
        });

        quitBtn.setBackground(new java.awt.Color(255, 153, 153));
        quitBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        quitBtn.setText("Thoat");
        quitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dsmhBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(themMHBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(themKHBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                            .addComponent(hoaDonBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(quitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(themMHBtn)
                .addGap(18, 18, 18)
                .addComponent(themKHBtn)
                .addGap(18, 18, 18)
                .addComponent(dsmhBtn)
                .addGap(18, 18, 18)
                .addComponent(hoaDonBtn)
                .addGap(27, 27, 27)
                .addComponent(quitBtn)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void quitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_quitBtnActionPerformed

    private void themKHBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themKHBtnActionPerformed
        this.dispose();
        new DanhSachKhachHangView().setVisible(true);
    }//GEN-LAST:event_themKHBtnActionPerformed

    private void themMHBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themMHBtnActionPerformed
        this.dispose();
        new DanhSachMatHangView().setVisible(true);
    }//GEN-LAST:event_themMHBtnActionPerformed

    private void hoaDonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoaDonBtnActionPerformed
        this.dispose();
        new HoaDonView().setVisible(true);
    }//GEN-LAST:event_hoaDonBtnActionPerformed

    private void dsmhBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dsmhBtnActionPerformed
       this.dispose();
        new DanhSachMuaHangView().setVisible(true);
    }//GEN-LAST:event_dsmhBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dsmhBtn;
    private javax.swing.JButton hoaDonBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton quitBtn;
    private javax.swing.JButton themKHBtn;
    private javax.swing.JButton themMHBtn;
    // End of variables declaration//GEN-END:variables
}
