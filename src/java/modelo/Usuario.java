/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author cleber
 */
@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain {

    @Column(length = 50, nullable = false)
    private String login;
    @Column(length = 50, nullable = false)
    private String senha;
    @Column(nullable = false)
    private boolean tipo;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

}
