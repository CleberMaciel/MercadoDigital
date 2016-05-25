/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Categoria;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author cleber
 */
public class CategoriaDAOTeste {

    @Test
    @Ignore
    public void salvar() {
        Categoria cat = new Categoria();
        cat.setNomeCategoria("Mouse");

        CategoriaDAO catDAO = new CategoriaDAO();

        catDAO.salvar(cat);
    }

    @Test
    @Ignore
    public void listar() {

        CategoriaDAO catDAO = new CategoriaDAO();

        List<Categoria> result = catDAO.listar();

        for (Categoria c : result) {
            System.out.println(c.getNomeCategoria());
        }
    }//fim listar

    @Test
    @Ignore
    public void buscar() {
        Long c = 1L;
        CategoriaDAO catDAO = new CategoriaDAO();
        Categoria cat = catDAO.buscar(c);
        if (cat == null) {
            System.out.println("Nada encontrado");
        } else {
            System.out.println("Registro encontrado");
            System.out.println(cat.getNomeCategoria());
        }

    }

    @Test
    @Ignore
    public void excluir() {
        Long c = 1L;
        CategoriaDAO catDAO = new CategoriaDAO();
        Categoria cat = catDAO.buscar(c);

        if (cat == null) {
            System.out.println("Nada encontrado");
        } else {
            System.out.println("Registro encontrado");
        }

        catDAO.excluir(cat);
    }

    @Test
    @Ignore
    public void editar() {
        Long c = 2L;
        CategoriaDAO catDAO = new CategoriaDAO();
        Categoria cat = catDAO.buscar(c);

        if (cat == null) {
            System.out.println("nada encontrado");
        } else {
            cat.setNomeCategoria("Monitor 3D");
            catDAO.Editar(cat);
        }
    }
}
