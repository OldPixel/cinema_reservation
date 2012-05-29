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
import reserv.entity.Reservation;

/**
 *
 * @author muody
 */
@ManagedBean(name="ReservationBean")
@RequestScoped
public class ReservationBean {

    private Reservation reservation = new Reservation();

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
        List list = em.createNamedQuery("Reservation.findAll").getResultList();
        em.close();
        return list;
    }
    
}
