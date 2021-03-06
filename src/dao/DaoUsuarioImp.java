/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Afranio
 */
public class DaoUsuarioImp implements DaoUsuario {

    Connection con = null;
    PreparedStatement pstm = null;

    @Override
    public void salvarUsuario(Usuario u) {
        con = new Conexao().getConnection();
        String sqlinsert = "INSERT INTO tb_usuario(nome_usuario,senha_usuario,email_usuario,status_usuario)values(?,?,?,?)";
        try {
            pstm = con.prepareStatement(sqlinsert);
            pstm.setString(1, u.getNome());
            pstm.setString(2, u.getSenha());
            pstm.setString(3, u.getEmail());
            pstm.setInt(4, u.getStatus());
            pstm.execute();
            pstm.close();
        } catch (SQLException inserterr) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir usuário no banco de dados " + inserterr + " SQL: " + sqlinsert);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao inserir usuário" + closerr);
            }

        }

    }

    @Override
    public void alterarUsuario(Usuario u) {
        con = new Conexao().getConnection();
        String sqlatu = "update tb_usuario set nome_usuario=?,senha_usuario=?,email_usuario=?, status_usuario=? where id_usuario=?";
        try {
            pstm = con.prepareStatement(sqlatu);
            pstm.setString(1, u.getNome());
            pstm.setString(2, u.getSenha());
            pstm.setString(3, u.getEmail());
            pstm.setInt(4, u.getStatus());
            pstm.setInt(5, u.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException atuerr) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário no banco de dados " + atuerr + " SQL: " + sqlatu);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao inserir usuário" + closerr);
            }

        }
    }

    @Override
    public void excluirUsuario(int id) {
      con = new Conexao().getConnection();
        String sqldel = "delete from tb_usuario where id_usuario=?";
        try {
            pstm = con.prepareStatement(sqldel);
            pstm.setInt(1, id);
            pstm.execute();
            pstm.close();
        } catch (SQLException delerr) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário no banco de dados " + delerr + " SQL: " + sqldel);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao excluir usuário" + closerr);
            }

        }
    }

    @Override
    public List<Usuario> getUsuarios() {
        con = new Conexao().getConnection();
        ResultSet rs = null;
        List<Usuario> lista = new ArrayList<Usuario>();
        String query = "SELECT * FROM tb_usuario";
        try {
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.first()) {
                do {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id_usuario"));
                    usuario.setNome(rs.getString("nome_usuario"));
                    usuario.setSenha(rs.getString("senha_usuario"));
                    usuario.setEmail(rs.getString("email_usuario"));
                    usuario.setStatus(rs.getInt("status_usuario"));

                    lista.add(usuario);

                } while (rs.next());
            }
            pstm.close();
        } catch (SQLException buscarerr) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuarios no banco " + buscarerr);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao buscar usuário" + closerr);
            }

        }
        return lista;
    }

}
