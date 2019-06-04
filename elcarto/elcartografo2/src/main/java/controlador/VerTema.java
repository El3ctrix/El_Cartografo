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
    
    public Tema getTemaId(String nombre){
        if(nombre == null){
            throw new IllegalArgumentException("Ingresa el nombre del tema");            
        }
        for(Tema tema1 : temas){
            if(nombre.equals(tema1.getNombre())){
                System.out.print(tema1);
                return tema1;                
            }
        }
        return null;
    }
}