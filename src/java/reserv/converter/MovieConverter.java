/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reserv.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.persistence.EntityManager;
import reserv.config.DBManager;
import reserv.entity.Movie;

/**
 *
 * @author pixel
 */
public class MovieConverter implements Converter{

    @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    Integer i = Integer.valueOf(value);
    EntityManager em = DBManager.getManager().createEntityManager();
    Movie m = em.find(Movie.class, i);
    em.close();
    return m;
  }

    @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) {
    if(!(value instanceof Movie))
      throw new ConverterException(new FacesMessage("Nie udała się konwersja"));
    Movie p = (Movie)value;
    return p.getId().toString();
  }

}