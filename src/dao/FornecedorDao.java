
package dao;

import conexao.Conexao;
import entidade.Fornecedor;
import java.sql.*;
import javax.swing.JOptionPane;


public class FornecedorDao extends Conexao{
    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet linha = null;
    
    public FornecedorDao() {
        this.conexao = Conexao.conexao();

    }

    public void adicionar(Fornecedor fornecedor) {
        String sql = "insert into fornecedores(razaoSocial,cnpj,enderecoFornecedor,telefoneFornecedor,emailFornecedor) values (?,?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, fornecedor.getRazaoSocial());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getEnderecoFornecedor());
            stmt.setString(4, fornecedor.getTelefoneFornecedor());
            stmt.setString(5, fornecedor.getEmailFornecedor());
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no comando SQL" + e.getMessage());
        }
    }

    public Fornecedor consultar(String cnpj) {
        try {
            Fornecedor fornecedores = new Fornecedor();
            stmt = conexao.prepareStatement("select * from fornecedores where cnpj = ?");
            stmt.setString(1, cnpj);
            linha = stmt.executeQuery();
            
            if (linha.next()) {
                fornecedores.setIdFornecedor(linha.getInt("idFornecedor"));
                fornecedores.setRazaoSocial(linha.getString("razaoSocial"));
                fornecedores.setCnpj(linha.getString("cnpj"));
                fornecedores.setEnderecoFornecedor(linha.getString("enderecoFornecedor"));
                fornecedores.setTelefoneFornecedor(linha.getString("telefoneFornecedor"));
                fornecedores.setEmailFornecedor(linha.getString("emailFornecedor"));
                return fornecedores;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void atualizar(Fornecedor fornecedor) {
        try {
            stmt = conexao.prepareStatement("update fornecedores set razaoSocial = ?,enderecoFornecedor = ?,telefoneFornecedor = ?,emailFornecedor = ? where cnpj = ?");
            stmt.setString(1, fornecedor.getRazaoSocial());
            stmt.setString(2, fornecedor.getEnderecoFornecedor());
            stmt.setString(3, fornecedor.getTelefoneFornecedor());
            stmt.setString(4, fornecedor.getEmailFornecedor());
            stmt.setString(5, fornecedor.getCnpj());
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no SQL" + e.getMessage());

        }
    }

    public boolean excluir(String cnpj) {
try{
    stmt = conexao.prepareStatement("delete from fornecedores where cnpj = ?");
    stmt.setString(1,cnpj);
    stmt.executeUpdate();
    return  true;
    }catch(Exception e){
        return false;
    }
}
}
