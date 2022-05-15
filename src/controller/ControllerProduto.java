package controller;

import dao.DaoProduto;
import dao.DaoProdutoImp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;

public class ControllerProduto {
 DaoProduto dao;
    List<Produto> lista = new ArrayList<Produto>();

    public void acaoInserir(Produto p) {
        if (p != null && !p.getNome().equals("")) {
            dao = new DaoProdutoImp();
            dao.salvarProduto(p);
            JOptionPane.showMessageDialog(null, "Inserido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Impossível salvar preecha os campos corretamente");
        }
    }

    public List<Produto> getProduto() {
        dao = new DaoProdutoImp();
        lista.clear();
        lista = dao.getProduto();
        return lista;
    }
}