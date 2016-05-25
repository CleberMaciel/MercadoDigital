/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import DAO.CategoriaDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import modelo.Categoria;
import org.omnifaces.util.Messages;

/**
 *
 * @author cleber
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CategoriaBean implements Serializable {

    private Categoria categoria;
    private List<Categoria> listaCategorias;

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void novo() {
        categoria = new Categoria();
    }

    public void salvar() {
        try {
            CategoriaDAO catDAO = new CategoriaDAO();
            catDAO.merge(categoria);

            listaCategorias = catDAO.listar();

            Messages.addGlobalInfo("Categoria: " + categoria.getNomeCategoria() + " cadastrado!");
        } catch (RuntimeException e) {
            Messages.addGlobalError("Erro ao tentar salvar categoria");
            e.printStackTrace();
        }
    }//fim salvar

    @PostConstruct
    public void listar() {
        try {

            CategoriaDAO catDAO = new CategoriaDAO();
            listaCategorias = catDAO.listar();

        } catch (RuntimeException e) {
            Messages.addGlobalError("Erro ao tentar listar as categoria");
            e.printStackTrace();
        }
    }

    public void excluir(ActionEvent ev) {
        try {
            categoria = (Categoria) ev.getComponent().getAttributes().get("categoriaSelecionada");
            CategoriaDAO catDAO = new CategoriaDAO();
            catDAO.excluir(categoria);
            listaCategorias = catDAO.listar();
            Messages.addGlobalInfo("Categoria excluida com sucesso!");
        } catch (RuntimeException e) {
            Messages.addGlobalError("Erro ao tentar deletar a categoria.");
            e.printStackTrace();
        }
    }//fim exlcuir

    public void editar(ActionEvent ev) {
        categoria = (Categoria) ev.getComponent().getAttributes().get("categoriaSelecionada");
        // Messages.addGlobalInfo("Nome: "+categoria.getNomeCategoria());
    }
}
