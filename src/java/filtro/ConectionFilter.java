/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

/**
 *
 * @author zod
 */
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
 
import org.hibernate.SessionFactory;
import util.HibernateUtil;
 
public class ConectionFilter implements Filter {
 
    private SessionFactory sessionFactory;
 
    public void destroy() {
         
    }
 
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {
            this.sessionFactory.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);
            this.sessionFactory.getCurrentSession().getTransaction().commit();
            this.sessionFactory.getCurrentSession().close();
        } catch (Throwable ex) {
            try {
                if (this.sessionFactory.getCurrentSession().getTransaction().isActive()) {
                    this.sessionFactory.getCurrentSession().getTransaction().rollback();
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
            ex.printStackTrace();
        }
    }
 
    public void init(FilterConfig arg0) throws ServletException {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
}