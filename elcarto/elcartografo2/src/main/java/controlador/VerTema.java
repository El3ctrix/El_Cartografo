/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
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
    
    private Tema tema;
    private List<Tema> temas;
    private TemaDAO temaDAO1;
    
    @PostConstruct
    public void init(){
        temaDAO1 = new TemaDAO();
        temas = temaDAO1.findAll();        
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
        temaDAO1 = new TemaDAO();
        temas = temaDAO1.findAll();
        for(Tema t : temas){
            if(nombre.equals(t.getNombre())){
                return t;
            }
        }
        return null;
    }
}