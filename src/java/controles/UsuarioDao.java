/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import dao.ConnectionDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Usuario;
/**
 *
 * @author vinic
 */
public class UsuarioDao extends ConnectionDAO<Usuario>{

    @Override
    public void add(Usuario domain) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario get(Usuario domain) {
       Usuario search = null;
        try {

            String sqlSelect = "select * from usuario where nome = ? and senha = ?";
            
            toConnect(sqlSelect);
           
            command.setString(1, domain.getNome());
            command.setString(2, domain.getSenha());
            
            ResultSet resultado = command.executeQuery();
            while (resultado.next()) {
            
                search = new Usuario(resultado.getInt("idUsuario"),resultado.getString("nome"),
                        resultado.getString("senha"), resultado.getString("cpf"),resultado.getString("funcao"));
                
                if (domain.getNome().equals(search.getNome()) && domain.getSenha().equals(search.getSenha())) {
                    return search;
                }else{
                    search = null;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return search;
    }

    @Override
    public List<Usuario> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Usuario domain) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
