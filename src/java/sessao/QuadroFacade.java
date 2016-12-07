/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelos.EntidadeQuadroTarefa;
import modelos.EntidadeUsuario;
/**
 *
 * @author vinic
 */
@Stateless
public class QuadroFacade extends AbstractFacade<EntidadeQuadroTarefa>{

    @PersistenceContext(unitName = "GameTasksPU")
    private EntityManager eManager;
    
    private List<EntidadeUsuario> verifica;
    
    @Override
    protected EntityManager getEntityManager() {
        return eManager;
    }
    
    public QuadroFacade() {
        super(EntidadeQuadroTarefa.class);
    }
    public Boolean verificaUsuarioExistente(EntidadeUsuario u){
        Query q = eManager.createQuery("select u from EntidadeUsuario u,EntidadeQuadroTarefa t where u = t and u = :usuario");
        q.setParameter("usuario", u);
        verifica = q.getResultList();
            if(verifica.isEmpty())
                return false;
            else
                return true;
    }
}
