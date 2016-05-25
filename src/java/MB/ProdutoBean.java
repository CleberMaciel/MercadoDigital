/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import DAO.CategoriaDAO;
import DAO.ProdutoDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Categoria;
import modelo.Produto;
import org.omnifaces.util.Messages;

/**
 *
 * @author cleber
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {

    private List<Produto> listaProdutos;
    private List<Categoria> listaCategoria;
    private Produto produto;

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void novo() {
        produto = new Produto();
        CategoriaDAO catDAO = new CategoriaDAO();
        listaCategoria = catDAO.listar();
    }

    @PostConstruct
    public void listar() {
        try {
            ProdutoDAO pDAO = new ProdutoDAO();
            listaProdutos = pDAO.listar();
        } catch (RuntimeException e) {
            Messages.addFlashGlobalError("Erro ao listar o produto");
        }
    }//fim do listar

    public void salvar() {
        try {
            //merge serve tanto para editar como para salvar
            ProdutoDAO pDAO = new ProdutoDAO();
            pDAO.merge(produto);

            produto = new Produto();
            CategoriaDAO catDAO = new CategoriaDAO();
            listaCategoria = catDAO.listar();
            listaProdutos = pDAO.listar();

            Messages.addGlobalInfo("Produto cadastrado");
        } catch (RuntimeException e) {
            Messages.addGlobalError("Erro ao cadastrar produto.");
        }
    }

}
