package cmd;

import java.awt.event.*;
import java.io.*;
import java.util.*;

public class commandFrame extends javax.swing.JFrame {
    private Calendar fecha;
    private CMD cmd;
    String file;
    String arch;
    public commandFrame() {
        initComponents();
        fecha=Calendar.getInstance();
        salida_comando.setText("" + fecha.getTime()+"\n");
        cmd = new CMD();

        salida_comando.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String text = obtenerUltimaLinea();
                    String[] txtPartes = text.split(" ");
                    if (txtPartes.length >= 1) {
                        String comando = txtPartes[0];
                        String argumento = (txtPartes.length > 1) ? txtPartes[1] : "";

                        if (comando.equalsIgnoreCase("mkdir")) {
                            if (cmd.Mkdir(argumento)) {
                                file=argumento;
                                salida_comando.append("\nCARPETA CREADA");
                            } else {
                                salida_comando.append("\nCARPETA EXISTENTE");
                            }
                        }else if (comando.equalsIgnoreCase("mfile")) {
                            
                            String filePath = file+File.separator+argumento;
                            String nameArch= cmd.Mfile(filePath);
                            arch=nameArch;
                            salida_comando.append("\n"+nameArch);
                        } else if (comando.equalsIgnoreCase("rm")) {
                            salida_comando.append("\n"+cmd.Rm(argumento));
                        } else if (comando.equalsIgnoreCase("cd")) {
                            arch=argumento;
                            salida_comando.append("\n"+cmd.cambio(argumento));
                        } else if (comando.equalsIgnoreCase("wr")) {
                            salida_comando.append("\n"+cmd.Escribir(arch,argumento));
                        } else if (comando.equalsIgnoreCase("rd")) {
                            salida_comando.append("\n"+cmd.Leer(argumento));
                        } else if (text.equalsIgnoreCase("...")) {
                            arch=argumento;
                            salida_comando.append("\n" + cmd.regreso());
                        } else if (text.equalsIgnoreCase("dir")) {
                            salida_comando.append("\n" + cmd.listar());
                        } else if (text.equalsIgnoreCase("date")) {
                            salida_comando.append("\n" + cmd.fecha());
                        } else if (text.equalsIgnoreCase("time")) {
                            salida_comando.append("\n" + cmd.Time());
                        } else {
                            salida_comando.append(text + "\nCOMANDO NO APTO");
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    private String obtenerUltimaLinea() {
        String txtEnFrame=salida_comando.getText();
        String[] salto=txtEnFrame.split("\n");
        if (salto.length>0) {
            return salto[salto.length-1];
        } else {
            return "";
        }
    }




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salida_comando = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        salida_comando.setBackground(new java.awt.Color(0, 0, 0));
        salida_comando.setColumns(20);
        salida_comando.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        salida_comando.setForeground(new java.awt.Color(255, 255, 255));
        salida_comando.setRows(5);
        jScrollPane1.setViewportView(salida_comando);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Consola de comando CMD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(commandFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(commandFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(commandFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(commandFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new commandFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea salida_comando;
    // End of variables declaration//GEN-END:variables
}
