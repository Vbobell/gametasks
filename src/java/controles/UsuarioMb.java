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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    private RegistroUsuario registros;
    //private UsuarioDao registro;

    public UsuarioMb() { 
        registros = new RegistroUsuario();
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
        if (registros.buscarUsuario(usuario) == null) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login inv�lido!", "Usu�rio ou senha est�o errados!");
            contexto.addMessage("idMensagem", mensagem);
            return ("index?faces-redirect=true");
        } else {
            logado = true;
            return ("usuario?faces-redirect=true");
        }
    }

    public String realizaLogout() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getExternalContext().invalidateSession();
        return ("index?faces-redirect=true");
    }

}
