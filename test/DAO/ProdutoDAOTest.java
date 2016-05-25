/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Categoria;
import modelo.Produto;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author cleber
 */
public class ProdutoDAOTest {

    @Test
    @Ignore
    public void salvar() {

        CategoriaDAO catDAO = new CategoriaDAO();

        Categoria cat = catDAO.buscar(2L);

        Produto p = new Produto();
        p.setProdutoNome("Dell");
        p.setProdutoCategoria(cat);
        p.setProdutoCor("Preto");
        p.setProdutoDescricao("Monitor da dell");
        p.setQuantidade(2);
        p.setValor(10);

        ProdutoDAO pDAO = new ProdutoDAO();
        pDAO.salvar(p);
    }

    @Test
    @Ignore
    public void listar() {
        ProdutoDAO pDAO = new ProdutoDAO();
        List<Produto> resultado = pDAO.listar();

        for (Produto p : resultado) {
            System.out.println(p.getProdutoNome());
            System.out.println(p.getProdutoCategoria().getNomeCategoria());
        }
    }//fim listar

    @Test
    @Ignore
    public void buscar() {

        Long codigo = 3L;
        ProdutoDAO pDAO = new ProdutoDAO();
        Produto p = pDAO.buscar(codigo);

        System.out.println(p.getProdutoNome());
        System.out.println(p.getProdutoCategoria().getNomeCategoria());

    }//fim busca
    
    @Test
    @Ignore
    public void excluir(){
        Long codigo = 3L;
        
        ProdutoDAO pDAO  =  new ProdutoDAO();
        Produto p = pDAO.buscar(codigo);
        
        pDAO.excluir(p);
        
    }//fim exlcuir
    
    @Test
    @Ignore
    public void editar(){
        Long codigoProduto = 3L;
        Long codigoCategoria = 1L;
        
        CategoriaDAO catDAO = new CategoriaDAO();
        Categoria cat = catDAO.buscar(codigoCategoria);
        
        ProdutoDAO pDAO  =  new ProdutoDAO();
        Produto p = pDAO.buscar(codigoProduto);
        
        p.setProdutoNome("HP");
        p.setProdutoCategoria(cat);
        pDAO.Editar(p);
       
    }
}
