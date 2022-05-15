
package dao;

import java.util.List;
import model.Produto;

public interface DaoProduto {

    public void salvarProduto(Produto p);
    public void alterarProduto(Produto p);
    public void excluirProduto(int id);
    public List<Produto> getProduto();    
}
