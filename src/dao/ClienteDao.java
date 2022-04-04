package dao;

import conexao.Conexao;
import entidade.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ClienteDao extends Conexao{
    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet linha = null;
    
    public ClienteDao() {
        this.conexao = Conexao.conexao();

    }

    public List<Cliente> PreencheCliente(){
        try{

            PreparedStatement p = conexao.prepareStatement("select * from clientes");
            linha = p.executeQuery();
            List<Cliente>clientes = new ArrayList<Cliente>();
            while(linha.next()){

                Cliente cli = new Cliente();
                cli.setIdCliente(linha.getInt("idCliente"));
                cli.setNomeCliente(linha.getString("nomeCliente"));
                cli.setEnderecoCliente(linha.getString("enderecoCliente"));
                cli.setTelefoneCliente(linha.getString("telefoneCliente"));
                cli.setCpfCliente(linha.getString("cpfCliente"));
                cli.setEmailCliente(linha.getString("emailCliente"));
                cli.setDataNascimentoCliente(linha.getString("dataNascimentoCliente"));
                clientes.add(cli);
            }
           
            return clientes;
           
        }
            catch(SQLException erro){
            throw new RuntimeException(erro);
        }          
    }
    
    public void adicionar(Cliente cliente) {
        String sql = "insert into clientes(nomeCliente,enderecoCliente,telefoneCliente,cpfCliente,emailCliente,dataNascimentoCliente)values(?,?,?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getEnderecoCliente());
            stmt.setString(3, cliente.getTelefoneCliente());
            stmt.setString(4, cliente.getCpfCliente());
            stmt.setString(5, cliente.getEmailCliente());
            stmt.setString(6, cliente.getDataNascimentoCliente());
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no comando SQL" + e.getMessage());
        }
    }

    public Cliente consultar(String cpf) {
        try {
            Cliente clientes = new Cliente();
            stmt = conexao.prepareStatement("select * from clientes where cpfCliente = ?");
            stmt.setString(1, cpf);
            linha = stmt.executeQuery();
            
            if (linha.next()) {
                clientes.setIdCliente(linha.getInt("idCliente"));
                clientes.setNomeCliente(linha.getString("nomeCliente"));
                clientes.setEnderecoCliente(linha.getString("enderecoCliente"));
                clientes.setTelefoneCliente(linha.getString("telefoneCliente"));
                clientes.setCpfCliente(linha.getString("cpfCliente"));
                clientes.setEmailCliente(linha.getString("emailCliente"));
                clientes.setDataNascimentoCliente(linha.getString("dataNascimentoCliente"));
                return clientes;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

     public Cliente consultarNC(String nome) {
        try {
            Cliente clientes = new Cliente();
            stmt = conexao.prepareStatement("select * from clientes where nomeCliente = ?");
            stmt.setString(1, nome);
            linha = stmt.executeQuery();
            
            if (linha.next()){
                clientes.setIdCliente(linha.getInt("idCliente"));
                clientes.setNomeCliente(linha.getString("nomeCliente"));
                clientes.setEnderecoCliente(linha.getString("enderecoCliente"));
                clientes.setTelefoneCliente(linha.getString("telefoneCliente"));
                clientes.setCpfCliente(linha.getString("cpfCliente"));
                clientes.setEmailCliente(linha.getString("emailCliente"));
                clientes.setDataNascimentoCliente(linha.getString("dataNascimentoCliente"));
                return clientes;               
                
  
            } else {
                return null;
            }
            
          
        } catch (Exception e) {
            return null;
        }
    }
     
     
     public void buscanome(Cliente c){
       try{
           
           PreparedStatement p = conexao.prepareStatement
        ("select * from clientes where nomeCliente = '"+c.getNomeCliente()+"';");

           linha = p.executeQuery();

           if(linha.first()){

                //JOptionPane.showMessageDialog(null, c.getIdCliente());
                //JOptionPane.showMessageDialog(null, c.getNomeCliente());
                c.setIdCliente(linha.getInt("idCliente"));
                c.setNomeCliente(linha.getString("nomeCliente"));                
                c.setEnderecoCliente(linha.getString("enderecoCliente"));
                c.setTelefoneCliente(linha.getString("telefoneCliente"));
                c.setCpfCliente(linha.getString("cpfCliente"));
                c.setEmailCliente(linha.getString("emailCliente"));
                c.setDataNascimentoCliente(linha.getString("dataNascimentoCliente"));              
               
           }
           else{
               JOptionPane.showMessageDialog(null,"Cliente Não Encontrado");
               
           }           
           
          p.close(); 
       } 
       catch(SQLException erro){
           
           throw new RuntimeException(erro);
       }        
        
        
    }
    
    public void atualizar(Cliente cliente) {
        try {
            stmt = conexao.prepareStatement("update clientes set nomeCliente = ?,dataNascimentoCliente = ?,enderecoCliente = ?,telefoneCliente = ?,emailCliente = ? where cpfCliente = ?");
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getDataNascimentoCliente());
            stmt.setString(3, cliente.getEnderecoCliente());
            stmt.setString(4, cliente.getTelefoneCliente());
            stmt.setString(5, cliente.getEmailCliente());
            stmt.setString(6, cliente.getCpfCliente());
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no SQL" + e.getMessage());

        }
    }

    public boolean excluir(String cpf) {
try{
    stmt = conexao.prepareStatement("delete from clientes where cpfCliente = ?");
    stmt.setString(1,cpf);
    stmt.executeUpdate();
    return  true;
    }catch(Exception e){
        return false;
    }
}
}
