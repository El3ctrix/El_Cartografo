/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.TemaDAO;
import modelo.Tema;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author alexrl
 */
@ManagedBean
public class VerTema {
    
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
    
}