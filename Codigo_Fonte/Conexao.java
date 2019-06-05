package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {
    
    public Connection connection;
   
    public Conexao(){
        Driver();
        DBConnect();
    }
    public void Driver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Carregar o Driver");
        }
    }
    
    public void DBConnect(){
        try{
            String url="jdbc:mysql://localhost:3306/cemiterio";
            connection = (Connection) DriverManager.getConnection(url, "root", "");
            
        }catch (Exception a){
            JOptionPane.showMessageDialog(null, "Erro Na Base de Dados", "Mensagem Do Programa", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ResultSet ExecutarUID(String comando) throws SQLException {
	Statement statement;
	ResultSet rSet = null;
	statement = (Statement) connection.createStatement();
	statement.executeUpdate(comando);

	return rSet;
    }
		

    public ResultSet ExecutarSQL(String comando) throws SQLException {
	Statement statement;
	ResultSet rSet = null;

	statement = (Statement) connection.createStatement();
	rSet = statement.executeQuery(comando);

	return rSet;
    }

     public void commit() throws SQLException {
	connection.commit();
    }

    
    public static void main (String [] a){
        new Conexao();
    }
}
