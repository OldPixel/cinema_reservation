/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reserv.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import reserv.config.DBManager;
import reserv.entity.CinemaAuditorium;
import reserv.entity.Movie;


/**
 *
 * @author pixel
 */
@ManagedBean(name="CinemaAuditoriumBean")
@RequestScoped
public class CinemaAuditoriumBean {

    /**
     * Creates a new instance of CinemaAuditoriumBean
     */
    public CinemaAuditoriumBean() {
    }
    
    
    public List<SelectItem> getCinemaAuditoriumsList()
    {
        List<SelectItem> movies = new ArrayList<SelectItem>();
        
        EntityManager em = DBManager.getManager().createEntityManager();
        List<CinemaAuditorium> list = em.createNamedQuery("CinemaAuditorium.findAll").getResultList();
        
        for (CinemaAuditorium ca : list) {
            movies.add(new SelectItem(ca.getId(), ca.getName()));
        }
        
        em.close();        
        
        return movies;
    }
    
    public List<CinemaAuditorium> getCinemaAuditoriums()
    {
        EntityManager em = DBManager.getManager().createEntityManager();
        List<CinemaAuditorium> list = em.createNamedQuery("CinemaAuditorium.findAll").getResultList();
        
        em.close();
        return list;
    }
    
}
