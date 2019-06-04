package controlador;

import modelo.Marcador;
import modelo.MarcadorDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author francisco
 */
@ManagedBean
@ViewScoped
public class VerMarcadores implements Serializable{
    
    private MapModel simpleModel;
    
    private Marker marker;
    private String data;
    private String titulo;
    
    @PostConstruct
    public void init(){
        simpleModel = new DefaultMapModel();
        MarcadorDAO mdb = new MarcadorDAO();
        List<Marcador> marcadores = mdb.findAll();
        if(marcadores != null && !marcadores.isEmpty()){
            for(Marcador m :marcadores){
                System.out.println("Marcador: " + m.getLatitud() + ", " + m.getLongitud()+ m.getDescripcion());
                System.out.print(m.toString());
                LatLng cord = new LatLng(m.getLatitud(),m.getLongitud());
                simpleModel.addOverlay(new Marker(cord,m.getNombre(),m.getDescripcion()));                
            }
        }
    }
    /**
     *
     * @return simpleModel
     */
    public MapModel getSimpleModel(){
        return simpleModel;
    }
    
    public void onMarkerSelect(OverlaySelectEvent event) {
       marker =(Marker) event.getOverlay();
       data = (String) marker.getData();
       titulo = (String) marker.getTitle();
    }

    public Marker getMarker() {
        return marker;
    }
    
    
}
