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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cerephenien
 */
@Entity
@Table(name = "water_body_composition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WaterBodyComposition.findAll", query = "SELECT w FROM WaterBodyComposition w")
    , @NamedQuery(name = "WaterBodyComposition.findById", query = "SELECT w FROM WaterBodyComposition w WHERE w.id = :id")
    , @NamedQuery(name = "WaterBodyComposition.findByMonoRoute", query = "SELECT w FROM WaterBodyComposition w WHERE w.monoRoute = :monoRoute")
    , @NamedQuery(name = "WaterBodyComposition.findByWb1", query = "SELECT w FROM WaterBodyComposition w WHERE w.wb1 = :wb1")
    , @NamedQuery(name = "WaterBodyComposition.findByWb2", query = "SELECT w FROM WaterBodyComposition w WHERE w.wb2 = :wb2")
    , @NamedQuery(name = "WaterBodyComposition.findByWb3", query = "SELECT w FROM WaterBodyComposition w WHERE w.wb3 = :wb3")
    , @NamedQuery(name = "WaterBodyComposition.findByWb4", query = "SELECT w FROM WaterBodyComposition w WHERE w.wb4 = :wb4")
    , @NamedQuery(name = "WaterBodyComposition.findByWb5", query = "SELECT w FROM WaterBodyComposition w WHERE w.wb5 = :wb5")
    , @NamedQuery(name = "WaterBodyComposition.findByWb6", query = "SELECT w FROM WaterBodyComposition w WHERE w.wb6 = :wb6")
    , @NamedQuery(name = "WaterBodyComposition.findByWb7", query = "SELECT w FROM WaterBodyComposition w WHERE w.wb7 = :wb7")
    , @NamedQuery(name = "WaterBodyComposition.findByWb8", query = "SELECT w FROM WaterBodyComposition w WHERE w.wb8 = :wb8")
    , @NamedQuery(name = "WaterBodyComposition.findByWb9", query = "SELECT w FROM WaterBodyComposition w WHERE w.wb9 = :wb9")
    , @NamedQuery(name = "WaterBodyComposition.findByWb10", query = "SELECT w FROM WaterBodyComposition w WHERE w.wb10 = :wb10")})
public class WaterBodyComposition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mono_route")
    private boolean monoRoute;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "wb1")
    private String wb1;
    @Size(max = 255)
    @Column(name = "wb2")
    private String wb2;
    @Size(max = 255)
    @Column(name = "wb3")
    private String wb3;
    @Size(max = 255)
    @Column(name = "wb4")
    private String wb4;
    @Size(max = 255)
    @Column(name = "wb5")
    private String wb5;
    @Size(max = 255)
    @Column(name = "wb6")
    private String wb6;
    @Size(max = 255)
    @Column(name = "wb7")
    private String wb7;
    @Size(max = 255)
    @Column(name = "wb8")
    private String wb8;
    @Size(max = 255)
    @Column(name = "wb9")
    private String wb9;
    @Size(max = 255)
    @Column(name = "wb10")
    private String wb10;
    @OneToMany(mappedBy = "wbcId")
    @JsonIgnore
    private List<Base> baseList;

    public WaterBodyComposition() {
    }

    public WaterBodyComposition(Integer id) {
        this.id = id;
    }

    public WaterBodyComposition(Integer id, boolean monoRoute, String wb1) {
        this.id = id;
        this.monoRoute = monoRoute;
        this.wb1 = wb1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getMonoRoute() {
        return monoRoute;
    }

    public void setMonoRoute(boolean monoRoute) {
        this.monoRoute = monoRoute;
    }

    public String getWb1() {
        return wb1;
    }

    public void setWb1(String wb1) {
        this.wb1 = wb1;
    }

    public String getWb2() {
        return wb2;
    }

    public void setWb2(String wb2) {
        this.wb2 = wb2;
    }

    public String getWb3() {
        return wb3;
    }

    public void setWb3(String wb3) {
        this.wb3 = wb3;
    }

    public String getWb4() {
        return wb4;
    }

    public void setWb4(String wb4) {
        this.wb4 = wb4;
    }

    public String getWb5() {
        return wb5;
    }

    public void setWb5(String wb5) {
        this.wb5 = wb5;
    }

    public String getWb6() {
        return wb6;
    }

    public void setWb6(String wb6) {
        this.wb6 = wb6;
    }

    public String getWb7() {
        return wb7;
    }

    public void setWb7(String wb7) {
        this.wb7 = wb7;
    }

    public String getWb8() {
        return wb8;
    }

    public void setWb8(String wb8) {
        this.wb8 = wb8;
    }

    public String getWb9() {
        return wb9;
    }

    public void setWb9(String wb9) {
        this.wb9 = wb9;
    }

    public String getWb10() {
        return wb10;
    }

    public void setWb10(String wb10) {
        this.wb10 = wb10;
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
        if (!(object instanceof WaterBodyComposition)) {
            return false;
        }
        WaterBodyComposition other = (WaterBodyComposition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tevas.objects.WaterBodyComposition[ id=" + id + " ]";
    }
    
}
