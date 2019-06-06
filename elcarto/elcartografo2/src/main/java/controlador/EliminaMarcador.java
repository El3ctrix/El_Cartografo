/*
    public void setTema(Tema tema){
	this.tema = tema;
    }
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;
import java.io.Serializable;
import java.util.List;
import modelo.Marcador;
import modelo.MarcadorDAO;
import javax.faces.bean.ManagedBean;
import modelo.Usuario;
import controlador.Mensajes;
import org.primefaces.model.map.Marker;

/**
 *
 *@author francisco
 */
@ManagedBean
public class EliminaMarcador implements Serializable{
    private int idMarcador;    
    private MarcadorDAO marcadorDAO;
    private List<Marcador> marcadores;
    private Marker marcador;
    
    public MarcadorDAO getMarcadorDAO() {
        return marcadorDAO;
    }

    public void setMarcadorDAO(MarcadorDAO marcadorDAO) {
        this.marcadorDAO = marcadorDAO;
    }

    public List<Marcador> getMarcadores() {
        return marcadores;
    }

    public void setMarcadores(List<Marcador> marcadores) {
        this.marcadores = marcadores;
    }
    
    public int getIdMarcador(){
	return idMarcador;
    } 

    public void setIdMarcador(int idMarcador){
	this.idMarcador = idMarcador;
    }   

    public void eliminaMarcador(Usuario usuario, String titulo, VerMarcadores ver){
        //Marcador m = marcadorDAO.ObtenMarcadoresPorUsuario(usuario.getCorreo(),titulo);
        marcadorDAO = new MarcadorDAO();
        marcadores = marcadorDAO.findAll();
        
        for(Marcador m : marcadores){
            if(m.getNombre().equals(titulo) && 
                    (usuario.getRol().equals("Administrador") || usuario.getCorreo().equals(m.getCorreo()))){                
                marcadorDAO.delete(m);
            }else{
                Mensajes.error("Sólo puedes eliminar marcadores tuyos");
            }
            
        }
        
        ver.otro();
    }
}
