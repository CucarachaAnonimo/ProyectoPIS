package accesoDatos;

import java.sql.*;
import java.util.logging.Level; 
import java.util.logging.Logger;
/**
 *
 * @author USUARIO
 */
public class Conexion {
    
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL =  "jdbc:mysql://localhost/proyecto";
    public static final String USER = "root";
    public static final String PASSWORD = "soporte";
    public static Conexion instancia;
    
    public Connection conectar() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public void desconectar(Connection conexion){
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void cerrarResultado(ResultSet resultado){
        try {
            resultado.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void cerrarStatemen(PreparedStatement statemen){
        try {
            statemen.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static Conexion getInstance(){
        //Se aplica el patron de diseño single
        if (instancia == null) 
            instancia = new Conexion();
        return instancia;
    }
}
