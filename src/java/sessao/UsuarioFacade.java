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
import modelos.EntidadeUsuario;
/**
 *
 * @author vinic
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<EntidadeUsuario>{

    @PersistenceContext(unitName = "GameTasksPU")
    private EntityManager eManager;
    
    private List<EntidadeUsuario> verifica;
    
    @Override
    protected EntityManager getEntityManager() {
        return eManager;
    }
    
    public UsuarioFacade() {
        super(EntidadeUsuario.class);
    }
    
    public Boolean verificaUsuario(String cpf,String senha){
        Query q = eManager.createQuery("select u from EntidadeUsuario u where u.cpf = :cpf and u.senha = :senha");
        q.setParameter("cpf", cpf);
        q.setParameter("senha", senha);
        verifica = q.getResultList();
            if(verifica.isEmpty())
                return false;
            else
                return true;
    }
    public Boolean verificaUsuarioAdicionar(String cpf){
        Query q = eManager.createQuery("select u from EntidadeUsuario u where u.cpf = :cpf");
        q.setParameter("cpf", cpf);
        verifica = q.getResultList();
            if(verifica.isEmpty())
                return false;
            else
                return true;
    }
    
    public void atribuirPontuacao(int valor, String cpf){
        Query q = eManager.createQuery("update EntidadeUsuario u SET u.pontuacao = :valor where u.cpf = :cpf");
        q.setParameter("valor", valor);
        q.setParameter("cpf", cpf);
        q.executeUpdate();
    }

    public List<EntidadeUsuario> getVerifica() {
        return verifica;
    }
    public List<EntidadeUsuario> getLista() {
        Query q = eManager.createQuery("select u from EntidadeUsuario u ORDER BY u.pontuacao DESC");
        return q.getResultList();
    }
}
