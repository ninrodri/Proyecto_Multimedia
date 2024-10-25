/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nincy
 */
public class Analisis extends javax.swing.JFrame {

    private String rutaSeleccionada;
   
    /**
     * Creates new form Analisis
     */
    public Analisis(String ruta) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.rutaSeleccionada=ruta;
       
        double tamcarpeta = calculartamcarpeta(new File(rutaSeleccionada));
        double tamcarpetaGB = (double) tamcarpeta / (1024 * 1024 * 1024);  
        jLabel11.setText(String.format ("%.2f GB Utilizados",+tamcarpetaGB));
        
        double tammusica = calculartammusica(new File(rutaSeleccionada));
        double tammusicaGB = tammusica / (1024 * 1024 * 1024); 
        jLabel3.setText(String.format("%.2f GB Utilizados", tammusicaGB));
        
        double tamvideo = calculartamvideo(new File(rutaSeleccionada));
        double tamvideoGB = tamvideo / (1024 * 1024 * 1024);
        jLabel12.setText(String.format("%.2f GB Utilizados", tamvideoGB));
   
        double tamImagenes = calcularTamImagenes(new File(rutaSeleccionada));
        double tamImagenesGB = tamImagenes / (1024 * 1024 * 1024);  
        jLabel13.setText(String.format("%.2f GB Utilizados", tamImagenesGB));
    
                List<File[]> archivosDuplicados = buscarArchivosDuplicados(new File(rutaSeleccionada));

        // Crear el modelo de la tabla
        DefaultTableModel modelDuplicados = (DefaultTableModel) jTable3.getModel();
        modelDuplicados.setRowCount(0); // Limpiar filas existentes (si es necesario)

        // Añadir los archivos duplicados al JTable
        for (File[] parDuplicado : archivosDuplicados) {
            String nombreArchivo1 = parDuplicado[0].getName();
            String rutaArchivo1 = parDuplicado[0].getAbsolutePath();
            String tamanoArchivo1 = String.format("%.2f MB", (double) parDuplicado[0].length() / (1024 * 1024));

            String nombreArchivo2 = parDuplicado[1].getName();
            String rutaArchivo2 = parDuplicado[1].getAbsolutePath();
            String tamanoArchivo2 = String.format("%.2f MB", (double) parDuplicado[1].length() / (1024 * 1024));

            // Añadir ambos archivos a la tabla
            modelDuplicados.addRow(new Object[]{nombreArchivo1, tamanoArchivo1, rutaArchivo1});
            modelDuplicados.addRow(new Object[]{nombreArchivo2, tamanoArchivo2, rutaArchivo2});
        }
        
        List<File> archivosMasPesados = buscarArchivosMasPesados(new File(rutaSeleccionada));
        DefaultTableModel modelPesados = (DefaultTableModel) jTable2.getModel();
        modelPesados.setRowCount(0); // Limpiar filas existentes

