/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgbeans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import pojos.Client;
import pojos.Order;
import pojos.Orderitem;
import pojos.Product;

/**
 *
 * @author vug
 */
@ManagedBean
@SessionScoped
public class CDKosar {

    private Order order;
    private List<Orderitem> tetelek;
    

    public CDKosar() {
        
        tetelek = new ArrayList<>();
        
    }
    
    
    public void ujMegrendeles(){
        order = new Order();
        Set<Orderitem> oiSet= new HashSet<>(tetelek);
        order.setOrderitems(oiSet);
        
    }
    
    
    public String finalizeOrder (Client buyer) {
        
        Timestamp most = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

        order.setFulfilled(true);
        order.setDate(most);
        order.setClient(buyer);
        for (Orderitem item : tetelek) {
            
           item.setOrder(order);
            System.out.println(item.getProduct().getId());
             System.out.println(item.getPrice());
              System.out.println(item.getOrder());
               System.out.println(item.getQty());
            
        }
        
        Session session = hibernate.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
        Session session2 = hibernate.HibernateUtil.getSessionFactory().openSession();
        session2.beginTransaction();
        for (Orderitem item : tetelek) {
            session2.save(item);
        }
        session2.getTransaction().commit();
        session2.close();
        
        
        return "message";
    }
    
    
    public void hozzaad(Product cd){
        Orderitem elem = null;
        for (Orderitem oi : tetelek) {
            if (oi.getProduct()==cd) {
                elem = oi;
            }
        }
        if (elem!=null) {
            elem.setQty(1);
        } else{
            elem = new Orderitem(null, cd, 1, cd.getPrice());
            tetelek.add(elem);
        }
        
    }
    
    
    public int getTotalDb(){
        int sum = 0;
        for (Orderitem oi : tetelek) {
            sum+=oi.getQty();
        }
        return sum;
    }
    
    public double getTotalOsszeg(){
        double sum = 0;
        for (Orderitem oi : tetelek) {
            sum+=oi.getPrice()*oi.getQty();
        }
        return sum;
    }
    
    public double getTotalOsszegOfOrder(){
        double sum = 0;
        for (Orderitem oi : order.getOrderitems()) {
            sum+=oi.getPrice()*oi.getQty();
        }
        return sum;
    }
    
   public void torol(Orderitem oi){
        tetelek.remove(oi);
    }
    
    public void oiDbNovel(Orderitem oi){
        oi.setQty(oi.getQty()+1);
    }
    
      public void oiDbCsokkent(Orderitem oi){
          if (oi.getQty()==1) {
              torol(oi);
          } else {
              oi.setQty(oi.getQty()-1);
          }
    } 
 

    public List<Orderitem> getTetelek() {
        return tetelek;
    }

    public void setTetelek(List<Orderitem> tetelek) {
        this.tetelek = tetelek;
    }

    public Order getOrder() {
        return order;
    }

   

    
   
    
}
