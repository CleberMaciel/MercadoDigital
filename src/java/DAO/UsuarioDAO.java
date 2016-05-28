/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author zod
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    public Usuario autenticar(String login, String senha) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {

            Criteria consulta = sessao.createCriteria(Usuario.class);

            consulta.add(Restrictions.eq("login", login));
            consulta.add(Restrictions.eq("senha", senha));

            Usuario resultado = (Usuario) consulta.uniqueResult();

            return resultado;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            sessao.close();
        }
    }
}
