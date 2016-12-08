/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;


import java.util.List;
import modelos.EntidadeUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UsuarioRN extends AbstractRN<EntidadeUsuario>{
    @PersistenceContext(unitName="GameTasksPU")
    private EntityManager manager;
    
    public UsuarioRN() {
        super(EntidadeUsuario.class);
    }
    @Override
    protected EntityManager getEntityManager() {
         return manager;
    }
    
    public List<EntidadeUsuario> getLista() {
        Query q = manager.createQuery("select u from EntidadeUsuario u ORDER BY u.pontuacao DESC");
        return q.getResultList();
    }
    
    public void salvar(EntidadeUsuario u)
    {
        //validar parâmetros
        if(u.getId()==null)
            super.create(u);
        else
            super.edit(u);
    }   

}
