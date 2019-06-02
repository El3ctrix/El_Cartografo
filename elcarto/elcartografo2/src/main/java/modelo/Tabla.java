/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedProperty;


/**
 * Clase que nos ayuda a modelar las columnas y filas de una DataTable de PrimeFaces,
 * tambien sirva para editar los datos de usuarios.
 * @author el3ctrix
 */
@ManagedBean(name="tabla")
@ViewScoped
public class Tabla implements Serializable{
    //Lista que muestra los datos.
    private List<Usuario> usuarios1;
    
    @ManagedProperty("#{usuariosService}")
    private UsuariosService usDAO = new UsuariosService();
    
    @PostConstruct
    public void init(){
        usuarios1 = usDAO.usuarios;
    }

    public UsuariosService getUsDAO() {
        return usDAO;
    }

    public void setUsDAO(UsuariosService usDAO) {
        this.usDAO = usDAO;
    }
    
    public List<Usuario> getListUsrs(int i){
        switch(i){
            case 1:
                usuarios1 = usDAO.u.getListFromQuery("from Usuario where Rol = 'Comentarista'");
            break;
            case 2:
                usuarios1 = usDAO.u.getListFromQuery("from Usuario where Rol = 'Informador'");
            break;
            case 3:
                usuarios1 = usDAO.u.getListFromQuery("from Usuario where Rol = 'Comentarista' OR Rol = 'Informador'");
            break;
            case 4:
                usuarios1 = usDAO.u.getListFromQuery("from Usuario");
            break;
        }
        return usuarios1;
    }
    
    public void refrescaTabla(int i){
        switch(i){
            case 1:
                usuarios1 = usDAO.u.getListFromQuery("from Usuario where Rol = 'Comentarista'");
            break;
            case 2:
                usuarios1 = usDAO.u.getListFromQuery("from Usuario where Rol = 'Informador'");
            break;
            case 3:
                usuarios1 = usDAO.u.getListFromQuery("select id,nombre,correo from usuario");
            break;
        }
    }
    
}
