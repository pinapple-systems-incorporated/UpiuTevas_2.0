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
@Table(name = "shops")
@NamedQueries({
    @NamedQuery(name = "Shops.findAll", query = "SELECT s FROM Shops s")
    , @NamedQuery(name = "Shops.findById", query = "SELECT s FROM Shops s WHERE s.id = :id")
    , @NamedQuery(name = "Shops.findByIsShop", query = "SELECT s FROM Shops s WHERE s.isShop = :isShop")
    , @NamedQuery(name = "Shops.findByShopBefore", query = "SELECT s FROM Shops s WHERE s.shopBefore = :shopBefore")
    , @NamedQuery(name = "Shops.findByShopOnRoad", query = "SELECT s FROM Shops s WHERE s.shopOnRoad = :shopOnRoad")
    , @NamedQuery(name = "Shops.findByShopAfter", query = "SELECT s FROM Shops s WHERE s.shopAfter = :shopAfter")})
public class Shops implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "isShop")
    private Boolean isShop;
    @Column(name = "shop_before")
    private Boolean shopBefore;
    @Column(name = "shop_on_road")
    private Boolean shopOnRoad;
    @Column(name = "shop_after")
    private Boolean shopAfter;
      @JsonIgnore
    @OneToMany(mappedBy = "shopId")
    private List<Base> baseList;

    public Shops() {
    }

    public Shops(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsShop() {
        return isShop;
    }

    public void setIsShop(Boolean isShop) {
        this.isShop = isShop;
    }

    public Boolean getShopBefore() {
        return shopBefore;
    }

    public void setShopBefore(Boolean shopBefore) {
        this.shopBefore = shopBefore;
    }

    public Boolean getShopOnRoad() {
        return shopOnRoad;
    }

    public void setShopOnRoad(Boolean shopOnRoad) {
        this.shopOnRoad = shopOnRoad;
    }

    public Boolean getShopAfter() {
        return shopAfter;
    }

    public void setShopAfter(Boolean shopAfter) {
        this.shopAfter = shopAfter;
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
        if (!(object instanceof Shops)) {
            return false;
        }
        Shops other = (Shops) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tevas.objects.Shops[ id=" + id + " ]";
    }
    
}
