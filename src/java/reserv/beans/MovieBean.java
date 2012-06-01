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
import reserv.entity.Movie;
import reserv.entity.Reservation;
import reserv.entity.Seance;
import reserv.objects.PixTomMessages;

/**
 *
 * @author muody
 */
@ManagedBean(name="MovieBean")
@RequestScoped
public class MovieBean {

    private String name;
    private Movie movie = new Movie();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String addMovie()
    {      
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        try{
            movie.setId(null);
            movie.setName(name);            
            em.persist(movie);
            em.getTransaction().commit();    
            em.close();

            this.movie = new Movie();
            this.name = "";
            PixTomMessages.addFlash("Film został dodany pomyślnie.");
            
           
        }
        catch(javax.validation.ConstraintViolationException e)
        {
            System.out.println("WYJATEK !!!!!");
            System.out.println(e.getConstraintViolations().toString());
            
        }

        return "panel";

    }
    
    
    /**
     * Creates a new instance of MovieBean
     */
    public MovieBean() {
    }
    
    public List<Movie> getMovies()
    {
        EntityManager em = DBManager.getManager().createEntityManager();
        List<Movie> list = em.createNamedQuery("Movie.findAll").getResultList();
        
//        Movie test = (Movie) list.get(0);
//        
//        System.err.println(test.getSeanceSet());
        
        em.close();
        return list;
    }
    
    public List<SelectItem> allMovies()
    {
        List<SelectItem> movies = new ArrayList<SelectItem>();
        
        EntityManager em = DBManager.getManager().createEntityManager();
        List<Movie> list = em.createNamedQuery("Movie.findAll").getResultList();
        
        for (Movie m : list) {
            movies.add(new SelectItem(m.getId(), m.getName()));
        }
        
        em.close();        
        
        return movies;
    }
}
