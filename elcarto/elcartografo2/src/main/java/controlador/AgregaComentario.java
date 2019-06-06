/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
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
    private List<Comentario> comentarios;

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

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    
    public void agregaComentario(){
     
    }
    
    public List<Comentario> listarMarcadores(String titulo){
        comentarios = null;
        ComentarioDAO comen = new ComentarioDAO();
        MarcadorDAO mardao = new MarcadorDAO();
        List<Marcador> marcadores = mardao.findAll();
        for(Marcador m : marcadores){
            if(m.getNombre().equals(titulo)){                
                comentarios = comen.findAll(m.getIdMarcador());
            }else{
                Mensajes.error("Sólo puedes eliminar marcadores tuyos");
            } 
        }
        for(Comentario com : comentarios)
            System.out.println(com.getComentario());
        return comentarios;
    }
    
}
