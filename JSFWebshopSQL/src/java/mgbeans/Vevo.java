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
import pojos.Client;
import pojos.Order;

/**
 *
 * @author vug
 */
@ManagedBean
@SessionScoped
public class Vevo {

   private Client vevo;
   private List<Client> vevok;
   private String loginError;
   private String email;
   private String password;
   
   public Vevo() {
   Session session = hibernate.HibernateUtil.getSessionFactory().openSession();
        vevok = session.createQuery("FROM Client").list();
        session.close();
        
            }
   
   public String getUser(){
       
       for (Client vv : vevok) {
           if (vv.getEmail().equals(this.email)) {
               if (vv.getPassword().equals(this.password)) {
                   vevo=vv;
                   return "order";
               } else {
                   loginError="Hibás jelszó!";
               }
           } else {
               loginError="Hibás email cím";
           }
       }
       return "login";
   }

    public Client getVevo() {
        return vevo;
    }

    public List<Client> getVevok() {
        return vevok;
    }

    public String getLoginError() {
        return loginError;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    
    
}
