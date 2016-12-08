/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.EntidadeQuadroTarefa;

/**
 *
 * @author vinic
 */
@Stateless
public class QuadroRN extends AbstractRN<EntidadeQuadroTarefa>{

    @PersistenceContext(unitName="GameTasksPU")
    private EntityManager manager;
    
    public QuadroRN() {
        super(EntidadeQuadroTarefa.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }
    
}