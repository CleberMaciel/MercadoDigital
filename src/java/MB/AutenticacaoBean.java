/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Usuario;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

/**
 *
 * @
 * author zod
 */
@ManagedBean
@SessionScoped
public class AutenticacaoBean implements Serializable {

    private Usuario usuario;
    private Usuario uLogado;

    public Usuario getuLogado() {
        return uLogado;
    }

    public void setuLogado(Usuario uLogado) {
        this.uLogado = uLogado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario =usuario;
    }

    @PostConstruct
    public void star() {
        usuario = new Usuario();
    }

    public void autenticar() {
        try {
            UsuarioDAO uDAO = new UsuarioDAO();
            uLogado = uDAO.autenticar(usuario.getLogin(), usuario.getSenha());
            if (uLogado == null) {
                Messages.addGlobalError("Login ou senha incorretos!");
                return;
            }

            Faces.redirect("./faces/index.xhtml");

        } catch (IOException e) {
            Messages.addGlobalError(e.getMessage());
        }

    }

}
