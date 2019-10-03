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
@Table(name = "routes")
@NamedQueries({
    @NamedQuery(name = "Routes.findAll", query = "SELECT r FROM Routes r")
    , @NamedQuery(name = "Routes.findById", query = "SELECT r FROM Routes r WHERE r.id = :id")
    , @NamedQuery(name = "Routes.findByLengthKm", query = "SELECT r FROM Routes r WHERE r.lengthKm = :lengthKm")
    , @NamedQuery(name = "Routes.findByTimeToCompleteH", query = "SELECT r FROM Routes r WHERE r.timeToCompleteH = :timeToCompleteH")
    , @NamedQuery(name = "Routes.findByTimeToCompleteDays", query = "SELECT r FROM Routes r WHERE r.timeToCompleteDays = :timeToCompleteDays")
    , @NamedQuery(name = "Routes.findByCoastAccessibility", query = "SELECT r FROM Routes r WHERE r.coastAccessibility = :coastAccessibility")
    , @NamedQuery(name = "Routes.findByRouteProlongation", query = "SELECT r FROM Routes r WHERE r.routeProlongation = :routeProlongation")
    , @NamedQuery(name = "Routes.findByAvgVelocityKmH", query = "SELECT r FROM Routes r WHERE r.avgVelocityKmH = :avgVelocityKmH")
    , @NamedQuery(name = "Routes.findByAvgPermeability", query = "SELECT r FROM Routes r WHERE r.avgPermeability = :avgPermeability")})
public class Routes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "length_km")
    private Integer lengthKm;
    @Column(name = "time_to_complete_h")
    private Integer timeToCompleteH;
    @Column(name = "time_to_complete_days")
    private Integer timeToCompleteDays;
    @Column(name = "coast_accessibility")
    private Boolean coastAccessibility;
    @Column(name = "route_prolongation")
    private Boolean routeProlongation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "avg_velocity_km_h")
    private Double avgVelocityKmH;
    @Column(name = "avg_permeability")
    private Boolean avgPermeability;
      @JsonIgnore
    @OneToMany(mappedBy = "routeId")
    private List<Base> baseList;

    public Routes() {
    }

    public Routes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLengthKm() {
        return lengthKm;
    }

    public void setLengthKm(Integer lengthKm) {
        this.lengthKm = lengthKm;
    }

    public Integer getTimeToCompleteH() {
        return timeToCompleteH;
    }

    public void setTimeToCompleteH(Integer timeToCompleteH) {
        this.timeToCompleteH = timeToCompleteH;
    }

    public Integer getTimeToCompleteDays() {
        return timeToCompleteDays;
    }

    public void setTimeToCompleteDays(Integer timeToCompleteDays) {
        this.timeToCompleteDays = timeToCompleteDays;
    }

    public Boolean getCoastAccessibility() {
        return coastAccessibility;
    }

    public void setCoastAccessibility(Boolean coastAccessibility) {
        this.coastAccessibility = coastAccessibility;
    }

    public Boolean getRouteProlongation() {
        return routeProlongation;
    }

    public void setRouteProlongation(Boolean routeProlongation) {
        this.routeProlongation = routeProlongation;
    }

    public Double getAvgVelocityKmH() {
        return avgVelocityKmH;
    }

    public void setAvgVelocityKmH(Double avgVelocityKmH) {
        this.avgVelocityKmH = avgVelocityKmH;
    }

    public Boolean getAvgPermeability() {
        return avgPermeability;
    }

    public void setAvgPermeability(Boolean avgPermeability) {
        this.avgPermeability = avgPermeability;
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
        if (!(object instanceof Routes)) {
            return false;
        }
        Routes other = (Routes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tevas.objects.Routes[ id=" + id + " ]";
    }
    
}
