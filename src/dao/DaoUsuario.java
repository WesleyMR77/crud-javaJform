
package dao;

import java.util.List;
import model.Usuario;

public interface DaoUsuario {
    public void salvarUsuario(Usuario u);
    public void alterarUsuario(Usuario u);
    public void excluirUsuario(int id);
    public List<Usuario> getUsuarios();
    
    
}
