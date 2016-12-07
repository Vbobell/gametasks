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
import javax.inject.Inject;
import modelos.EntidadeTarefa;
import sessao.TarefaFacade;

/**
 *
 * @author vinic
 */
@Named(value = "controleTarefa")
@SessionScoped
public class ControleTarefa implements Serializable {

    private EntidadeTarefa tarefaControle;
    @Inject
    private TarefaFacade operacao;

    /**
     * Creates a new instance of ControleTarefa
     */
    public ControleTarefa() {
        tarefaControle = new EntidadeTarefa();
    }

    public EntidadeTarefa getTarefaControle() {
        return tarefaControle;
    }

    public void setTarefaControle(EntidadeTarefa tarefaControle) {
        this.tarefaControle = tarefaControle;
    }

    public String adicionarTarefa(EntidadeTarefa t) {
        tarefaControle = t;
        operacao.create(tarefaControle);
        return ("administracao?faces-redirect=true");
    }

    public List<EntidadeTarefa> listaTarefa() {
        return operacao.findAll();
    }

    public String excluirTarefa(EntidadeTarefa t) {
        tarefaControle = t;
        operacao.remove(tarefaControle);
        return ("administracao?faces-redirect=true");
    }

    public void editar(EntidadeTarefa et) {
        tarefaControle = et;
        atualizarTarefa();
    }

    public void atualizarTarefa() {
        operacao.edit(tarefaControle);
    }
}

