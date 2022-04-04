
package conexao;

import java.sql.*;


public class Conexao {
    public static Connection conexao(){
        Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost/stylepoint";
        String usuario ="root";
        String senha ="";
        try{
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            return conexao;
        }catch(ClassNotFoundException | SQLException e){
            return null;
        }
    }
}
