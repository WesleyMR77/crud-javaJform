package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;

public class DaoProdutoImp implements DaoProduto{
    
    Connection con = null;
    PreparedStatement pstm = null;
    
    @Override
    public void salvarProduto(Produto p) {
        con = new Conexao().getConnection();
        String sqlinsert = "INSERT INTO tb_produto(nome_produto,fornecedor_produto,cnpj_produto,tipo_produto, quantidade_produto)values(?,?,?,?,?)";
        try {
            pstm = con.prepareStatement(sqlinsert);
            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getFornecedor());
            pstm.setString(3, p.getCnpj());
            pstm.setString(4, p.getTipo());
            pstm.setInt(5, p.getQuantidade());
            pstm.execute();
            pstm.close();
        } catch (SQLException inserterr) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir produto no banco de dados " + inserterr + " SQL: " + sqlinsert);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao inserir produto" + closerr);
            }

        }
    }

    @Override
    public void alterarProduto(Produto p) {
        con = new Conexao().getConnection();
        String sqlatu = "update tb_produto set nome_produto=?,fornecedor_produto=?,cnpj_produto=?, tipo_produto=?, quantidade_produto=? where id_produto=?";
        try {
            pstm = con.prepareStatement(sqlatu);
            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getFornecedor());
            pstm.setString(3, p.getCnpj());
            pstm.setString(4, p.getTipo());
            pstm.setInt(5, p.getQuantidade());
            pstm.setInt(6, p.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException atuerr) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto no banco de dados " + atuerr + " SQL: " + sqlatu);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao inserir produto" + closerr);
            }

        }
    }

    @Override
    public void excluirProduto(int id) {
         con = new Conexao().getConnection();
        String sqldel = "delete from tb_produto where id_produto=?";
        try {
            pstm = con.prepareStatement(sqldel);
            pstm.setInt(1, id);
            pstm.execute();
            pstm.close();
        } catch (SQLException delerr) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto no banco de dados " + delerr + " SQL: " + sqldel);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao excluir produto" + closerr);
            }
        }
    }

    @Override
    public List<Produto> getProduto() {
       con = new Conexao().getConnection();
        ResultSet rs = null;
        List<Produto> lista = new ArrayList<Produto>();
        String query = "SELECT * FROM tb_produto";
        try {
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.first()) {
                do {
                    Produto produto = new Produto();
                    produto.setId(rs.getInt("id_produto"));
                    produto.setNome(rs.getString("nome_produto"));
                    produto.setFornecedor(rs.getString("fornecedor_produto"));
                    produto.setCnpj(rs.getString("cnpj_produto"));
                    produto.setTipo(rs.getString("tipo_produto"));
                    produto.setQuantidade(rs.getInt("quantidade_produto"));
                    lista.add(produto);
                } while (rs.next());
            }
            pstm.close();
        } catch (SQLException buscarerr) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produtos no banco " + buscarerr);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao buscar produto" + closerr);
            }

        }
        return lista;
    }
    
    
}
