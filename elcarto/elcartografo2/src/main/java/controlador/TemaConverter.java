/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Tema;

/**
 *
 * @author alexrl
 */

@FacesConverter(value="TemaConverter")
public class TemaConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String temaId){
        ValueExpression vex = ctx.getApplication().getExpressionFactory()
                .createValueExpression(ctx.getELContext(), "#{verTema}", VerTema.class);
        VerTema verTema = (VerTema)vex.getValue(ctx.getELContext());
        return verTema.getTemaId(temaId);
    }
    
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object tema){
        return ((Tema) tema).getNombre().toString();
    }

    
}