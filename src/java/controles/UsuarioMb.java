/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import estruturas.RegistroUsuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelos.Usuario;

/**
 *
 * @author vinic
 */
@Named(value = "usuarioMb")
@SessionScoped

public class UsuarioMb implements Serializable {

    private boolean logado;
    private Usuario usuario;
    
    @Inject
    RegistroUsuario registroUsuario;
    //private UsuarioDao registro;

    public UsuarioMb() { 
        usuario = new Usuario();
        logado = false;
    }

    public boolean isLogado() {
        return logado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String verificaLogin() {
        if (registroUsuario.buscarUsuarioLogin(usuario) == false) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login inválido"," Usuário ou senha está errado!");
            contexto.addMessage(null, mensagem);
            return ("index");
        } else {
            if(!usuario.getNome().equals("admin")){
                logado = true;
                return ("usuario?faces-redirect=true");
            }else{
                logado = true;
                return ("administracao?faces-redirect=true");
            }
        }
    }

    public String realizaLogout() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getExternalContext().invalidateSession();
        logado = false;
        return ("index?faces-redirect=true");
    }

}
