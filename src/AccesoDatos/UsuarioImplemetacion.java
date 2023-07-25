package AccesoDatos;

import Modelo.Usuario;
import accesoDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class UsuarioImplemetacion implements DaoUsuario{
    
    Conexion instanciaMySQL = Conexion.getInstance();

    @Override
    public boolean guardar(Usuario usuario) {
       PreparedStatement consulta = null;
        Connection conexion = null;
        try {
            conexion = (Connection) instanciaMySQL.conectar();
            consulta = conexion.prepareStatement("insert into usuario(nombre, apellido, correo, contraseña) values(?,?,?,?)");
            consulta.setString(1, usuario.getNombre());
            consulta.setString(2, usuario.getApellido());
            consulta.setString(3, usuario.getCorreo());
            consulta.setString(4, usuario.getContraseña());
            consulta.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false; 
    }

    @Override
    public List<Usuario> buscarTodos() {
        
        List<Usuario> lista = new ArrayList<Usuario>();
        PreparedStatement consulta = null;
        Connection conexion = null;
        try {
            conexion = instanciaMySQL.conectar();
            consulta = conexion.prepareStatement("select * from usuario");
            ResultSet rs = consulta.executeQuery();
            while(rs.next()){
                Usuario user = new Usuario(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                lista.add(user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean eliminar(String correo) {
        PreparedStatement consulta = null;
        Connection conexion = null;
        try {
            conexion = (Connection) instanciaMySQL.conectar();
            consulta = conexion.prepareStatement("delete from usuario where correo = ?");
            consulta.setString(1, correo);
            consulta.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
}
