
package dao;

import conexao.Conexao;
import entidade.Estoque;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class EstoqueDao extends Conexao{
    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet linha = null;
    
    public EstoqueDao() {
        this.conexao = Conexao.conexao();

    }

    public List<Estoque> PreencheEstoque(){
        try{
                   
         
            PreparedStatement p = conexao.prepareStatement("select * from estoque");
            linha = p.executeQuery();
             List<Estoque>estoque = new ArrayList<Estoque>();
            while(linha.next()){
               
                Estoque rou = new Estoque();
                rou.setIdRoupa(linha.getInt("idRoupa"));
                rou.setNomeRoupa(linha.getString("nomeRoupa"));
                rou.setDescricao(linha.getString("descricao"));
                rou.setPreco(linha.getDouble("preco"));
                rou.setTamanho(linha.getString("tamanho"));
                rou.setCor(linha.getString("cor"));  
                estoque.add(rou);
               
            }
           
            return estoque;
           
        }
            catch(SQLException erro){
            throw new RuntimeException(erro);  
        }          
    }
    
    public void adicionar(Estoque estoque) {
        String sql = "insert into estoque(nomeRoupa,descricao,preco,tamanho,cor)values(?,?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, estoque.getNomeRoupa());
            stmt.setString(2, estoque.getDescricao());
            stmt.setDouble(3, estoque.getPreco());
            stmt.setString(4, estoque.getTamanho());
            stmt.setString(5, estoque.getCor());
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no comando SQL" + e.getMessage());
        }
    }

    public Estoque consultar(String nomeRoupa) {
        try {
            Estoque estoques = new Estoque();
            stmt = conexao.prepareStatement("select * from estoque where nomeRoupa = ?");
            stmt.setString(1, nomeRoupa);
            linha = stmt.executeQuery();
            
            if (linha.next()) {
                estoques.setIdRoupa(linha.getInt("idRoupa"));
                estoques.setNomeRoupa(linha.getString("nomeRoupa"));
                estoques.setDescricao(linha.getString("descricao"));
                estoques.setPreco(linha.getDouble("preco"));
                estoques.setTamanho(linha.getString("tamanho"));
                estoques.setCor(linha.getString("cor"));
                return estoques;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public Estoque consultarNR(String roupa) {
        try {
            Estoque estoque = new Estoque();
            stmt = conexao.prepareStatement("select * from estoque where nomeRoupa = ?");
            stmt.setString(1, roupa);
            linha = stmt.executeQuery();
            
            if (linha.next()){
                estoque.setIdRoupa(linha.getInt("idRoupa"));
                estoque.setNomeRoupa(linha.getString("nomeRoupa"));
                estoque.setDescricao(linha.getString("descricao"));
                estoque.setPreco(linha.getDouble("preco"));
                estoque.setTamanho(linha.getString("tamanho"));
                estoque.setCor(linha.getString("cor"));
                return estoque;               
                
  
            } else {
                return null;
            }
            
          
        } catch (Exception e) {
            return null;
        }
    }
    
    public void buscanomeR(Estoque e){
       try{
           
           PreparedStatement p = conexao.prepareStatement
        ("select * from estoque where nomeRoupa = '"+e.getNomeRoupa()+"';");
           
           linha = p.executeQuery();
           
           if(linha.first()){
                //JOptionPane.showMessageDialog(null, e.getIdRoupa());
                //JOptionPane.showMessageDialog(null, e.getNomeRoupa());
                e.setIdRoupa(linha.getInt("idRoupa"));
                e.setNomeRoupa(linha.getString("nomeRoupa"));
                e.setDescricao(linha.getString("descricao"));
                e.setPreco(linha.getDouble("preco"));
                e.setTamanho(linha.getString("tamanho"));
                e.setCor(linha.getString("cor"));
               
           }else{
               JOptionPane.showMessageDialog(null,"Roupa não Encontrada");
               
           }           
           
          p.close(); 
       } 
       catch(SQLException erro){
           
           throw new RuntimeException(erro);
       }        
        
        
    }

    public void atualizar(Estoque estoque) {
        try {
            stmt = conexao.prepareStatement("update estoque set descricao = ?,preco = ?,tamanho = ?,cor = ? where nomeRoupa = ?");
            stmt.setString(1, estoque.getDescricao());
            stmt.setDouble(2, estoque.getPreco());
            stmt.setString(3, estoque.getTamanho());
            stmt.setString(4, estoque.getCor());
            stmt.setString(5, estoque.getNomeRoupa());
            
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no SQL" + e.getMessage());

        }
    }

    public boolean excluir(String jnome) {
try{
    stmt = conexao.prepareStatement("delete from estoque where nomeRoupa = ?");
    stmt.setString(1,jnome);
    stmt.executeUpdate();
    return  true;
    }catch(Exception e){
        return false;
    }
}
}
