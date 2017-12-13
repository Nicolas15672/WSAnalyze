/**
 * @author Erlandson
 */
package webservice;

import com.google.gson.Gson;
import dao.ProdutoAbaixoDoEstoqueDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import modelo.ProdutoAbaixoDoEstoque;

@Path("estoque")
public class Estoque {

    @Context
    private UriInfo context;

    public Estoque() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ProdutoAbaixoDoEstoque/Lista")
    public String listarProdutoAbaixoDoEstoque() {

        List<ProdutoAbaixoDoEstoque> lista;

        ProdutoAbaixoDoEstoqueDAO dao = new ProdutoAbaixoDoEstoqueDAO();

        lista = dao.listarProdutoAbaixoDoEstoque();

        Gson g = new Gson();
        return g.toJson(lista);

    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
