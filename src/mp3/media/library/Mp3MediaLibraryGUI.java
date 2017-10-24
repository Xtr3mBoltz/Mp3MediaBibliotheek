/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3.media.library;

import java.io.File;
import java.io.FilenameFilter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author sergi & wilco
 */
public class Mp3MediaLibraryGUI extends javax.swing.JFrame {

    /**
     * Creates new form Mp3MediaLibraryGUI
     */
    DefaultTableModel model;

    public Mp3MediaLibraryGUI() {
        initComponents();
        getFilesName();
        sorting();
    }

    public void sorting() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTableSongList.setRowSorter(sorter);
    }

    public void getFilesName() {
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".mp3");
            }
        };
        File folder = new File(System.getProperty("user.home").concat("\\Music"));
        File[] listOfFiles = folder.listFiles(filter);
        model = (DefaultTableModel) jTableSongList.getModel();
        Object[] row = new Object[1];
        for (int i = 0; i < listOfFiles.length; i++) {
            row[0] = listOfFiles[i].getName();
            model.addRow(row);
        }
    }

    public void favorite() {
        int row = jTableSongList.getSelectedRow();
        int column = jTableSongList.getSelectedColumn();
        
        if (jTableSongList.getValueAt(row, column).toString().contains("★ - ")) {
            jTableSongList.setValueAt(jTableSongList.getValueAt(row, column).toString().substring(4), row, column);

        } else {
            String star = "★ - " + jTableSongList.getValueAt(row, column).toString();
            jTableSongList.setValueAt(star, row, column);
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

        jPopupMenuFRD = new javax.swing.JPopupMenu();
        jMenuItemFavorite = new javax.swing.JMenuItem();
        jMenuItemRename = new javax.swing.JMenuItem();
        jMenuItemDelete = new javax.swing.JMenuItem();
        jButtonDelete = new javax.swing.JButton();
        jButtonRename = new javax.swing.JButton();
        jButtonFavorite = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSongList = new javax.swing.JTable();
        jTextFieldSearchField = new javax.swing.JTextField();
        jLabelSearch = new javax.swing.JLabel();
        jButtonRefresh = new javax.swing.JButton();

        jMenuItemFavorite.setText("Favorite");
        jMenuItemFavorite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFavoriteActionPerformed(evt);
            }
        });
        jPopupMenuFRD.add(jMenuItemFavorite);

        jMenuItemRename.setText("Rename");
        jMenuItemRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRenameActionPerformed(evt);
            }
        });
        jPopupMenuFRD.add(jMenuItemRename);

        jMenuItemDelete.setText("Delete");
        jMenuItemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeleteActionPerformed(evt);
            }
        });
        jPopupMenuFRD.add(jMenuItemDelete);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mp3 Library");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonRename.setText("Rename");
        jButtonRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRenameActionPerformed(evt);
            }
        });

        jButtonFavorite.setText("Favorite");
        jButtonFavorite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFavoriteActionPerformed(evt);
            }
        });

        jTableSongList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Title", "Length", "Artist", "Year", "Genre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSongList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableSongListMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableSongList);

        jLabelSearch.setText("Search:");

        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButtonRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRename)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jLabelSearch)
                        .addGap(30, 30, 30)
                        .addComponent(jTextFieldSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jButtonFavorite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDelete)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonRefresh)
                        .addComponent(jButtonRename)
                        .addComponent(jButtonFavorite)
                        .addComponent(jButtonDelete)
                        .addComponent(jLabelSearch))
                    .addComponent(jTextFieldSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        jMenuItemDeleteActionPerformed(evt);
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jMenuItemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDeleteActionPerformed
        model = (DefaultTableModel) jTableSongList.getModel();
        int[] delete = jTableSongList.getSelectedRows();
        for (int i = 0; i < delete.length; i++) {
            model.removeRow((delete[i] - i));
        }
    }//GEN-LAST:event_jMenuItemDeleteActionPerformed

    private void jTableSongListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSongListMouseReleased
        if (evt.isPopupTrigger()) {
            JTable popup = (JTable) evt.getSource();
            int row = popup.rowAtPoint(evt.getPoint());
            int column = popup.columnAtPoint(evt.getPoint());

            if (!popup.isRowSelected(row)) {
                popup.changeSelection(row, column, false, false);
            }
            jPopupMenuFRD.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTableSongListMouseReleased

    private void jMenuItemRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRenameActionPerformed
        jTableSongList.editCellAt(jTableSongList.getSelectedRow(), 0);

    }//GEN-LAST:event_jMenuItemRenameActionPerformed

    private void jMenuItemFavoriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFavoriteActionPerformed
        favorite();
    }//GEN-LAST:event_jMenuItemFavoriteActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        model.setRowCount(0);
        getFilesName();
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jButtonFavoriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFavoriteActionPerformed
        favorite();
    }//GEN-LAST:event_jButtonFavoriteActionPerformed

    private void jButtonRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRenameActionPerformed
        jMenuItemRenameActionPerformed(evt);
    }//GEN-LAST:event_jButtonRenameActionPerformed

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
            java.util.logging.Logger.getLogger(Mp3MediaLibraryGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mp3MediaLibraryGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mp3MediaLibraryGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mp3MediaLibraryGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mp3MediaLibraryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonFavorite;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonRename;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JMenuItem jMenuItemDelete;
    private javax.swing.JMenuItem jMenuItemFavorite;
    private javax.swing.JMenuItem jMenuItemRename;
    private javax.swing.JPopupMenu jPopupMenuFRD;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableSongList;
    private javax.swing.JTextField jTextFieldSearchField;
    // End of variables declaration//GEN-END:variables
}
