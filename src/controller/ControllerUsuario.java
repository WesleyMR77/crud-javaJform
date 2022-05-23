package controller;

import model.Usuario;
import dao.DaoUsuario;
import dao.DaoUsuarioImp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerUsuario {

    DaoUsuario dao;
    List<Usuario> lista = new ArrayList<Usuario>();

    public void acaoInserir(Usuario u) {
        if (u != null && !u.getNome().equals("") && !u.getSenha().equals("") && !u.getEmail().equals("") && u.getStatus() != 0) {
            dao = new DaoUsuarioImp();
            dao.salvarUsuario(u);
            JOptionPane.showMessageDialog(null, "Inserido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Impossível salvar preecha os campos corretamente");
        }
    }
    
    public void acaoAlterar(Usuario u) {
        if (u != null && !u.getNome().equals("") && !u.getSenha().equals("") && !u.getEmail().equals("") && u.getStatus() != 0) {
            dao = new DaoUsuarioImp();
            dao.alterarUsuario(u);
            JOptionPane.showMessageDialog(null, "alterado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Impossível alterar preecha os campos corretamente");
        }
    }
    
        public void acaoDeletar(int id) {
            dao = new DaoUsuarioImp();
            dao.excluirUsuario(id);
            JOptionPane.showMessageDialog(null, "excluido com sucesso");
    }

    public List<Usuario> getUsuarios() {
        dao = new DaoUsuarioImp();
        lista.clear();
        lista = dao.getUsuarios();
        return lista;
    }

}
