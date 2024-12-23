/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

/**
 *
 * @author nincy
 */
public class Videos extends javax.swing.JFrame {

      private String rutaSeleccionada;
       private EmbeddedMediaPlayerComponent mediaPlayerComponent;
  
    
     public Videos(String ruta) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.rutaSeleccionada= ruta;
       mostrarArchivosDeVideo(); 
       System.setProperty("jna.library.path", "C:\\Users\\nincy\\Downloads");  // Cambia a tu ruta de VLC

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent(); 
      
    jLabel2.setLayout(new BorderLayout());
    jLabel2.add(mediaPlayerComponent);
    jLabel2.revalidate();
    jLabel2.repaint();
    }
    /**
     * Creates new form Videos
     */
    public Videos() {
        initComponents();
        this.setLocationRelativeTo(null);
          this.setSize(600, 408);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mover = new javax.swing.JMenuItem();
        eliminar = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        mover.setText("Mover");
        mover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moverActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mover);

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 461));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Videos");

        jButton3.setBackground(new java.awt.Color(255, 204, 204));
        jButton3.setText("Inicio");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setText("Que video desea ver");
        jTextField2.setPreferredSize(new java.awt.Dimension(130, 22));
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 102));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 102));
        jButton2.setText("Ordenar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1)
                .addComponent(jButton2))
        );

        jScrollPane2.setViewportView(jLabel2);

        jButton4.setText("Play");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Pause");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Previuos");

        jButton7.setText("Next");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(69, 69, 69)
                        .addComponent(jButton7)))
                .addGap(81, 81, 81))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Ruta"
            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177)
                .addComponent(jButton3)
                .addGap(40, 40, 40))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private List<File> buscarArchivosDeVideo(File carpeta) {
        List<File> archivosDeVideo = new ArrayList<>();
        File[] archivos = carpeta.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                String extension = obtenerExtension(archivo);
                if (extension.equalsIgnoreCase("mp4")) {
                    archivosDeVideo.add(archivo);
                }
            }
        }
        return archivosDeVideo;
    }
    private String obtenerExtension(File archivo) {
        String nombreArchivo = archivo.getName();
        int index = nombreArchivo.lastIndexOf('.');
        if (index > 0 && index < nombreArchivo.length() - 1) {
            return nombreArchivo.substring(index + 1).toLowerCase();
        }
        return "";
    }

    private void buscarVideo(String textoBusqueda) {
    // Obtiene la lista completa de archivos de video
    List<File> archivosDeVideo = buscarArchivosDeVideo(new File(rutaSeleccionada));

    // Filtra los archivos según el texto ingresado
    List<File> resultados = new ArrayList<>();
    for (File archivo : archivosDeVideo) {
        if (archivo.getName().toLowerCase().contains(textoBusqueda.toLowerCase())) {
            resultados.add(archivo);
        }
    }

    // Muestra los resultados de búsqueda en el JTable
    actualizarTabla(resultados);
    }
    
    
    private void mostrarArchivosDeVideo() {
    List<File> archivosDeVideo = buscarArchivosDeVideo(new File(rutaSeleccionada));
    actualizarTabla(archivosDeVideo);
}
    private void actualizarTabla(List<File> archivos) {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Limpia el contenido actual de la tabla

    // Agrega cada archivo a la tabla
    for (File archivo : archivos) {
        model.addRow(new Object[]{archivo.getName(), archivo.getAbsolutePath()});
    }
}

    private void reproducirVideo(String rutaArchivo) {
            if (mediaPlayerComponent != null) {
        mediaPlayerComponent.mediaPlayer().media().play(rutaArchivo);
       
    } else {
        JOptionPane.showMessageDialog(this, "Error al inicializar el reproductor de media.");
    }
    }

    private void pausarMedia() {
    if (mediaPlayerComponent != null && mediaPlayerComponent.mediaPlayer().status().isPlaying()) {
        mediaPlayerComponent.mediaPlayer().controls().pause();
        
    }
    }
    
     private void eliminarArchivo() {
    int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada != -1) {
        String rutaArchivo = (String) jTable1.getValueAt(filaSeleccionada, 1); 
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            JOptionPane.showMessageDialog(this, "El archivo no existe");
            return;
            }  int confirmacion = JOptionPane.showConfirmDialog(this, "Desea eliminar el archivo", "", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            if (archivo.delete()) {
                JOptionPane.showMessageDialog(this, "Archivo eliminado");
                ((DefaultTableModel) jTable1.getModel()).removeRow(filaSeleccionada);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el archivo");
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "No hay archivo seleccionado");
        }
    }
    
       private void moverArchivo() {
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada != -1) {
            String rutaArchivo = (String) jTable1.getValueAt(filaSeleccionada, 1); // Obtener la ruta del archivo
            File archivo = new File(rutaArchivo);
            
              if (!archivo.exists()) {
                JOptionPane.showMessageDialog(this, "El archivo no existe");
                return;
            }

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int seleccion = fileChooser.showOpenDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File carpetaDestino = fileChooser.getSelectedFile(); 
                File archivoDestino = new File(carpetaDestino, archivo.getName());

               if (archivo.renameTo(archivoDestino)) { 
                    JOptionPane.showMessageDialog(this, "Archivo movido");
                    ((DefaultTableModel) jTable1.getModel()).removeRow(filaSeleccionada); // Eliminar la fila del JTable
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo mover el archivo");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún archivo.");
        }
    } 
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Interfaz a = new Interfaz(rutaSeleccionada);
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
           if(jTextField2.getText().equals("Que video desea ver")){

            jTextField2.setText("");
            jTextField2.setForeground(new Color(0,0,139));
        }
    }//GEN-LAST:event_jTextField2FocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String textoBusqueda = jTextField2.getText().trim();
    buscarVideo(textoBusqueda);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada != -1) {
        String rutaArchivo = (String) jTable1.getValueAt(filaSeleccionada, 1);
        reproducirVideo(rutaArchivo);  // Llama al método para reproducir el archivo de video
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un video para reproducir.");
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          pausarMedia();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        if(jTextField2.getText().equals("Que video desea ver")){

            jTextField2.setText("");
            jTextField2.setForeground(new Color(0,0,139));
        }
    }//GEN-LAST:event_jTextField2FocusLost

    
    private void moverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moverActionPerformed
        moverArchivo();
    }//GEN-LAST:event_moverActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
       eliminarArchivo();
    }//GEN-LAST:event_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Videos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Videos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Videos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Videos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Videos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JMenuItem mover;
    // End of variables declaration//GEN-END:variables
}
