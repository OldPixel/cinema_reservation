/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reserv.converter;

/**
 *
 * @author pixel
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.persistence.EntityManager;
import reserv.config.DBManager;
import reserv.entity.CinemaAuditorium;

/**
 *
 * @author pixel
 */
public class CinemaAuditoriumConverter implements Converter{

    @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    Integer i = Integer.valueOf(value);
    EntityManager em = DBManager.getManager().createEntityManager();
    CinemaAuditorium m = em.find(CinemaAuditorium.class, i);
    em.close();
    return m;
  }

    @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) {
    if(!(value instanceof CinemaAuditorium))
      throw new ConverterException(new FacesMessage("Konwersja się nie udała."));
    CinemaAuditorium p = (CinemaAuditorium)value;
    return p.getId().toString();
  }

}