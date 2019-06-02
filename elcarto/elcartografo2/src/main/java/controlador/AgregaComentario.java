/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.Comentario;
import modelo.ComentarioDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import modelo.Marcador;
import modelo.MarcadorDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
/**
 *
 * @author francisco
 */
@ManagedBean
public class AgregaComentario {
    private int idComentario;
    private Marcador marcador;
    private int idMarcador;
    private Usuario usuario;
    private String comentario;
    private int calificacion;

    public int getIdComentario() {
        return idComentario;
    }
    public int getIdMarcador(){
        return idMarcador;
    }

    public void setIdMarcador(int idMarcador){
        this.idMarcador = idMarcador;
    }
    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public Marcador getMarcador() {
        return marcador;
    }

    public void setMarcador(Marcador marcador) {
        this.marcador = marcador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
    public void agregaComentario(){
        Comentario comentar = new Comentario();
        ComentarioDAO daoComentario = new ComentarioDAO();
        Marcador marcador = new Marcador();
        MarcadorDAO daoMarcador = new MarcadorDAO();
        marcador = daoMarcador.find(idMarcador);
        Usuario usuario = new Usuario();
        UsuarioDAO daoUsuario = new UsuarioDAO();
        ControladorSesion.UserLogged us= (ControladorSesion.UserLogged) 
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Comentarista");
        usuario = daoUsuario.buscaPorCorreo(us.getCorreo());
        comentar.setMarcador(marcador);
        comentar.setUsuario(usuario);
        comentar.setComentario(comentario);
        comentar.setCalificacion(calificacion);
        daoComentario.save(comentar);
        
    }
    
}