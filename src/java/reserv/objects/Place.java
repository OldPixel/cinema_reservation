/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reserv.objects;

import reserv.entity.Reservation;

/**
 *
 * @author pixel
 */
public class Place {
    
    private Reservation reservation;
    private Boolean reservedPlace;
    

    public Boolean getReservedPlace() {
        return reservedPlace;        
    }

    public void setReservedPlace(Boolean reservedPlace) {
        this.reservedPlace = reservedPlace;
    }

   

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation r) {
        this.reservation = r;
    }
    
    public Place(Boolean empty, Reservation r)
    {
        this.reservedPlace = empty;
        this.reservation = r;         
    }
    
    public Place()
    {
        this.reservedPlace = false;
        this.reservation = null;         
    }
    
}
