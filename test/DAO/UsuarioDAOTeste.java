/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.Usuario;
import org.junit.Test;

/**
 *
 * @author zod
 */
public class UsuarioDAOTeste {

    @Test
    public void autenticar() {

        String login = "631420226";
        String senha = "123456";

        UsuarioDAO uDAO = new UsuarioDAO();
        Usuario u = uDAO.autenticar(login, senha);
        
        System.out.println("Usuario: " + u);
    }

}
