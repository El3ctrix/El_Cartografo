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
public class ComentarioDAO extends AbstractDAO<Comentario>{
    public ComentarioDAO(){
        super();
    }
    
    /**
     * 
     * @param usuario 
     */
    @Override
    public void save(Comentario comentario){
        super.save(comentario);
    }
    
    /**
     * 
     * @param comentario
     */
    @Override
    public  void update(Comentario comentario){
        super.update(comentario);
    }
    
    /**
     * 
     * @param comentario
     */
    @Override
    public void delete(Comentario comentario){
        super.delete(comentario);
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Comentario find(int id){
        return super.find(Comentario.class, id);
    }
    
    /**
     * 
     * @return 
     */
    public List<Comentario> findAll(int idmarcador){
        List<Comentario> obj =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Comentario where  id_marcador ="+idmarcador;
            Query query = session.createQuery(hql);
            obj = (List<Comentario>)query.list();
            tx.commit();
            
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.close();
        
        }
        return obj;
    }
}
