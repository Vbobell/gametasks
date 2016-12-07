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
import modelos.EntidadeQuadroTarefa;
import sessao.QuadroFacade;

/**
 *
 * @author vinic
 */
@Named(value = "controleQuadroTarefa")
@SessionScoped
public class ControleQuadroTarefa implements Serializable {
    private EntidadeQuadroTarefa quadroControle;
    @Inject
    private ControleUsuario controleUsuario;
    @Inject
    private ControleTarefa controleTarefa;
    @Inject
    private QuadroFacade operacao;
    /**
     * Creates a new instance of ControleQuadroTarefa
     */
    public ControleQuadroTarefa() {
        quadroControle = new EntidadeQuadroTarefa();
    }

    public EntidadeQuadroTarefa getQuadroControle() {
        return quadroControle;
    }

    public void setQuadroControle(EntidadeQuadroTarefa quadroControle) {
        this.quadroControle = quadroControle;
    }
    
     public String adicionarTarefaQuadro(){
        controleTarefa.adicionarTarefa(quadroControle.getTarefa());
        operacao.create(quadroControle);
        return ("administracao?faces-redirect=true"); 
    }
     
     public List<EntidadeQuadroTarefa> listaQuadroTarefa(){
        return operacao.findAll();
    }
    
    public String excluirQuadro(EntidadeQuadroTarefa qt){
        quadroControle = qt;
        operacao.remove(quadroControle);
        controleTarefa.excluirTarefa(qt.getTarefa());
        return ("administracao?faces-redirect=true"); 
    }
    
    public String editar(EntidadeQuadroTarefa qt){
         quadroControle = qt;
         return "editarTarefa?faces-redirect=true";
    }
    
    public String atualizarQuadroTarefa(){
         if(quadroControle.getTarefa().getStatus().equals("fechada")){
           controleUsuario.atribuirPontuacao(quadroControle.getTarefa().getValor(),quadroControle.getUsuario().getCpf());
         }
         controleTarefa.editar(quadroControle.getTarefa());
         operacao.edit(quadroControle);
         return ("administracao?faces-redirect=true");
    }

    public QuadroFacade getOperacao() {
        return operacao;
    }
    
}
