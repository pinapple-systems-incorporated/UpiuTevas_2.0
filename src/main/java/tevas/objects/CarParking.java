/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tevas.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author manambar
 */
@Entity
@Table(name = "car_parking")
@NamedQueries({
    @NamedQuery(name = "CarParking.findAll", query = "SELECT c FROM CarParking c")
    , @NamedQuery(name = "CarParking.findById", query = "SELECT c FROM CarParking c WHERE c.id = :id")
    , @NamedQuery(name = "CarParking.findByIsParking", query = "SELECT c FROM CarParking c WHERE c.isParking = :isParking")
    , @NamedQuery(name = "CarParking.findByParkingAtStart", query = "SELECT c FROM CarParking c WHERE c.parkingAtStart = :parkingAtStart")
    , @NamedQuery(name = "CarParking.findByParkingAtMid", query = "SELECT c FROM CarParking c WHERE c.parkingAtMid = :parkingAtMid")
    , @NamedQuery(name = "CarParking.findByParkingAtEnd", query = "SELECT c FROM CarParking c WHERE c.parkingAtEnd = :parkingAtEnd")
    , @NamedQuery(name = "CarParking.findBySafety", query = "SELECT c FROM CarParking c WHERE c.safety = :safety")
    , @NamedQuery(name = "CarParking.findByArrangeByPhone", query = "SELECT c FROM CarParking c WHERE c.arrangeByPhone = :arrangeByPhone")})
public class CarParking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "isParking")
    private Boolean isParking;
    @Column(name = "parking_at_start")
    private Boolean parkingAtStart;
    @Column(name = "parking_at_mid")
    private Boolean parkingAtMid;
    @Column(name = "parking_at_end")
    private Boolean parkingAtEnd;
    @Column(name = "safety")
    private Boolean safety;
    @Column(name = "arrange_by_phone")
    private Boolean arrangeByPhone;
      @JsonIgnore
    @OneToMany(mappedBy = "parkingId")
    private List<Base> baseList;

    public CarParking() {
    }

    public CarParking(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsParking() {
        return isParking;
    }

    public void setIsParking(Boolean isParking) {
        this.isParking = isParking;
    }

    public Boolean getParkingAtStart() {
        return parkingAtStart;
    }

    public void setParkingAtStart(Boolean parkingAtStart) {
        this.parkingAtStart = parkingAtStart;
    }

    public Boolean getParkingAtMid() {
        return parkingAtMid;
    }

    public void setParkingAtMid(Boolean parkingAtMid) {
        this.parkingAtMid = parkingAtMid;
    }

    public Boolean getParkingAtEnd() {
        return parkingAtEnd;
    }

    public void setParkingAtEnd(Boolean parkingAtEnd) {
        this.parkingAtEnd = parkingAtEnd;
    }

    public Boolean getSafety() {
        return safety;
    }

    public void setSafety(Boolean safety) {
        this.safety = safety;
    }

    public Boolean getArrangeByPhone() {
        return arrangeByPhone;
    }

    public void setArrangeByPhone(Boolean arrangeByPhone) {
        this.arrangeByPhone = arrangeByPhone;
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
        if (!(object instanceof CarParking)) {
            return false;
        }
        CarParking other = (CarParking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tevas.objects.CarParking[ id=" + id + " ]";
    }
    
}
