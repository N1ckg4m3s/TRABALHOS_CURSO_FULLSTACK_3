package cadastro.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectorBD {
    private static final String URL="jdbc:sqlserver://localhost:1433;databaseName=loja;encrypt=true;trustServerCertificate=true;";
    private static final String login="loja";
    private static final String senha="loja";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, login, senha);
    }

    public static PreparedStatement getPrepared(Connection conec, String sql) throws SQLException {
        return conec.prepareStatement(sql);
    }

    public static ResultSet getSelect(String sql) throws SQLException {
        Connection conexao= getConnection();
        Statement stmt= conexao.createStatement();
        return stmt.executeQuery(sql);
    }
    
    public static void close(Statement Statement) {
        if(Statement!=null){
            try{
                Statement.close();
            }catch(SQLException e){}
        }
    }
    
    public static void close(ResultSet ResultSet) {
        if(ResultSet != null){
            try{
                ResultSet.close();
            }catch(SQLException e){}
        }
    }

    public static void close(Connection conexao) {
        if(conexao != null){
            try{
                conexao.close();
            } catch(SQLException e){}
        }
    }
}
