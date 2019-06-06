package controlador;

import java.io.Serializable;
import modelo.Marcador;
import modelo.MarcadorDAO;
import modelo.Tema;
import modelo.TemaDAO;
import modelo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.LatLng;
import java.util.List;
import org.primefaces.model.map.DefaultMapModel;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.map.MarkerDragEvent;

/**
 *
 *@author francisco
 */
@ManagedBean
@ViewScoped
public class ColocaMarcador implements Serializable{

    private MapModel draggableModel;
    private Marker marcador;
    private LatLng centro;
    private int idMarcador;
    private String correo;
    private String cadenaTema;
    private String nombre;
    private Tema tema;
    private Usuario usuario;
    private double latitud;
    private double longitud;
    private String descripcion;
    private String datos;
    private List<Tema> listaTemas;        
    private List<Marcador> marcadores;
    
    public List<Tema> getListaTemas(){
        TemaDAO temaDao = new TemaDAO();
        this.listaTemas = temaDao.findAll();
        return listaTemas;
    }

    public void getMarcadores() {
        MarcadorDAO marcadorDAO = new MarcadorDAO();
        this.marcadores = marcadorDAO.findAll();
    }

    public void setMarcadores(List<Marcador> marcadores) {
        this.marcadores = marcadores;
    }    
    
    public int getIdMarcador() {
        return idMarcador;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setIdMarcador(int idMarcador){
	this.idMarcador = idMarcador;
    }
    public void setTema(Tema tema){
	this.tema = tema;
    }
    
    public void setUsuario(Usuario usuario){
	this.usuario = usuario;
    }
    
    public void setLatitud(Double latitud){
	this.latitud = latitud;
    }
    
    public void setLongitud(Double longitud){
	this.longitud = longitud;
    }
    
    public void setDescripcion(String descripcion){
	this.descripcion = descripcion;
    }
    
    public void setDatos(String datos){
	this.datos = datos;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getLongitud() {
        return longitud;
    }   
    
    public Double getLatitud(){
        return latitud;
    }

    public String getDatos() {
        return datos;
    }

    public Tema getTema() {
        return tema;
    }

    public String getCadenaTema() {
        return cadenaTema;
    }

    public void setCadenaTema(String cadenaTema) {
        this.cadenaTema = cadenaTema;
    }
    
     public MapModel getDraggableModel() {
        return draggableModel;
    }
    
    public void onMarkerDrag(MarkerDragEvent event) {
        marcador = event.getMarker();
          
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Dragged", "Lat:" + 
                        marcador.getLatlng().getLat() + ", Lng:" + marcador.getLatlng().getLng()));
    }
    
    public void colocaMarcador(Usuario usuario){    
        Marcador m = new Marcador();
        TemaDAO temaDAO = new TemaDAO();
        MarcadorDAO mdao = new MarcadorDAO();
                
        getMarcadores();
        
        setTema(temaDAO.find(this.getCadenaTema()));
        
        m.setTema(tema);
        m.setUsuario(usuario);
        m.setNombre(nombre);
        m.setCorreo(usuario.getCorreo());
        m.setLatitud(latitud);
        m.setLongitud(longitud);
        m.setDescripcion(descripcion);
        m.setDatos(datos);
        
        mdao.save(m);
        
    }
}