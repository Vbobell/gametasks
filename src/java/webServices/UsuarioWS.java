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
import regraNegocio.UsuarioRN;
import modelos.EntidadeUsuario;

@Path("usuarios")
public class UsuarioWS {

    @EJB
    private UsuarioRN usuarioRN;

    @Context
    private UriInfo context;

    public UsuarioWS() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<EntidadeUsuario> getUsuarios(@Context final HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return usuarioRN.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public EntidadeUsuario getUsuario(@PathParam("id") long id,@Context final HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return usuarioRN.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void adicionarUsuario(EntidadeUsuario u, @Context final HttpServletResponse response) {
        usuarioRN.salvar(u);
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
    public void alterarUsuario(@PathParam("id") long id, EntidadeUsuario usuario) {
        EntidadeUsuario u =usuarioRN.find(id);
        u.setNome(usuario.getNome());
        u.setCpf(usuario.getCpf());
        u.setFuncao(usuario.getFuncao());
        u.setSenha(usuario.getSenha());
        usuarioRN.edit(u);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public EntidadeUsuario removerUsuario(@PathParam("id") long id) {
        EntidadeUsuario u =usuarioRN.find(id);
        usuarioRN.remove(u);
        return u;
    }
}
