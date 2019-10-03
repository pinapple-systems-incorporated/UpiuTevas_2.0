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
@Table(name = "sleeping")
@NamedQueries({
    @NamedQuery(name = "Sleeping.findAll", query = "SELECT s FROM Sleeping s")
    , @NamedQuery(name = "Sleeping.findById", query = "SELECT s FROM Sleeping s WHERE s.id = :id")
    , @NamedQuery(name = "Sleeping.findByIsSleep", query = "SELECT s FROM Sleeping s WHERE s.isSleep = :isSleep")
    , @NamedQuery(name = "Sleeping.findByPrivateCamping", query = "SELECT s FROM Sleeping s WHERE s.privateCamping = :privateCamping")
    , @NamedQuery(name = "Sleeping.findByCostsMoney", query = "SELECT s FROM Sleeping s WHERE s.costsMoney = :costsMoney")
    , @NamedQuery(name = "Sleeping.findByPublicCamping", query = "SELECT s FROM Sleeping s WHERE s.publicCamping = :publicCamping")
    , @NamedQuery(name = "Sleeping.findByBed", query = "SELECT s FROM Sleeping s WHERE s.bed = :bed")
    , @NamedQuery(name = "Sleeping.findByForCampers", query = "SELECT s FROM Sleeping s WHERE s.forCampers = :forCampers")})
public class Sleeping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_sleep")
    private Boolean isSleep;
    @Column(name = "private_camping")
    private Boolean privateCamping;
    @Column(name = "costs_money")
    private Boolean costsMoney;
    @Column(name = "public_camping")
    private Boolean publicCamping;
    @Column(name = "bed")
    private Boolean bed;
    @Column(name = "for_campers")
    private Boolean forCampers;
      @JsonIgnore
    @OneToMany(mappedBy = "sleepingId")
    private List<Base> baseList;

    public Sleeping() {
    }

    public Sleeping(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsSleep() {
        return isSleep;
    }

    public void setIsSleep(Boolean isSleep) {
        this.isSleep = isSleep;
    }

    public Boolean getPrivateCamping() {
        return privateCamping;
    }

    public void setPrivateCamping(Boolean privateCamping) {
        this.privateCamping = privateCamping;
    }

    public Boolean getCostsMoney() {
        return costsMoney;
    }

    public void setCostsMoney(Boolean costsMoney) {
        this.costsMoney = costsMoney;
    }

    public Boolean getPublicCamping() {
        return publicCamping;
    }

    public void setPublicCamping(Boolean publicCamping) {
        this.publicCamping = publicCamping;
    }

    public Boolean getBed() {
        return bed;
    }

    public void setBed(Boolean bed) {
        this.bed = bed;
    }

    public Boolean getForCampers() {
        return forCampers;
    }

    public void setForCampers(Boolean forCampers) {
        this.forCampers = forCampers;
    }

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
        if (!(object instanceof Sleeping)) {
            return false;
        }
        Sleeping other = (Sleeping) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tevas.objects.Sleeping[ id=" + id + " ]";
    }
    
}
