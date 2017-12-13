/**
 *@author Erlandson
 */
package modelo;

public class ProdutoAbaixoDoEstoque {

    String produto_id;
    String descricao;
    String qtd_atual;

    public String getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(String produto_id) {
        this.produto_id = produto_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getQtd_atual() {
        return qtd_atual;
    }

    public void setQtd_atual(String qtd_atual) {
        this.qtd_atual = qtd_atual;
    }

}
