/*
 * @author Erlandson
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.ProdutoAbaixoDoEstoque;

public class ProdutoAbaixoDoEstoqueDAO {

    private final Connection conexao;

    public ProdutoAbaixoDoEstoqueDAO() {
        this.conexao = Conecta.getInstance().getConnection();
    }

    public List<ProdutoAbaixoDoEstoque> listarProdutoAbaixoDoEstoque() {

        String sql = "select * from produto where qtd_atual <= estoque_min";
        List<ProdutoAbaixoDoEstoque> produtos;
        produtos = new ArrayList<>();

        try {

            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                ProdutoAbaixoDoEstoque p = new ProdutoAbaixoDoEstoque();

                p.setProduto_id(rs.getString("produto_id"));
                p.setDescricao(rs.getString("descricao"));
                p.setQtd_atual(rs.getString("qtd_atual"));

                produtos.add(p);
            }

        } catch (SQLException e) {

            throw new RuntimeException();
        }
        return produtos;
    }

}
