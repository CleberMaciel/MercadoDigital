/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import DAO.ItemVendaDAO;
import MB.VendaBean;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import modelo.ItemVenda;
import modelo.Venda;

/**
 * REST Web Service
 *
 * @author zod
 */
@Path("notafiscal")
public class NotaFiscal {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of NotaFiscal
     */
    public NotaFiscal() {
    }

    /**
     * Retrieves representation of an instance of ws.NotaFiscal
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        return "teste";
    }
    @GET
    @Produces("application/json")
    @Path("listarItens")
    public String listaVenda() {
        List<ItemVenda> lista;
        ItemVendaDAO dao = new ItemVendaDAO();
        
        lista = dao.listar();
        
        Gson g = new Gson();
        return g.toJson(lista);
    }

    /**
     * PUT method for updating or creating an instance of NotaFiscal
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
