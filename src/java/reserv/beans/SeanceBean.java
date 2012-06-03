/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reserv.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.persistence.EntityManager;
import reserv.config.DBManager;
import reserv.entity.Movie;
import reserv.entity.Seance;
import reserv.objects.PixTomMessages;
import reserv.objects.SeanceHelper;

/**
 *
 * @author muody
 */
@ManagedBean(name="SeanceBean")
@RequestScoped
public class SeanceBean {
    
    private String hour;
    private String day;
    private String month;
    private Seance seance = new Seance();
    

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }


    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }
    
    /**
     * Creates a new instance of SeanceBean
     */
    public SeanceBean() {
    }
    
    public List<Movie> getTodaySeanceMovies()
    {
        EntityManager em = DBManager.getManager().createEntityManager();
        java.util.Date now = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String actual = formatter.format(now);
        
        String begin_actual = actual + " 00:00:00";
        String end_actual = actual + " 23:59:59";
        List list = em.createQuery("SELECT s.movie FROM Seance s WHERE s.seanceDate >= '"+begin_actual+"' "
                + "AND s.seanceDate <= '"+end_actual+"' GROUP BY s.movie").getResultList();
//        Movie test = (Movie) list.get(0);
//        
//        System.err.println(test.getName());
        
        
        //List<Integer> movies = new ArrayList<Integer>();
//        for (Iterator it = list.iterator(); it.hasNext();) {
//            Movie object = (Movie) it.next();
//            movies.add(object.getId());
//            System.out.println(movies.get(0));
//        }
        
        em.close();
        return list;
    }
    
    public List<String> allHours()
    {
        return SeanceHelper.getHours();
    }
    public List<String> allDays()
    {
        return SeanceHelper.getDays();
    }
    public List<String> allMonths()
    {
        return SeanceHelper.getMonths();
    }
    
    public String addSeance()
    {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        try{
            seance.setId(null);
            Integer hrs = Integer.parseInt(hour.substring(0, 2));
            Integer min = Integer.parseInt(hour.substring(3, 5));
            
            System.out.println("Miesiąc: " + month);
            System.out.println("Dzień: " + day);
            System.out.println("Godzina: " + hrs.toString());
            System.out.println("Minuta: " + min.toString());
            
            Calendar c = Calendar.getInstance();
            c.set(2012, Integer.parseInt(month) -1, Integer.parseInt(day), hrs, min,0);            
            java.util.Date dt = c.getTime();

            seance.setSeanceDate(dt);
                      
            em.persist(seance);
            em.getTransaction().commit();    
            em.close();

            this.seance = new Seance();
            PixTomMessages.addFlash("Seans został dodany pomyślnie.");
            
           
        }
        catch(javax.validation.ConstraintViolationException e)
        {
            System.out.println("WYJATEK !!!!!");
            System.out.println(e.getConstraintViolations().toString());
            
        }

        return "panel";
    }
    
    
}
