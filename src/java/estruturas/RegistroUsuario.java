/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelos.Usuario;

/**
 *
 * @author vinic
 */
@Named(value = "registroUsuario")
@ApplicationScoped
public class RegistroUsuario {

   private Usuario usuarioAdd;
    private List<Usuario> lista = new ArrayList();
    
    public RegistroUsuario() {
       usuarioAdd = new Usuario();
       lista.add(new Usuario("admin","12345"));
    }

    public String adicionarUsuario() {
        if (buscarUsuario(usuarioAdd) != null) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Usuario já cadastrado.");
            contexto.addMessage("idMensagem", mensagem);
            return ("administracao?faces-redirect=true");    
        } else{
            lista.add(usuarioAdd);
            this.usuarioAdd = new Usuario();
            return("administracao?faces-redirect=true");
        }
    }
    public boolean buscarUsuarioLogin(Usuario u){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNome().equalsIgnoreCase(u.getNome()) && lista.get(i).getSenha().equalsIgnoreCase(u.getSenha())) {
                System.out.println(lista.get(i).getNome() + " " + i);
                System.out.println(lista.size());
                return true;
            }
            System.out.println(lista.get(i).getNome());
            System.out.println(lista.size());
        }
        return false;
    }
    public Usuario buscarUsuario(Usuario u) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNome().equalsIgnoreCase(u.getNome())) {
                return lista.get(i);
            }
        }
        return null;
    }

    public String excluir(Usuario u) {
            lista.remove(u);
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"","Usuario removido");
            contexto.addMessage("idMensagem", mensagem);
            return ("administracao?faces-redirect=true");
        } 

    public void setList(List<Usuario> lista){
        this.lista = lista;
    }
    public List<Usuario> getLista() {
        return lista;
    }
    @Override
    public String toString() {
        return "Usuarios: \n" + lista;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuarioAdd = usuario;
    }
    
    public Usuario getUsuarioAdd() {
        return usuarioAdd;
    }
    
}
