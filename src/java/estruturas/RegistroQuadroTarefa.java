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
import modelos.QuadroTarefa;


/**
 *
 * @author vinic
 */
@Named(value = "registroQuadroTarefa")
@ApplicationScoped
public class RegistroQuadroTarefa {

   private QuadroTarefa quadroAdd;
   private RegistroTarefa registroTarefa;
   private List<QuadroTarefa> lista = new ArrayList();
   
    /**
     * Creates a new instance of RegistroQuadroTarefa
     */
    public RegistroQuadroTarefa() {
        quadroAdd = new QuadroTarefa();
    }
    
    public String adicionarTarefaQuadro() {
            registroTarefa = new RegistroTarefa();
        
            registroTarefa.adicionarTarefa(quadroAdd.getTarefa());
            
            lista.add(quadroAdd);
            
            this.quadroAdd = new QuadroTarefa();
            
            return("administracao?faces-redirect=true");
    }

    public QuadroTarefa getQuadroAdd() {
        return quadroAdd;
    }

    public void setQuadroAdd(QuadroTarefa quadroAdd) {
        this.quadroAdd = quadroAdd;
    }

    public RegistroTarefa getRegistroTarefa() {
        return registroTarefa;
    }

    public void setRegistroTarefa(RegistroTarefa registroTarefa) {
        this.registroTarefa = registroTarefa;
    }

    public List<QuadroTarefa> getLista() {
        return lista;
    }

    public void setLista(List<QuadroTarefa> lista) {
        this.lista = lista;
    }
    
    
}
