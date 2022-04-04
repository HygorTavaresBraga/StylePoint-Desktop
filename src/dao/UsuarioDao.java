package dao;

import conexao.Conexao;
import entidade.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;

public class UsuarioDao extends Conexao {

    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet linha = null;

    public UsuarioDao() {
        this.conexao = Conexao.conexao();

    }

    public void adicionar(Usuario usuario) {
        String sql = "insert into usuario(nomeUsuario,loginUsuario,senhaUsuario)values(?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getLoginUsuario());
            stmt.setString(3, usuario.getSenhaUsuario());
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no comando SQL" + e.getMessage());
        }
    }

    public Usuario consultar(String LoginUsuario) {
        try {
            Usuario usuario = new Usuario();
            stmt = conexao.prepareStatement("select *from usuario where loginUsuario= ?");
            stmt.setString(1, LoginUsuario);
            linha = stmt.executeQuery();
            if (linha.next()) {
                usuario.setIdUsuario(linha.getInt("idUsuario"));
                usuario.setLoginUsuario(linha.getString("loginUsuario"));
                usuario.setNomeUsuario(linha.getString("nomeUsuario"));
                usuario.setSenhaUsuario(linha.getString("senhaUsuario"));
                return usuario;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void atualizar(Usuario usuario) {
        try {
            stmt = conexao.prepareStatement("update usuario set nomeUsuario=?,senhaUsuario = ? where loginUsuario = ?");
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getSenhaUsuario());
            stmt.setString(3, usuario.getLoginUsuario());
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no SQL" + e.getMessage());

        }
    }
    

    public boolean excluir(String login) {
try{
    stmt = conexao.prepareStatement("delete from login where loginUsuario = ?");
    stmt.setString(1,login);
    stmt.executeUpdate();
    return  true;
    }catch(Exception e){
        return false;
    }
}
    public boolean login(String loginUsuario,String senhaUsuario){
        boolean existe = false;
        String sql = "select loginUsuario,senhaUsuario from usuario where loginUsuario = ? and senhaUsuario = ?";
          try {
           stmt = this.conexao.prepareStatement(sql);
           stmt.setString(1, loginUsuario);
            stmt.setString(2, senhaUsuario);
            linha = stmt.executeQuery();
            while(linha.next()){
              existe = true;
          }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no SQL" + e.getMessage());

        }
          return existe;
    }

   
   public boolean loginAdmin(String loginUsuario){
        boolean existe = false;
        String sql = "select loginUsuario from usuario where loginUsuario = admin";
          try {
           stmt = this.conexao.prepareStatement(sql);
           stmt.setString(1, loginUsuario);
            linha = stmt.executeQuery();
            while(linha.next()){
              existe = true;
          }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no SQL" + e.getMessage());

        }
          return existe;
    }
}
