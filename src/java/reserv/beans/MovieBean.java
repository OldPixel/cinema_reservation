/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reserv.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import reserv.config.DBManager;
import reserv.entity.Movie;

/**
 *
 * @author muody
 */
@ManagedBean(name="MovieBean")
@RequestScoped
public class MovieBean {

    /**
     * Creates a new instance of MovieBean
     */
    public MovieBean() {
    }
    
        public List<Movie> getMovies()
    {
        EntityManager em = DBManager.getManager().createEntityManager();
        List list = em.createNamedQuery("Movie.findAll").getResultList();
        
//        Movie test = (Movie) list.get(0);
//        
//        System.err.println(test.getSeanceSet());
        
        em.close();
        return list;
    }
}