        for (File archivo : archivosMasPesados) {
            String nombreArchivo = archivo.getName();
            String rutaArchivo = archivo.getAbsolutePath();
            String tamanoArchivo = String.format("%.2f MB", (double) archivo.length() / (1024 * 1024));

            // Añadir el archivo a la tabla de archivos pesados
            modelPesados.addRow(new Object[]{nombreArchivo, tamanoArchivo, rutaArchivo});
        }
    }
          

    // Definir el método buscarArchivosDuplicados
    public List<File[]> buscarArchivosDuplicados(File carpeta) {
        List<File[]> duplicados = new ArrayList<>(); // Lista para guardar pares de archivos duplicados
        File[] archivos = carpeta.listFiles(); // Lista de archivos en la carpeta

        // Recorrer todos los archivos en la carpeta
        if (archivos != null) {
            for (int i = 0; i < archivos.length; i++) {
                for (int j = i + 1; j < archivos.length; j++) {
                    // Si los tamaños de dos archivos son iguales, los consideramos duplicados
                    if (archivos[i].length() == archivos[j].length() && obtenerExtension(archivos[i]).equals(obtenerExtension(archivos[j]))) {
                        duplicados.add(new File[]{archivos[i], archivos[j]});
                        if (duplicados.size() == 1) {
                            return duplicados;
                    }
                    
                    }
                }
            }
        }
        return duplicados;
    }
    
    public String obtenerExtension(File archivo) {
        String nombre = archivo.getName();
        int indicePunto = nombre.lastIndexOf('.');
        if (indicePunto > 0 && indicePunto < nombre.length() - 1) {
            return nombre.substring(indicePunto + 1).toLowerCase(); 
        }
        return "";
    }

    
    public List<File> buscarArchivosMasPesados(File carpeta) {
        List<File> archivosMasPesados = new ArrayList<>(); 
        File[] archivos = carpeta.listFiles(); // Lista de archivos en la carpeta

        
        File archivoMasPesado1 = null;
        File archivoMasPesado2 = null;

        // Recorrer todos los archivos en la carpeta
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                   
                    if (archivoMasPesado1 == null || archivo.length() > archivoMasPesado1.length()) {
                        archivoMasPesado2 = archivoMasPesado1; 
                        archivoMasPesado1 = archivo; 
                    } else if (archivoMasPesado2 == null || archivo.length() > archivoMasPesado2.length()) {
                        archivoMasPesado2 = archivo; 
                    }
                }
            }
        }

    
        if (archivoMasPesado1 != null) {
            archivosMasPesados.add(archivoMasPesado1);
        }
        if (archivoMasPesado2 != null) {
            archivosMasPesados.add(archivoMasPesado2);
        }

        return archivosMasPesados;
    }
    
    
    public final double calculartamcarpeta(File carpeta) {
        double tam = 0;

        if (carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    tam += calculartamcarpeta(archivo); 
                }
            }
        } else {
            tam = carpeta.length(); 
        }

        return tam;
    }
    
     public double calculartammusica(File carpeta) {
        double tammusica = 0;

        if (carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    tammusica += calculartammusica(archivo);  
                }
            }
        } else {
          
            String nombreArchivo = carpeta.getName().toLowerCase();
            if (nombreArchivo.endsWith(".mp3") || nombreArchivo.endsWith(".wav")) {
                tammusica = carpeta.length();
            }
        }

        return tammusica;
    }
     
     public double calculartamvideo(File carpeta) {
        double tamvideo = 0;

        if (carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    tamvideo += calculartamvideo(archivo);  
                }
            }
        } else {
            String nombreArchivo = carpeta.getName().toLowerCase();
            if (nombreArchivo.endsWith(".mp4") || nombreArchivo.endsWith(".avi")) {
                tamvideo = carpeta.length();
            }
        }

        return tamvideo;
    }
     
     public double calcularTamImagenes(File carpeta) {
    double tamImagenes = 0;

    if (carpeta.isDirectory()) {
        File[] archivos = carpeta.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                tamImagenes += calcularTamImagenes(archivo);  
            }
        }
    } else {
        
        String nombreArchivo = carpeta.getName().toLowerCase();
        if (nombreArchivo.endsWith(".jpg") || nombreArchivo.endsWith(".png") || nombreArchivo.endsWith(".jpeg") || nombreArchivo.endsWith(".tiff")) {
            tamImagenes = carpeta.length();
        }
    }

    return tamImagenes;
}
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        inicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Almacenamiento");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Imagenes");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Video");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Musica");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Musica");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("total");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("video");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("imagenes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addGap(77, 77, 77))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel11)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13))
                .addGap(12, 12, 12))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("GB Utilizados");

        jButton2.setBackground(new java.awt.Color(255, 255, 102));
        jButton2.setText("Ver mas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Archivos Duplicados");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre ", "Tamaño", "Ruta"
            }
        ));
        jScrollPane2.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jButton2)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Archivos Grandes");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("GB Utilizados");

        jButton3.setBackground(new java.awt.Color(255, 255, 102));
        jButton3.setText("Ver mas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre ", "Tamaño", "Ruta"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(20, 20, 20))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10))
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        inicio.setBackground(new java.awt.Color(255, 204, 204));
        inicio.setText("inicio");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 98, 0, 28);
        jPanel4.add(inicio, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Analisis");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 122, 0, 0);
        jPanel4.add(jLabel1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        Interfaz a = new Interfaz(rutaSeleccionada);
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_inicioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Archidupli b= new Archidupli(rutaSeleccionada);
        b.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Archigrandes c= new Archigrandes(rutaSeleccionada);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

     
     
    /**
     * 
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
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               String ruta = Ruta.getRutaSeleccionada();
                if (ruta != null) {
                    new Analisis(ruta).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado una carpeta.");
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inicio;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
