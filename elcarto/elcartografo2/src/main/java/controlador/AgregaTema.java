/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.Tema;
import modelo.TemaDAO;
import javax.faces.bean.ManagedBean;
import modelo.Usuario;

/**
 *
 * @author francisco
 */
@ManagedBean
public class AgregaTema {
    private String nombre;
  
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public void agregraTema(){
        Tema u = new Tema();

        TemaDAO udao = new TemaDAO();
        u.setNombre(nombre);
        setUsuario(usuario);
        if(udao.find(nombre) == null){
            udao.save(u);
        }
    }
}
