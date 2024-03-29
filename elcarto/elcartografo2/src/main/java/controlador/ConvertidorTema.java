/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import java.util.function.Predicate;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Tema;

/**
 *
 * @author alexrl
 */
@FacesConverter("convierte")
public class ConvertidorTema implements Converter{
    
    @Override
     public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Object o = null;
        if (!(string == null || string.isEmpty())) {
            o = this.getSelectedItemAsEntity(uic, string);
        }
        return o;
    }
     
    private Tema getSelectedItemAsEntity(UIComponent comp, String value) {
        Tema item = null;

        List<Tema> selectItems = null;
        for (UIComponent uic : comp.getChildren()) {
            if (uic instanceof UISelectItems) {
                String itemId = String.valueOf(value);
                selectItems = (List<Tema>) ((UISelectItems) uic).getValue();

                if (itemId != null && selectItems != null && !selectItems.isEmpty()) {
                    Predicate<Tema> predicate = i -> i.getNombre().equals(itemId);
                    item = selectItems.stream().filter(predicate).findFirst().orElse(null);
                }
            }
        }
        return item;
}
     
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String s = "";
        if (o != null) {
            s = ((Tema) o).getNombre().toString();
        }
        return s;
    }

}
