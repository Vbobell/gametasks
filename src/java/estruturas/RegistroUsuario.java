
package estruturas;

import java.io.Serializable;
import java.util.ArrayList;
import modelos.Usuario;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Vinicius Böbel
 * Classe que armazena os usuários no arrayList do tipo usuário.
 */
@Named(value = "registroUsuario")
@ApplicationScoped
public class RegistroUsuario implements Serializable {

    private Usuario usuario;
    private List<Usuario> lista = new ArrayList();
    
    public RegistroUsuario() {
       lista.add(new Usuario("admin","12345"));
       usuario = new Usuario();
    }

    public String adicionar() {
        if (buscarUsuario(usuario) != null) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Usuario já cadastrado.");
            contexto.addMessage("idMensagem", mensagem);
            System.out.println(usuario.toString());
            return ("cadastro?faces-redirect=true");
            
        } else {
            System.out.println(usuario.toString());
            lista.add(usuario);
        }
        return("usuario");
    }

    public Usuario buscarUsuario(Usuario u) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNome().equalsIgnoreCase(u.getNome()) && lista.get(i).getSenha().equalsIgnoreCase(u.getSenha())) {
                return lista.get(i);
            }
        }
        return null;
    }

    public String remover(Usuario u) {
            lista.remove(u);
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"","Usuario removido");
            contexto.addMessage("idMensagem", mensagem);
            return ("excluir?faces-redirect=true");
        } 
/**
 * 
* @return Metodo que retorna as informações de todos usuários.
*/
    public List<Usuario> getLista() {
        return lista;
    }
    
    @Override
    public String toString() {
        return "Usuarios: \n" + lista;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
        public Usuario getUsuario() {
        return usuario;
    }

    

}
