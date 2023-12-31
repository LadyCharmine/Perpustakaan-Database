/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pbopertemuan5;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author saddam
 */
public class TampilanDatabase extends javax.swing.JFrame {

    /**
     * Creates new form TampilanDatabase
     */
    ArrayList<Perpustakaan> dataPerpustakaan;

    private void tampil(Connection conn) {
        dataPerpustakaan.clear();
        try {
            String sql = "select * from perpustakaan";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Perpustakaan data = new Perpustakaan();
                data.setid_buku(String.valueOf(rs.getObject(1)));
                data.setisbn(String.valueOf(rs.getObject(2)));
                data.setjudul_buku(String.valueOf(rs.getObject(3)));
                data.settgl_beli(String.valueOf(rs.getObject(4)));
                data.setpenerbit(String.valueOf(rs.getObject(5)));

                dataPerpustakaan.add(data);
            }
            DefaultTableModel model = (DefaultTableModel) jTablePerpustakaan.getModel();
            model.setRowCount(0);
            for (Perpustakaan data : dataPerpustakaan) {

                Object[] baris = new Object[5];
                baris[0] = data.getid_buku();
                baris[1] = data.getisbn();
                baris[2] = data.getjudul_buku();
                baris[3] = data.gettgl_beli();
                baris[4] = data.getpenerbit();

                model.addRow(baris);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TampilanDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ;
    public TampilanDatabase() {
        try {
            dataPerpustakaan = new ArrayList<>();
            initComponents();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/perpustakaan", "postgres", "12345");
            tampil(conn);
        } catch (SQLException ex) {
            Logger.getLogger(TampilanDatabase.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabelJudul = new javax.swing.JLabel();
        jLabelIdBuku = new javax.swing.JLabel();
        jLabelIsbn = new javax.swing.JLabel();
        jTextFieldIdBuku = new javax.swing.JTextField();
        jTextFieldIsbn = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePerpustakaan = new javax.swing.JTable();
        jButtonUpdate = new javax.swing.JButton();
        jButtonHapus = new javax.swing.JButton();
        jButtonSimpan = new javax.swing.JButton();
        jLabel1JudulBuku = new javax.swing.JLabel();
        jTextFieldJudulBuku = new javax.swing.JTextField();
        jLabelTglBeli = new javax.swing.JLabel();
        jTextFieldTglBeli = new javax.swing.JTextField();
        jLabelPenerbit = new javax.swing.JLabel();
        jTextFieldPenerbit = new javax.swing.JTextField();
        jButtonCetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelJudul.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabelJudul.setText("CRUD - Create Read Update Delete - Sederhana");

        jLabelIdBuku.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelIdBuku.setText("ID Buku : ");

        jLabelIsbn.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelIsbn.setText("ISBN :");

        jTextFieldIdBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdBukuActionPerformed(evt);
            }
        });

        jTablePerpustakaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID BUKU", "ISBN", "Judul Buku", "Tgl Beli", "Penerbit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePerpustakaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePerpustakaanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePerpustakaan);

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonHapus.setText("Hapus");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        jButtonSimpan.setText("Simpan");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });

        jLabel1JudulBuku.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1JudulBuku.setText("Judul Buku :");

        jLabelTglBeli.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelTglBeli.setText("Tgl Beli :");

        jTextFieldTglBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTglBeliActionPerformed(evt);
            }
        });

        jLabelPenerbit.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelPenerbit.setText("Penerbit :");

        jTextFieldPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPenerbitActionPerformed(evt);
            }
        });

        jButtonCetak.setText("Cetak");
        jButtonCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1JudulBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabelTglBeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabelPenerbit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabelIdBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelIsbn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldIdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldTglBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonHapus)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelIdBuku)
                            .addComponent(jTextFieldIdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelIsbn)
                            .addComponent(jTextFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1JudulBuku)
                            .addComponent(jTextFieldJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTglBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTglBeli))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPenerbit))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonUpdate)
                            .addComponent(jButtonHapus)
                            .addComponent(jButtonSimpan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCetak))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(833, 443));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIdBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdBukuActionPerformed

    public int updateData(Connection conn, String penerbit, String tgl_beli, String judul_buku, String isbn, String id_buku) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("UPDATE PERPUSTAKAAN SET penerbit = ?, tgl_beli = ?, judul_buku = ?, isbn = ? WHERE id_buku = ?");
        pst.setString(5, id_buku);
        pst.setString(4, isbn);
        pst.setString(3, judul_buku);
        pst.setString(2, tgl_beli);
        pst.setString(1, penerbit);
        return pst.executeUpdate();
    }

    private ResultSet tampilIdBuku(Connection conn, String id_buku) throws SQLException {
        String sql = "select * from perpustakaan where id_buku = ?";
        PreparedStatement pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        pst.setString(1, id_buku);
        ResultSet rs = pst.executeQuery();
        return rs;
    }


    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        String penerbit = jTextFieldPenerbit.getText();
        String tgl_beli = jTextFieldTglBeli.getText();
        String judul_buku = jTextFieldJudulBuku.getText();
        String isbn = jTextFieldIsbn.getText().trim();
        String id_buku = jTextFieldIdBuku.getText().trim();

        // TODO add your handling code here:
        if (!id_buku.isEmpty() && !isbn.isEmpty() && !judul_buku.isEmpty() && !tgl_beli.isEmpty() && !penerbit.isEmpty()) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/perpustakaan", "postgres", "12345");
                ResultSet rs = this.tampilIdBuku(conn, id_buku);
                if (rs.first()) {
                    //System.out.println(String.valueOf(rs.getObject(1)) + " " + String.valueOf(rs.getObject(2)));
                    int k = this.updateData(conn, penerbit, tgl_beli, judul_buku, isbn, id_buku);
                    if (k > 0) {
                        tampil(conn);
                        peringatan("Update Berhasil");

                    } else {
                        peringatan("Update Gagal");
                    }
                } else {
                    peringatan("Data Buku dengan ID Buku" + "" + id_buku + " Tidak Ditemukan");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TampilanDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            peringatan("ID Buku dan Judul Buku Tidak Boleh Kosong");
        }
        jTextFieldIdBuku.setText("");
        jTextFieldIsbn.setText("");
        jTextFieldJudulBuku.setText("");
        jTextFieldTglBeli.setText("");
        jTextFieldPenerbit.setText("");

    }//GEN-LAST:event_jButtonUpdateActionPerformed

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }

    private int masukkanData(Connection conn, String id_buku, String isbn, String judul_buku, String tgl_beli, String penerbit) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("INSERT INTO PERPUSTAKAAN (id_buku, isbn, judul_buku, tgl_beli, penerbit) VALUES(?,?,?,?,?)");
        pst.setString(1, id_buku);
        pst.setString(2, isbn);
        pst.setString(3, judul_buku);
        pst.setString(4, tgl_beli);
        pst.setString(5, penerbit);
        return pst.executeUpdate();
    }


    private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
        // TODO add your handling code here:
        String id_buku = jTextFieldIdBuku.getText().trim();
        String isbn = jTextFieldIsbn.getText();
        String judul_buku = jTextFieldJudulBuku.getText();
        String tgl_beli = jTextFieldTglBeli.getText();
        String penerbit = jTextFieldPenerbit.getText();

        if (!id_buku.isEmpty() && !isbn.isEmpty() && !judul_buku.isEmpty() && !tgl_beli.isEmpty() && !penerbit.isEmpty()) {

            try {
                // TODO add your handling code here:
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/perpustakaan", "postgres", "12345");
                int k = masukkanData(conn, id_buku, isbn, judul_buku, tgl_beli, penerbit);
                if (k > 0) {
                    tampil(conn);
                    this.peringatan("Simpan Berhasil");
                } else {
                    this.peringatan("Simpan Gagal");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TampilanDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.peringatan("Input Data Buku Gagal");
        }
        jTextFieldIdBuku.setText("");
        jTextFieldIsbn.setText("");
        jTextFieldJudulBuku.setText("");
        jTextFieldTglBeli.setText("");
        jTextFieldPenerbit.setText("");

    }//GEN-LAST:event_jButtonSimpanActionPerformed

    public int hapusData(Connection conn, String id_buku) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("DELETE from PERPUSTAKAAN WHERE id_buku = ?");
        pst.setString(1, id_buku);
        return pst.executeUpdate();
    }
    private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed
        // TODO add your handling code here:
        String id_buku = jTextFieldIdBuku.getText().trim();
        if (!id_buku.isEmpty()) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/perpustakaan", "postgres", "12345");
                int k = hapusData(conn, id_buku);
                if (k > 0) {
                    tampil(conn);
                    peringatan("Hapus Berhasil");
                } else {
                    peringatan("Hapus Gagal");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TampilanDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.peringatan("Untuk Menghapus, ID Buku Tidak Boleh Kosong");
        }
        jTextFieldIdBuku.setText("");

    }//GEN-LAST:event_jButtonHapusActionPerformed

    private void jTextFieldTglBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTglBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTglBeliActionPerformed

    private void jTextFieldPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPenerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPenerbitActionPerformed

    private void jButtonCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCetakActionPerformed
        // TODO add your handling code here:
 try {
            // TODO add your handling code here:
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/perpustakaan", "postgres", "12345");

            //File jasperFile = new File("src/pbopertemuan5/perpustakaan.jasper");
            //JasperPrint jp = JasperFillManager.fillReport(jasperFile.getPath(), null, conn);

            String jrxmlFile = new String("src/pbopertemuan5/perpustakaan.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (SQLException ex) {
            Logger.getLogger(TampilanDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(TampilanDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonCetakActionPerformed

    private void jTablePerpustakaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePerpustakaanMouseClicked
        // TODO add your handling code here:
        JTable source = (JTable) evt.getSource();
        int baris = source.rowAtPoint(evt.getPoint());
        int kolom = source.columnAtPoint(evt.getPoint());
        String s = source.getModel().getValueAt(baris, kolom) + "";
        System.out.println("Di klik pada kolom " + String.valueOf(kolom));
        if (kolom == 0) {
            try {
                jTextFieldIdBuku.setText(s);
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/perpustakaan", "postgres", "12345");
                ResultSet rs = this.tampilIdBuku(conn, s);
                //if (rs.first()) {
                //    jTextFieldJudulBuku.setText(String.valueOf(rs.getObject(2)));
                //}
            } catch (SQLException ex) {
                Logger.getLogger(TampilanDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTablePerpustakaanMouseClicked

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
            java.util.logging.Logger.getLogger(TampilanDatabase.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TampilanDatabase.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TampilanDatabase.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TampilanDatabase.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TampilanDatabase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCetak;
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1JudulBuku;
    private javax.swing.JLabel jLabelIdBuku;
    private javax.swing.JLabel jLabelIsbn;
    private javax.swing.JLabel jLabelJudul;
    private javax.swing.JLabel jLabelPenerbit;
    private javax.swing.JLabel jLabelTglBeli;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePerpustakaan;
    private javax.swing.JTextField jTextFieldIdBuku;
    private javax.swing.JTextField jTextFieldIsbn;
    private javax.swing.JTextField jTextFieldJudulBuku;
    private javax.swing.JTextField jTextFieldPenerbit;
    private javax.swing.JTextField jTextFieldTglBeli;
    // End of variables declaration//GEN-END:variables
}
