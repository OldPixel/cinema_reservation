/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reserv.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import reserv.config.DBManager;
import reserv.entity.Reservation;
import reserv.objects.Place;


/**
 *
 * @author muody
 */




@ManagedBean(name="ReservationBean")
@SessionScoped
public class ReservationBean {

    private String placeNumber;
    private Integer seanceId;

    public String getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(ActionEvent event) {
        String name = (String) event.getComponent().getAttributes().get("name");  
        this.placeNumber=name;
        System.out.println(name);
    }

    public Integer getSeanceId() {
        return seanceId;
    }

    private Reservation reservation = new Reservation();
    

    public void setSeanceId(ActionEvent event) {
        String seance_id = (String) event.getComponent().getAttributes().get("seance_id");
        System.out.println(seance_id);
        this.seanceId = Integer.parseInt(seance_id);
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    /**
     * Creates a new instance of ReservationBeans
     */
    public ReservationBean() {
    }
    
    public List<Reservation> getAll(){
        EntityManager em = DBManager.getManager().createEntityManager();
        List<Reservation> list = em.createNamedQuery("Reservation.findAll").getResultList();
        em.close();
        return list;
    }
    
    public void reservPlaces(ActionEvent event)
    {
        
       String name = (String) event.getComponent().getAttributes().get("name"); 
       System.out.println("asd");
       System.out.println(name);
       
        //this.str=name; 
        
    }
    
    public List<Place> getSeancePlaces(Integer id){
        List<Place> placesList = new ArrayList<Place>();
        List<Reservation> reservationList = this.getAll();
        List<Integer> placesReserved = new ArrayList<Integer>();
        
        for (Reservation reserv : reservationList) {
            placesReserved.add(reserv.getPlace());
        }
        
        for (int i=0; i<100; i++)
        {
            Place p = new Place();
            if ( placesReserved.contains(i))
            {
                p.setReservedPlace(true);        
                p.setReservation(reservationList.get(placesReserved.lastIndexOf(i)));
            }
            else
            {
                Reservation r = new Reservation();
                r.setPlace(i);
                p.setReservation(r);
            }
            placesList.add(p);
        }
        return placesList;
    }
    
}
