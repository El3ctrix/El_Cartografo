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
    
    @PostConstruct
    public void init(){
        simpleModel = new DefaultMapModel();
        MarcadorDAO mdb = new MarcadorDAO();
        List<Marcador> marcadores = mdb.findAll();
        if(marcadores != null){
            for(Marcador m :marcadores){
                    LatLng cord = new LatLng(m.getLatitud(),m.getLongitud());
                    simpleModel.addOverlay(new Marker(cord,m.getNombre(),m));
            }
        }
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }
    
    public void onMarkerSelect(OverlaySelectEvent event) {
       marker =(Marker) event.getOverlay();
       
    }

    public Marker getMarker() {
        return marker;
    }
    
    
}
