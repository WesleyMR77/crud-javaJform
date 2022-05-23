package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;

public class DaoClienteImp implements DaoCliente{
    Connection con = null;
    PreparedStatement pstm = null;

    @Override
    public void salvarCliente(Cliente c) {
        con = new Conexao().getConnection();
        String sqlinsert = "INSERT INTO tb_cliente(nome_cliente,cpf_cliente,rg_cliente,endereco_cliente, cep_cliente, descricao_cliente)values(?,?,?,?,?,?)";
        try {
            pstm = con.prepareStatement(sqlinsert);
            pstm.setString(1, c.getNome());
            pstm.setString(2, c.getCpf());
            pstm.setString(3, c.getRg());
            pstm.setString(4, c.getEndereco());
            pstm.setString(5, c.getCep());
            pstm.setString(6, c.getDescricao());

            pstm.execute();
            pstm.close();
        } catch (SQLException inserterr) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir cliente no banco de dados " + inserterr + " SQL: " + sqlinsert);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao inserir cliente" + closerr);
            }

        }

    }

    public void alterarCliente(Cliente c){
 con = new Conexao().getConnection();
        String sqlatu = "update tb_cliente set nome_cliente=?,cpf_cliente=?,rg_cliente=?, endereco_cliente=?, cep_cliente=?, descricao_cliente=?  where id_cliente=?";
        try {
            pstm = con.prepareStatement(sqlatu);
            pstm.setString(1, c.getNome());
            pstm.setString(2, c.getCpf());
            pstm.setString(3, c.getRg());
            pstm.setString(4, c.getEndereco());
            pstm.setString(5, c.getCep());
            pstm.setString(6, c.getDescricao());
            pstm.setInt(7, c.getId());
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
    public void excluirCliente(int id){
      con = new Conexao().getConnection();
        String sqldel = "delete from tb_cliente where id_cliente=?";
        try {
            pstm = con.prepareStatement(sqldel);
            pstm.setInt(1, id);
            pstm.execute();
            pstm.close();
        } catch (SQLException delerr) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente no banco de dados " + delerr + " SQL: " + sqldel);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao excluir cliente" + closerr);
            }

        }        
    }
    
    @Override
    public List<Cliente> getCliente() {
        con = new Conexao().getConnection();
        ResultSet rs = null;
        List<Cliente> lista = new ArrayList<Cliente>();
        String query = "SELECT * FROM tb_cliente";
        try {
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.first()) {
                do {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("id_cliente"));
                    cliente.setNome(rs.getString("nome_cliente"));
                    cliente.setCpf(rs.getString("cpf_cliente"));
                    cliente.setRg(rs.getString("rg_cliente"));
                    cliente.setEndereco(rs.getString("endereco_cliente"));
                    cliente.setCep(rs.getString("cep_cliente"));
                    cliente.setDescricao(rs.getString("descricao_cliente"));


                    lista.add(cliente);

                } while (rs.next());
            }
            pstm.close();
        } catch (SQLException buscarerr) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar clientes no banco " + buscarerr);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao buscar cliente" + closerr);
            }
        }
        return lista;
    }
}
