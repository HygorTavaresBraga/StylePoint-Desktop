
package dao;

import conexao.Conexao;
import entidade.Locacao;
import java.sql.*;
import javax.swing.JOptionPane;


public class LocacaoDao extends Conexao{
    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet linha = null;
    
    public LocacaoDao() {
        this.conexao = Conexao.conexao();

    }

    
    public void adicionar(Locacao locacao) {
        String sql = "insert into locacoes(idCliente,idRoupa,dataLocacao,dataDevolucao,observacao,valorTotal) values (?,?,?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, locacao.getIdCliente());
            stmt.setInt(2, locacao.getIdRoupa());
            stmt.setString(3, locacao.getDataLocacao());
            stmt.setString(4, locacao.getDataDevolucao());
            stmt.setString(5, locacao.getObservacao());
            stmt.setDouble(6, locacao.getValorTotal());
            
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage());
        }
    }

    public Locacao consultar(String dataLocacao) {
        try {
            Locacao locacao = new Locacao();
            stmt = conexao.prepareStatement("select * from locacoes where dataLocacao = ?");
            stmt.setString(1, dataLocacao);
            linha = stmt.executeQuery();
            
            if (linha.next()) {
                locacao.setIdCliente(linha.getInt("idCliente"));
                locacao.setIdRoupa(linha.getInt("idRoupa"));
                locacao.setDataLocacao(linha.getString("dataLocacao"));
                locacao.setDataDevolucao(linha.getString("dataDevolucao"));
                locacao.setObservacao(linha.getString("observacao"));
                locacao.setValorTotal(linha.getDouble("valorTotal"));
                return locacao;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public void buscalocacao(Locacao l){
       try{
           
           PreparedStatement p = conexao.prepareStatement
        ("select * from locacao where idCliente = '"+l.getIdCliente()+"';" );

           linha = p.executeQuery();

           if(linha.first()){

                //JOptionPane.showMessageDialog(null, c.getIdCliente());
                //JOptionPane.showMessageDialog(null, c.getNomeCliente());
                l.setIdLocacao(linha.getInt("idLocacao"));
                l.setIdCliente(linha.getInt("idCliente"));
                l.setIdRoupa(linha.getInt("idRoupa"));
                l.setDataLocacao(linha.getString("dataLocacao"));                
                l.setDataDevolucao(linha.getString("dataDevolucao"));
                l.setObservacao(linha.getString("observacao"));
                l.setValorTotal(linha.getDouble("valorTotal"));            
               
           }
           else{
               JOptionPane.showMessageDialog(null,"Locacao não encontrada!");
               
           }           
           
          p.close(); 
       } 
       catch(SQLException erro){
           
           throw new RuntimeException(erro);
       }        
        
        
    }
    

    public void atualizar(Locacao locacao) {
        try {
            stmt = conexao.prepareStatement("update locacoes set dataDevolucao = ?,observacao = ?,valorTotal = ? where dataLocacao = ?");
            stmt.setString(1, locacao.getDataDevolucao());
            stmt.setString(2, locacao.getObservacao());
            stmt.setDouble(3, locacao.getValorTotal());
            stmt.setString(4, locacao.getDataLocacao());
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no SQL " + e.getMessage());

        }
    }

    public boolean excluir(String jdataLocacao) {
        try{
            stmt = conexao.prepareStatement("delete from locacoes where dataLocacao = ?");
            stmt.setString(1,jdataLocacao);
            stmt.executeUpdate();
            return  true;
            }catch(Exception e){
                return false;
            }
        }


}

