/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reserv.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import reserv.entity.Reservation;

/**
 *
 * @author muody
 */
@ManagedBean
@RequestScoped
public class ReservationBeans {

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
    public ReservationBeans() {
    }
    
}
