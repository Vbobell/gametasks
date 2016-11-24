/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.EntidadeTarefa;
/**
 *
 * @author vinic
 */
@Stateless
public class TarefaFacade extends AbstractFacade<EntidadeTarefa>{

    @PersistenceContext(unitName = "GameTasksPU")
    private EntityManager eManager;
    
    @Override
    protected EntityManager getEntityManager() {
        return eManager;
    }
    
    public TarefaFacade() {
        super(EntidadeTarefa.class);
    }
    
}
