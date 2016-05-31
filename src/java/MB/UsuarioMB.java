/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import DAO.UsuarioDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import modelo.Usuario;
import org.omnifaces.util.Messages;

/**
 *
 * @author zod
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioMB implements Serializable {

    private Usuario usuario;
    private List<Usuario> listaUsuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    @PostConstruct
    public void listar() {
        try {
            UsuarioDAO uDAO = new UsuarioDAO();
            listaUsuario = uDAO.listar();
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar as pessoas");
            erro.printStackTrace();
        }
    }

    public void novo() {
        try {
            usuario = new Usuario();

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova pessoa");
            erro.printStackTrace();
        }
    }

    public void salvar() {
        try {
            UsuarioDAO uDAO = new UsuarioDAO();
            uDAO.merge(usuario);

            listaUsuario = uDAO.listar();

            usuario = new Usuario();

            Messages.addGlobalInfo("Pessoa salva com sucesso");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar a pessoa");
            erro.printStackTrace();
        }
    }

    public void salvarFora() {
        try {
            UsuarioDAO uDAO = new UsuarioDAO();
            uDAO.merge(usuario);

            listaUsuario = uDAO.listar();

            usuario = new Usuario();

            Messages.addGlobalInfo("Pessoa salva com sucesso");

        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar a pessoa");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent ev) {
        try {
            usuario = (Usuario) ev.getComponent().getAttributes().get("usuarioSelecionado");
            UsuarioDAO uDAO = new UsuarioDAO();
            uDAO.excluir(usuario);
            listaUsuario = uDAO.listar();
            Messages.addGlobalInfo("usuario excluido com sucesso!");
        } catch (RuntimeException e) {
            Messages.addGlobalError("Erro ao tentar deletar a categoria.");
            e.printStackTrace();
        }
    }//fim exlcuir

    
        public void editar(ActionEvent ev) {
        usuario = (Usuario) ev.getComponent().getAttributes().get("usuarioSelecionado");
        // Messages.addGlobalInfo("Nome: "+categoria.getNomeCategoria());
    }
}
