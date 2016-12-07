/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.EntidadeTarefa;
/**
 *
 * @author vinic
 */
@Stateless
public class TarefaRN extends AbstractRN<EntidadeTarefa>{

     @PersistenceContext(unitName="GameTasksPU")
    private EntityManager manager;
    
    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }
    
    public TarefaRN() {
        super(EntidadeTarefa.class);
    }
    
}
