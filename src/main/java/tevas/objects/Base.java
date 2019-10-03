/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tevas.objects;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author manambar
 */
@Entity
@Table(name = "base")
@NamedQueries({
    @NamedQuery(name = "Base.findAll", query = "SELECT b FROM Base b")
    , @NamedQuery(name = "Base.findById", query = "SELECT b FROM Base b WHERE b.id = :id")
    , @NamedQuery(name = "Base.findByActive", query = "SELECT b FROM Base b WHERE b.active = :active")})
public class Base implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @JoinColumn(name = "parking_id", referencedColumnName = "id")
    @ManyToOne
    private CarParking parkingId;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne
    private Routes routeId;
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    @ManyToOne
    private Shops shopId;
    @JoinColumn(name = "sleeping_id", referencedColumnName = "id")
    @ManyToOne
    private Sleeping sleepingId;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne
    private Suppliers supplierId;
    @JoinColumn(name = "wbc_id", referencedColumnName = "id")
    @ManyToOne
    private WaterBodyComposition wbcId;

    public Base() {
    }

    public Base(Integer id) {
        this.id = id;
    }

    public Base(Integer id, boolean active) {
        this.id = id;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CarParking getParkingId() {
        return parkingId;
    }

    public void setParkingId(CarParking parkingId) {
        this.parkingId = parkingId;
    }

    public Routes getRouteId() {
        return routeId;
    }

    public void setRouteId(Routes routeId) {
        this.routeId = routeId;
    }

    public Shops getShopId() {
        return shopId;
    }

    public void setShopId(Shops shopId) {
        this.shopId = shopId;
    }

    public Sleeping getSleepingId() {
        return sleepingId;
    }

    public void setSleepingId(Sleeping sleepingId) {
        this.sleepingId = sleepingId;
    }

    public Suppliers getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Suppliers supplierId) {
        this.supplierId = supplierId;
    }

    public WaterBodyComposition getWbcId() {
        return wbcId;
    }

    public void setWbcId(WaterBodyComposition wbcId) {
        this.wbcId = wbcId;
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
        if (!(object instanceof Base)) {
            return false;
        }
        Base other = (Base) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Base{" + "id=" + id + ", active=" + active + ", parkingId=" + parkingId + ", routeId=" + routeId + ", shopId=" + shopId + ", sleepingId=" + sleepingId + ", supplierId=" + supplierId + ", wbcId=" + wbcId + '}';
    }

  
    
}
