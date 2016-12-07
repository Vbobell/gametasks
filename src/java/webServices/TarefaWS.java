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
import regraNegocio.TarefaRN;
import modelos.EntidadeTarefa;

@Path("tarefas")
public class TarefaWS {

    @EJB
    private TarefaRN tarefaRN;

    @Context
    private UriInfo context;

    public TarefaWS() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<EntidadeTarefa> getTarefas(@Context final HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return tarefaRN.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public EntidadeTarefa getTarefa(@PathParam("id") long id,@Context final HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return tarefaRN.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void adicionarTarefa(EntidadeTarefa t, @Context final HttpServletResponse response) {
        tarefaRN.create(t);
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
    public void alterarTarefa(@PathParam("id") long id, EntidadeTarefa tarefa) {
        EntidadeTarefa t =tarefaRN.find(id);
        t.setTitulo(tarefa.getTitulo());
        t.setDescricao(tarefa.getDescricao());
        t.setValor(tarefa.getValor());
        t.setStatus(tarefa.getStatus());
        tarefaRN.edit(t);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public EntidadeTarefa removerTarefa(@PathParam("id") long id) {
        EntidadeTarefa t =tarefaRN.find(id);
        tarefaRN.remove(t);
        return t;
    }
}
