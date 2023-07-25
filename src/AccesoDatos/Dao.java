package AccesoDatos;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface Dao <T>{
    
    public boolean guardar(T t);
    public List<T> buscarTodos();
    public boolean eliminar(String t);
}
