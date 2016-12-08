/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import regraNegocio.QuadroRN;
import modelos.EntidadeQuadroTarefa;

/**
 * REST Web Service
 *
 * @author vinic
 */
@Path("QuadroTarefa")
public class QuadroTarefaWS {

    
    @EJB
    private QuadroRN quadroRN;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of QuadroTarefaWS
     */
    public QuadroTarefaWS() {
    }

    /**
     * Retrieves representation of an instance of webServices.QuadroTarefaWS
     * @param response
     * @return an instance of modelos.EntidadeQuadroTarefa
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<EntidadeQuadroTarefa> getQuadroTarefa(@Context final HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return quadroRN.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public EntidadeQuadroTarefa getQuadroTarefa(@PathParam("id") long id,@Context final HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return quadroRN.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void adicionarQuadroTarefa(EntidadeQuadroTarefa qt, @Context final HttpServletResponse response) {
        quadroRN.create(qt);
        //Alterar o codigo para 201 (Created)
        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException e) {
            //Erro 500
            throw new InternalServerErrorException();
        }

    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_XML)
    public void alterarQuadroTarefa(@PathParam("id") long id, EntidadeQuadroTarefa quadroTarefa) {
        EntidadeQuadroTarefa qt =quadroRN.find(id);
        qt.setUsuario(quadroTarefa.getUsuario());
        qt.setTarefa(quadroTarefa.getTarefa());
        quadroRN.edit(qt);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public EntidadeQuadroTarefa removerQuadroTarefa(@PathParam("id") long id) {
        EntidadeQuadroTarefa qt =quadroRN.find(id);
        quadroRN.remove(qt);
        return qt;
    }
}
