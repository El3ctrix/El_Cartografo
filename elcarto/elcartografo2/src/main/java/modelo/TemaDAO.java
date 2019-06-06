/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author francisco
 */
public class TemaDAO extends AbstractDAO<Tema>{
    
    public TemaDAO(){
        super();
    }
    
    
    /**
     * 
     * @param  
     */
    @Override
    public void save(Tema tema){
        super.save(tema);
    }
    
    /**
     * 
     * @param marcador 
     */
    @Override
    public void update(Tema tema){
        super.save(tema);
    }
    
    /**
     * 
     * @param marcador 
     */
    @Override
    public void delete(Tema tema){
        super.delete(tema);
    }
       
    /**
     * 
     * @param id
     * @return 
     */
    public Tema find(int id){
        return super.find(Tema.class, id);
    }

    
    public Tema find(String id){
        return super.find(Tema.class, id);
    }
    
    /**
     * 
     * @return 
     */
    public List<Tema> findAll(){
         List<Tema> marca = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Tema";
            Query query = session.createQuery(hql);
            marca = query.list();
            tx.commit();
            
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();

        }finally{
            session.close();
        }
        return marca;
    }
    
    public Tema encuentraNombre(String nombre){
        Tema tema = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Tema t where t.nombre = :nombre";
            Query query = session.createQuery(hql);
            query.setParameter("nombre", nombre);
            tema = (Tema)query.uniqueResult();
            tx.commit();
            
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();

        }finally{
            session.close();
        }
        return tema;
    }
}
