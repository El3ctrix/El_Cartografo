/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import java.util.List;

/**
 * Clase enteramente hecha para el funcionamiento conjunto de UsuarioDAO y
 * eliminarcomentaristas.xhtml
 * @author el3ctrix
 */
@ManagedBean(name = "usuariosService")
@ApplicationScoped
public class UsuariosService {
    
    List<Usuario> usuarios;
    UsuarioDAO u = new UsuarioDAO();
    
    /**
     * Constructor de la Clase
     */
    public UsuariosService(){
        usuarios = u.getListFromQuery("from Usuario where Rol = 'Comentarista'");
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
