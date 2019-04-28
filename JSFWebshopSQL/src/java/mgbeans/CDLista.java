/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import pojos.Product;

/**
 *
 * @author vug
 */
@ManagedBean
@SessionScoped
public class CDLista {

   private List<Product> lemezek;
   
    
    public CDLista() {
        
        Session session = hibernate.HibernateUtil.getSessionFactory().openSession();
        lemezek = session.createQuery("FROM Product").list();   
        session.close();    
        
    }

    public List<Product> getLemezek() {
        return lemezek;
    }

    public void setLemezek(List<Product> lemezek) {
        this.lemezek = lemezek;
    }
    
    
    
}
