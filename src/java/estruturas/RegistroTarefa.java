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
    /**
     * Creates a new instance of RegistroTarefa
     */
    public RegistroTarefa() {
        this.tarefaAdd = new Tarefa();
    }

    public Tarefa getTarefaAdd() {
        return tarefaAdd;
    }

    public void setTarefaAdd(Tarefa tarefaAdd) {
        this.tarefaAdd = tarefaAdd;
    }

    public List<Tarefa> getLista() {
        return lista;
    }

    public void setLista(List<Tarefa> lista) {
        this.lista = lista;
    }
    
       public String adicionar() {
        if (buscarTarefa(tarefaAdd) != null) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Tarefa já cadastrada.");
            contexto.addMessage("idMensagem", mensagem);
            System.out.println(tarefaAdd.toString());
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

    public String excluir(Tarefa t) {
            lista.remove(t);
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"","Tarefa removido");
            contexto.addMessage("idMensagem", mensagem);
            return ("tarefa?faces-redirect=true");
        } 
    
    
}
