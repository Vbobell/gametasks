/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
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
    private EntidadeUsuario usuario,usuarioControle;
    @Inject
    private UsuarioFacade operacao;
    
    public UsuarioMb() { 
        usuario = new EntidadeUsuario();
        logado = false;
    }
    
    /*@PostConstruct
    public void preencheBanco(){
       usuarioControle = new EntidadeUsuario();
       usuarioControle.setNome("admin");
       usuarioControle.setFuncao("admin");
       usuarioControle.setCpf("00000");
       usuarioControle.setSenha("123456");
       operacao.create(usuarioControle);
    }*/

    public boolean isLogado() {
        return logado;
    }

    public EntidadeUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(EntidadeUsuario usuario) {
        this.usuario = usuario;
    }

    public void setUsuarioControle(EntidadeUsuario usuarioControle) {
        this.usuarioControle = usuarioControle;
    }
    
    public EntidadeUsuario getUsuarioControle() {
        return usuarioControle;
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
                usuarioControle = operacao.getVerifica().get(0);
                return ("usuario?faces-redirect=true");
            }else{
                logado = true;
                usuarioControle = operacao.getVerifica().get(0);
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
