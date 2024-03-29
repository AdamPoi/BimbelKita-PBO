/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bimbelkita;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

/**
 *
 * @author asus
 */
public final class Kelas_Form extends javax.swing.JFrame {

    DefaultListModel listModel;
    private ResultSet hasil;
    private DefaultTableModel tabmode;
    CRUDkelas crud = new CRUDkelas();
    Session s = new Session();
    Connection con = new koneksi().con();

    public Kelas_Form() {
        initComponents();
        tampilListSiswa();
        tampilKelas();
        tampilTingkat();
    }

    public void tampilListSiswa() {
        listModel = new DefaultListModel();
        try {
            hasil = crud.tampilListSiswa(crud.getKelasList());
            while (hasil.next()) {
                crud.setNama(hasil.getString("nama"));
                String data = crud.getNama();
                listModel.addElement(data);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void tampilKelas() {
        listModel = new DefaultListModel();
        list_kelas.setModel(listModel);
        crud.setTingkat(combo_pilihTingkat.getSelectedIndex());

        try {
            hasil = crud.tampilKelas(crud.getTingkat());
            while (hasil.next()) {

                crud.setNamaKelas(hasil.getString("nama"));
                String data = crud.getNamaKelas();
                listModel.addElement(data);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void tampilTingkat() {
        combo_pilihTingkat.addItem("kelas 7");
        combo_pilihTingkat.addItem("kelas 8");
        combo_pilihTingkat.addItem("kelas 9");

        combo_tingkat.addItem("kelas 7");
        combo_tingkat.addItem("kelas 8");
        combo_tingkat.addItem("kelas 9");
    }

    public void tampilSiswa() {
        Object[] baris = {"ID", "NIS", "Nama", "kelas"};
        tabmode = new DefaultTableModel(null, baris);
        tabel_kelas.setModel(tabmode);
        try {

            int id_kelas = crud.getID_kelas();
            hasil = crud.tampilSiswa(id_kelas);
            while (hasil.next()) {
                crud.setID(hasil.getString("siswa_id"));
                crud.setNama(hasil.getString("nama"));
                crud.setKelas(hasil.getString("kelas"));
                String nis = String.valueOf(crud.getNis());
                String[] data = {crud.getID(), nis, crud.getNama(), crud.getKelas()};
                tabmode.addRow(data);
            }
        } catch (SQLException e) {
            System.out.println("e" + e);
        }
    }

    public void reset_text() {
        txt_namaKelas.setText("");
        combo_tingkat.select(0);

    }

    /**
     * Creates new form Kelas_Form
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_namaKelas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        combo_tingkat = new java.awt.Choice();
        combo_pilihTingkat = new java.awt.Choice();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        list_kelas = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_kelas = new javax.swing.JTable();
        btn_insert = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        menu_siswa = new javax.swing.JMenuItem();
        menu_guru = new javax.swing.JMenuItem();
        menu_kelas = new javax.swing.JMenuItem();
        menu_jadwal = new javax.swing.JMenuItem();
        menu_ruang = new javax.swing.JMenuItem();
        menu_keluar = new javax.swing.JMenu();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 51));

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Kelas");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tingkat");

        combo_tingkat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        combo_pilihTingkat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        combo_pilihTingkat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_pilihTingkatItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tingkat");

        list_kelas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list_kelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_kelasMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(list_kelas);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kelas");

        tabel_kelas.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_kelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_kelasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_kelas);

        btn_insert.setText("Tambah");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cari Data Kelas");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Kelas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(combo_pilihTingkat, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(jLabel5))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_namaKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(combo_tingkat, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(333, 333, 333))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(combo_tingkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_namaKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_insert)
                        .addComponent(btn_reset)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_pilihTingkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 56, Short.MAX_VALUE))
        );

        Menu.setText("Menu");

        menu_siswa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menu_siswa.setText("Form Siswa");
        menu_siswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_siswaActionPerformed(evt);
            }
        });
        Menu.add(menu_siswa);

        menu_guru.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        menu_guru.setText("Form Guru");
        menu_guru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_guruActionPerformed(evt);
            }
        });
        Menu.add(menu_guru);

        menu_kelas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        menu_kelas.setText("Form Kelas");
        menu_kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_kelasActionPerformed(evt);
            }
        });
        Menu.add(menu_kelas);

        menu_jadwal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        menu_jadwal.setText("Form Jadwal");
        menu_jadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_jadwalActionPerformed(evt);
            }
        });
        Menu.add(menu_jadwal);

        menu_ruang.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        menu_ruang.setText("Form Ruang");
        menu_ruang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ruangActionPerformed(evt);
            }
        });
        Menu.add(menu_ruang);

        jMenuBar1.add(Menu);

        menu_keluar.setText("Keluar");
        menu_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_keluarMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_keluar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabel_kelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_kelasMouseClicked
        try {

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_tabel_kelasMouseClicked

    private void list_kelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_kelasMouseClicked
        try {
            String nama_kelas = list_kelas.getSelectedValue();
            crud.setID_Kelas(nama_kelas);
            tampilSiswa();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_list_kelasMouseClicked

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
//        if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ini ? ", "  Warning", 2) == JOptionPane.YES_OPTION) {
//            try {
//                crud.setID(txt_id.getText());
//                crud.insertSiswa(crud.getID());
//                JOptionPane.showMessageDialog(null, "Siswa berhasil dimasukan ke-kelas", "Informasi",
//                        JOptionPane.INFORMATION_MESSAGE);
//                tampil_database();
//                reset_text();
//            } catch (HeadlessException e) {
//                JOptionPane.showMessageDialog(null, "Data gagal dihapus", "Informasi",
//                        JOptionPane.INFORMATION_MESSAGE);
//            }
//        }
    }//GEN-LAST:event_btn_resetActionPerformed

    private void combo_pilihTingkatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_pilihTingkatItemStateChanged
        tampilKelas();
    }//GEN-LAST:event_combo_pilihTingkatItemStateChanged

    private void menu_jadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_jadwalActionPerformed
        this.dispose();
        jadwal_form jf = new jadwal_form();
        jf.show();
    }//GEN-LAST:event_menu_jadwalActionPerformed

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed

        if (txt_namaKelas.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, nama kelas belum diisi !");
            txt_namaKelas.requestFocus();
        } else if (combo_tingkat.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, tingkat belum diisi !");
            combo_tingkat.requestFocus();
        } else {
            try {
                String nama_kelas = txt_namaKelas.getText();
                int tingkat = combo_tingkat.getSelectedIndex();
                crud.setNamaKelas(nama_kelas);
                crud.setTingkat(tingkat);
                crud.simpanData(crud.getNamaKelas(), crud.getTingkat());
                reset_text();
                tampilKelas();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }//GEN-LAST:event_btn_insertActionPerformed

    private void menu_siswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_siswaActionPerformed
        this.dispose();
        Siswa_Form sf = new Siswa_Form();
        sf.show();
    }//GEN-LAST:event_menu_siswaActionPerformed

    private void menu_ruangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ruangActionPerformed
        this.dispose();
        Ruang_Form rf = new Ruang_Form();
        rf.show();
    }//GEN-LAST:event_menu_ruangActionPerformed

    private void menu_guruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_guruActionPerformed
        this.dispose();
        Guru_Form gf = new Guru_Form();
        gf.show();
    }//GEN-LAST:event_menu_guruActionPerformed

    private void menu_kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_kelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_kelasActionPerformed

    private void menu_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_keluarMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan keluar ?", "Warning", 2)
                == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_menu_keluarMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kelas_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Kelas_Form().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Menu;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_reset;
    private java.awt.Choice combo_pilihTingkat;
    private java.awt.Choice combo_tingkat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JList<String> list_kelas;
    private javax.swing.JMenuItem menu_guru;
    private javax.swing.JMenuItem menu_jadwal;
    private javax.swing.JMenuItem menu_kelas;
    private javax.swing.JMenu menu_keluar;
    private javax.swing.JMenuItem menu_ruang;
    private javax.swing.JMenuItem menu_siswa;
    private javax.swing.JTable tabel_kelas;
    private javax.swing.JTextField txt_namaKelas;
    // End of variables declaration//GEN-END:variables
}
