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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cerephenien
 */
@Entity
@Table(name = "car_parking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarParking.findAll", query = "SELECT c FROM CarParking c")
    , @NamedQuery(name = "CarParking.findById", query = "SELECT c FROM CarParking c WHERE c.id = :id")
    , @NamedQuery(name = "CarParking.findByCarParkingAtStart", query = "SELECT c FROM CarParking c WHERE c.carParkingAtStart = :carParkingAtStart")
    , @NamedQuery(name = "CarParking.findByCarParkingAtMid", query = "SELECT c FROM CarParking c WHERE c.carParkingAtMid = :carParkingAtMid")
    , @NamedQuery(name = "CarParking.findByCarParkingAtEnd", query = "SELECT c FROM CarParking c WHERE c.carParkingAtEnd = :carParkingAtEnd")
    , @NamedQuery(name = "CarParking.findByCarSafety", query = "SELECT c FROM CarParking c WHERE c.carSafety = :carSafety")
    , @NamedQuery(name = "CarParking.findByArrangeByPhone", query = "SELECT c FROM CarParking c WHERE c.arrangeByPhone = :arrangeByPhone")})
public class CarParking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "car_parking_at_start")
    private Boolean carParkingAtStart;
    @Column(name = "car_parking_at_mid")
    private Boolean carParkingAtMid;
    @Column(name = "car_parking_at_end")
    private Boolean carParkingAtEnd;
    @Column(name = "car_safety")
    private Boolean carSafety;
    @Column(name = "arrange_by_phone")
    private Boolean arrangeByPhone;
    @OneToMany(mappedBy = "parkingId")
    @JsonIgnore
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

    public Boolean getCarParkingAtStart() {
        return carParkingAtStart;
    }

    public void setCarParkingAtStart(Boolean carParkingAtStart) {
        this.carParkingAtStart = carParkingAtStart;
    }

    public Boolean getCarParkingAtMid() {
        return carParkingAtMid;
    }

    public void setCarParkingAtMid(Boolean carParkingAtMid) {
        this.carParkingAtMid = carParkingAtMid;
    }

    public Boolean getCarParkingAtEnd() {
        return carParkingAtEnd;
    }

    public void setCarParkingAtEnd(Boolean carParkingAtEnd) {
        this.carParkingAtEnd = carParkingAtEnd;
    }

    public Boolean getCarSafety() {
        return carSafety;
    }

    public void setCarSafety(Boolean carSafety) {
        this.carSafety = carSafety;
    }

    public Boolean getArrangeByPhone() {
        return arrangeByPhone;
    }

    public void setArrangeByPhone(Boolean arrangeByPhone) {
        this.arrangeByPhone = arrangeByPhone;
    }

    @XmlTransient
    public List<Base> getBaseList() {
        return baseList;
    }

    public void setBaseList(List<Base> baseList) {
        this.baseList = baseList;
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
