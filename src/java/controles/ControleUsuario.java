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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelos.EntidadeUsuario;
import sessao.UsuarioFacade;

/**
 *
 * @author 181301742
 */
@Named(value = "controleUsuario")
@SessionScoped
public class ControleUsuario implements Serializable {
    private EntidadeUsuario usuarioControle;
    @Inject
    private UsuarioFacade operacao;
    /**
     * Creates a new instance of ControleUsuario
     */
    public ControleUsuario() {
        usuarioControle = new EntidadeUsuario();
    }

    public EntidadeUsuario getUsuarioControle() {
        return usuarioControle;
    }

    public void setUsuarioControle(EntidadeUsuario usuarioControle) {
        this.usuarioControle = usuarioControle;
    }
    
    
        public String adicionarUsuario(){
            operacao.create(usuarioControle);
            return ("administracao?faces-redirect=true"); 
        /*if(operacao.verificaUsuarioAdicionar(usuarioControle.getCpf())==false){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Usuario já cadastrado.");
            contexto.addMessage("idMensagem", mensagem);
            return ("administracao?faces-redirect=true"); 
        }else{
            operacao.create(usuarioControle);
            return ("administracao?faces-redirect=true"); 
        }*/
    }
    
    public List<EntidadeUsuario> listaUsuario(){
        return operacao.findAll();
    }
    
    public String excluirUsuario(EntidadeUsuario u){
        usuarioControle = u;
        operacao.remove(usuarioControle);
        return ("administracao?faces-redirect=true"); 
    }
}
