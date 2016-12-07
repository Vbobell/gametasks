/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;


import modelos.EntidadeUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
    public void salvar(EntidadeUsuario u)
    {
        //validar parâmetros
        if(u.getId()==null)
            super.create(u);
        else
            super.edit(u);
    }   

}
