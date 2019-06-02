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
    public List<Comentario> findAll(){
        return super.findAll(Comentario.class);
    
    }
}
