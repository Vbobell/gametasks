/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelos.EntidadeUsuario;
import modelos.Usuario;
import sessao.UsuarioFacade;

/**
 *
 * @author vinic
 */
public class ControleUsuario {
    private EntidadeUsuario usuario;
    @EJB
    private UsuarioFacade operacao;

    public ControleUsuario() {
        usuario = new EntidadeUsuario();
        operacao = new UsuarioFacade();
    }

    public Boolean adicionarUsuario(EntidadeUsuario u) {
        this.usuario = u;
        if (buscarUsuario(usuario) != null) {
            return false;
        } else {
            operacao.create(usuario);
            this.usuario = new EntidadeUsuario();
            return true;
        }
    }

    public EntidadeUsuario buscarUsuario(EntidadeUsuario u) {
       EntidadeUsuario busca = operacao.find(u);
        if(busca != null)
            return null;
        else
            return busca;
    }
}
