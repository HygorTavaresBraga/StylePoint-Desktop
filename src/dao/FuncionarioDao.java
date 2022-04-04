
package dao;

import conexao.Conexao;
import entidade.Funcionario;
import java.sql.*;
import javax.swing.JOptionPane;


public class FuncionarioDao extends Conexao{
    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet linha = null;
    
    public FuncionarioDao() {
        this.conexao = Conexao.conexao();

    }

    public void adicionar(Funcionario funcionario) {
        String sql = "insert into funcionarios(nomeFuncionario,dataNascimentoFuncionario,dataAdmissao,cpfFuncionario,enderecoFuncionario,telefoneFuncionario,emailFuncionario) values (?,?,?,?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getNomeFuncionario());
            stmt.setString(2, funcionario.getDataNascimentoFuncionario());
            stmt.setString(3, funcionario.getDataAdmissao());
            stmt.setString(4, funcionario.getCpfFuncionario());
            stmt.setString(5, funcionario.getEnderecoFuncionario());
            stmt.setString(6, funcionario.getTelefoneFuncionario());
            stmt.setString(7, funcionario.getEmailFuncionario());
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no comando SQL" + e.getMessage());
        }
    }

    public Funcionario consultar(String cpfFuncionario) {
        try {
            Funcionario funcionarios = new Funcionario();
            stmt = conexao.prepareStatement("select * from funcionarios where cpfFuncionario = ?");
            stmt.setString(1, cpfFuncionario);
            linha = stmt.executeQuery();
            
            if (linha.next()) {
                funcionarios.setIdFuncionario(linha.getInt("idFuncionario"));
                funcionarios.setNomeFuncionario(linha.getString("nomeFuncionario"));
                funcionarios.setDataNascimentoFuncionario(linha.getString("dataNascimentoFuncionario"));
                funcionarios.setDataAdmissao(linha.getString("dataAdmissao"));
                funcionarios.setCpfFuncionario(linha.getString("cpfFuncionario"));
                funcionarios.setEnderecoFuncionario(linha.getString("enderecoFuncionario"));
                funcionarios.setTelefoneFuncionario(linha.getString("telefoneFuncionario"));
                 funcionarios.setEmailFuncionario(linha.getString("emailFuncionario"));
                return funcionarios;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void atualizar(Funcionario funcionario) {
        try {
            stmt = conexao.prepareStatement("update funcionarios set nomeFuncionario = ?,dataNascimentoFuncionario = ?,dataAdmissao = ?,enderecoFuncionario = ?, telefoneFuncionario = ?,emailFuncionario = ? where cpfFuncionario = ?");
            stmt.setString(1, funcionario.getNomeFuncionario());
            stmt.setString(2, funcionario.getDataNascimentoFuncionario());
            stmt.setString(3, funcionario.getDataAdmissao());
            stmt.setString(4, funcionario.getEnderecoFuncionario());
            stmt.setString(5, funcionario.getTelefoneFuncionario());
            stmt.setString(6, funcionario.getEmailFuncionario());
            stmt.setString(7, funcionario.getCpfFuncionario());
            
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no SQL " + e.getMessage());

        }
    }

    public boolean excluir(String cpfFuncionario) {
try{
    stmt = conexao.prepareStatement("delete from funcionarios where cpfFuncionario = ?");
    stmt.setString(1,cpfFuncionario);
    stmt.executeUpdate();
    return  true;
    }catch(Exception e){
        return false;
    }
}
}
