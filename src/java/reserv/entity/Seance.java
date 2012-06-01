/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reserv.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author muody
 */
@Entity
@Table(name = "seance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seance.findAll", query = "SELECT s FROM Seance s"),
    @NamedQuery(name = "Seance.findMovies", query = "SELECT s.movie FROM Seance s GROUP BY s.movie"),
    @NamedQuery(name = "Seance.findById", query = "SELECT s FROM Seance s WHERE s.id = :id"),
    @NamedQuery(name = "Seance.findBySeanceDate", query = "SELECT s FROM Seance s WHERE s.seanceDate = :seanceDate")})
public class Seance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "seance_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date seanceDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seance", fetch = FetchType.EAGER)
    private Set<Reservation> reservationSet;
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Movie movie;
    @JoinColumn(name = "cinema_auditorium_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CinemaAuditorium cinemaAuditorium;

    public Seance() {
    }

    public Seance(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getSeanceDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(seanceDate);
    }

    public String getSeanceDate(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(seanceDate);
    }

    public void setSeanceDate(Date seanceDate) {
        this.seanceDate = seanceDate;
    }

    @XmlTransient
    public Set<Reservation> getReservationSet() {
        return reservationSet;
    }

    public void setReservationSet(Set<Reservation> reservationSet) {
        this.reservationSet = reservationSet;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaAuditorium getCinemaAuditorium() {
        return cinemaAuditorium;
    }

    public void setCinemaAuditorium(CinemaAuditorium cinemaAuditorium) {
        this.cinemaAuditorium = cinemaAuditorium;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seance)) {
            return false;
        }
        Seance other = (Seance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "reserv.entity.Seance[ id=" + id + " ]";
    }
    
}
