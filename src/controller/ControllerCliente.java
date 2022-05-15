package controller;

import dao.DaoCliente;
import dao.DaoClienteImp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;

public class ControllerCliente {
  
DaoCliente dao;
    List<Cliente> lista = new ArrayList<Cliente>();

    public void acaoInserir(Cliente c) {
        if (c != null && !c.getNome().equals("")) {
            dao = new DaoClienteImp();
            dao.salvarCliente(c);
            JOptionPane.showMessageDialog(null, "Inserido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Impossível salvar preecha os campos corretamente");
        }
    }

    public List<Cliente> getCliente() {
        dao = new DaoClienteImp();
        lista.clear();
        lista = dao.getCliente();
        return lista;
    }
}
