/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reserv.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author muody
 */
@Entity
@Table(name = "cinema_auditorium")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CinemaAuditorium.findAll", query = "SELECT c FROM CinemaAuditorium c"),
    @NamedQuery(name = "CinemaAuditorium.findById", query = "SELECT c FROM CinemaAuditorium c WHERE c.id = :id"),
    @NamedQuery(name = "CinemaAuditorium.findByName", query = "SELECT c FROM CinemaAuditorium c WHERE c.name = :name")})
public class CinemaAuditorium implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 45)
    @Column(name = "name", length = 45)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cinemaAuditorium", fetch = FetchType.EAGER)
    private Set<Seance> seanceSet;

    public CinemaAuditorium() {
    }

    public CinemaAuditorium(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Set<Seance> getSeanceSet() {
        return seanceSet;
    }

    public void setSeanceSet(Set<Seance> seanceSet) {
        this.seanceSet = seanceSet;
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
        if (!(object instanceof CinemaAuditorium)) {
            return false;
        }
        CinemaAuditorium other = (CinemaAuditorium) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
