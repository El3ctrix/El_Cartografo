/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import modelo.TemaDAO;
import modelo.Tema;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author alexrl
 */
@ManagedBean
@SessionScoped
public class VerTema implements Serializable{
    
    @ManagedProperty(value = "#{tema}")
    private Tema tema;
    @ManagedProperty(value = "#{temas}")
    private List<Tema> temas;
    @ManagedProperty(value = "#{temaDAO}")
    private TemaDAO temaDao;
    
    public void init(){
        temas = temaDao.findAll();        
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }
    
    public Tema getTemaNombre(String nombre){
        TemaDAO temaDAO = new TemaDAO();
        for(Tema t : temas){
            t = temaDAO.encuentraNombre(nombre);
            return t;
        }
        return null;
    }
}