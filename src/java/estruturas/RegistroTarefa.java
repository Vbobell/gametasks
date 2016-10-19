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
import modelos.Tarefa;

/**
 *
 * @author vinic
 */
@Named(value = "registroTarefa")
@ApplicationScoped
public class RegistroTarefa {

   private Tarefa tarefaAdd;
    private List<Tarefa> lista = new ArrayList();
    
    public RegistroTarefa() {
       tarefaAdd = new Tarefa();
       lista.add(new Tarefa("teste","teste"));
    }

    public String adicionarTarefa() {
        if (buscarTarefa(tarefaAdd) != null) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Tarefa já cadastrado.");
            contexto.addMessage("idMensagem", mensagem);
            return ("usuario");    
        } else{
            lista.add(tarefaAdd);
            this.tarefaAdd = new Tarefa();
            return("usuario");
        }
    }

    public Tarefa buscarTarefa(Tarefa t) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getTitulo().equalsIgnoreCase(t.getTitulo())) {
                return lista.get(i);
            }
        }
        return null;
    }

    public String excluirTarefa(Tarefa u) {
            lista.remove(u);
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"","Tarefa removido");
            contexto.addMessage("idMensagem", mensagem);
            return ("usuario?faces-redirect=true");
        } 

    public void setList(List<Tarefa> lista){
        this.lista = lista;
    }
    public List<Tarefa> getLista() {
        return lista;
    }
    @Override
    public String toString() {
        return "Tarefas: \n" + lista;
    }
    
    public void setTarefa(Tarefa tarefa) {
        this.tarefaAdd = tarefa;
    }
    
    public Tarefa getTarefaAdd() {
        return tarefaAdd;
    }
    
}
