/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelos.EntidadeUsuario;
import sessao.UsuarioFacade;

/**
 *
 * @author vinic
 */
@Named(value = "usuarioMb")
@SessionScoped
public class UsuarioMb implements Serializable {

    private boolean logado;
    private EntidadeUsuario usuario, usuarioControle;
    private ControleUsuario transacaoUsuario;
    @EJB
    private UsuarioFacade operacao;

    public UsuarioMb() { 
        usuario = new EntidadeUsuario();
        usuarioControle = new EntidadeUsuario();
        transacaoUsuario = new ControleUsuario();
        operacao = new UsuarioFacade();
        logado = false;
    }

    public boolean isLogado() {
        return logado;
    }

    public EntidadeUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(EntidadeUsuario usuario) {
        this.usuario = usuario;
    }

    public EntidadeUsuario getUsuarioControle() {
        return usuarioControle;
    }

    public void setUsuarioControle(EntidadeUsuario usuarioControle) {
        this.usuarioControle = usuarioControle;
    }
    
    public String verificaLogin() {
        if (operacao.verificaUsuario(usuario.getCpf(),usuario.getSenha()) == false) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login inválido"," Usuário ou senha está errado!");
            contexto.addMessage(null, mensagem);
            return ("index");
        } else {
            if(!usuario.getCpf().equals("00000")){
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
    
    public String adicionarUsuario(){
        boolean adicionar = transacaoUsuario.adicionarUsuario(usuarioControle);
        
        if(adicionar != true){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Usuario já cadastrado.");
            contexto.addMessage("idMensagem", mensagem);
            return ("administracao?faces-redirect=true"); 
        }else{
            return ("administracao?faces-redirect=true"); 
        }
    }
}
