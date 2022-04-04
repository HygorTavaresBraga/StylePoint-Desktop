/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import conexao.Conexao;
import entidade.Usuario;
import dao.UsuarioDao;
import java.sql.*;
import javax.swing.*;

public class CadUsuario extends javax.swing.JFrame {

    Connection conexao;

    public CadUsuario() {
        initComponents();
        conexao = Conexao.conexao();
    }

    void limpar(){
      jnomeCad.setText("");
      jusuarioCad.setText("");
      jsenhaCad.setText("");


  }
    
    void logar() {
        Usuario u = new Usuario();
        u.setLoginUsuario(jusuarioCad.getText());
        u.setSenhaUsuario(jsenhaCad.getText());
        try {
            UsuarioDao dao = new UsuarioDao();
            if (dao.login(jusuarioCad.getText(), jsenhaCad.getText())) {
                JOptionPane.showMessageDialog(null, "Seja bem vindo" + jusuarioCad.getText());
                new Menu().setVisible(true);
                this.dispose();
            }else{
                 JOptionPane.showMessageDialog(null, "Usuario não encontrado");
                 jusuarioCad.setText("");
                 jsenhaCad.setText("");
                 jusuarioCad.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no SQL" + e.getMessage());
        }
    }
    
    void cadastrar(){
        try{
            Usuario u = new Usuario();
            u.setNomeUsuario(jnomeCad.getText());
            u.setLoginUsuario(jusuarioCad.getText());
            u.setSenhaUsuario(jsenhaCad.getText());
            UsuarioDao dao = new UsuarioDao();
            dao.adicionar(u);
            JOptionPane.showMessageDialog(null,"Usuário Cadastrado!"); 
            new Login().setVisible(true);
            this.dispose();
            
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erro ao cadastrar Usuário "+e.getMessage());
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jnomeCad = new javax.swing.JTextField();
        jusuarioCad = new javax.swing.JTextField();
        jsenhaCad = new javax.swing.JPasswordField();
        jcadastrar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jlogin = new javax.swing.JButton();
        jcancelar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMinimumSize(new java.awt.Dimension(400, 370));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("NOME");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 60, 80, 30);

        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SENHA");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 160, 80, 30);

        jLabel7.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("USUÁRIO");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 110, 80, 30);
        getContentPane().add(jnomeCad);
        jnomeCad.setBounds(150, 60, 210, 30);
        getContentPane().add(jusuarioCad);
        jusuarioCad.setBounds(150, 110, 210, 30);
        getContentPane().add(jsenhaCad);
        jsenhaCad.setBounds(150, 160, 210, 30);

        jcadastrar.setText("Cadastrar");
        jcadastrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jcadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jcadastrar);
        jcadastrar.setBounds(200, 210, 120, 20);

        jLabel10.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CADASTRO DE USUÁRIO");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel10);
        jLabel10.setBounds(100, 10, 210, 30);

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlogin.setText("Já Possuo Usuário");
        jlogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jloginActionPerformed(evt);
            }
        });
        jPanel3.add(jlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 130, 20));

        jcancelar.setText("Sair");
        jcancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcancelarActionPerformed(evt);
            }
        });
        jPanel3.add(jcancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 60, 20));

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, -20, 400, 350);

        jMenuBar1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N

        jMenu1.setText("Sistema");

        jMenuItem1.setText("Cadastrar Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem6.setText("Sair");
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sobre");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new CadCliente().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jcadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcadastrarActionPerformed
        cadastrar();
    }//GEN-LAST:event_jcadastrarActionPerformed

    private void jcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jcancelarActionPerformed

    private void jloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jloginActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jloginActionPerformed

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
            java.util.logging.Logger.getLogger(CadUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jcadastrar;
    private javax.swing.JButton jcancelar;
    private javax.swing.JButton jlogin;
    private javax.swing.JTextField jnomeCad;
    private javax.swing.JPasswordField jsenhaCad;
    private javax.swing.JTextField jusuarioCad;
    // End of variables declaration//GEN-END:variables
}
