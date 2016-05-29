/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.ItemVenda;
import modelo.Venda;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author zod
 */
public class VendaDAO extends GenericDAO<Venda> {

    public void salvar(Venda venda, List<ItemVenda> itensVenda) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao =null;

        try {
            transacao = sessao.beginTransaction();

            sessao.save(venda);

            for (int pos = 0; pos < itensVenda.size(); pos++) {
                ItemVenda itemVenda = itensVenda.get(pos);
                itemVenda.setVenda(venda);

                sessao.save(itemVenda);
            }
            transacao.commit();
        } catch (RuntimeException e) {

            if (transacao != null) {
                transacao.rollback();
            }
            throw e;
        } finally {
            sessao.close();

        }
    }
}//fim da classe
