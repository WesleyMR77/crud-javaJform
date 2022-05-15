
package dao;

import java.util.List;
import model.Cliente;

public interface DaoCliente {
    public void salvarCliente(Cliente c);
    public void alterarCliente(Cliente c);
    public void excluirCliente(int id);
    public List<Cliente> getCliente();    
}
