package lctst.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "restaurant", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
    private Collection<MenuItem> menuItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
    private Collection<Vote> voteCollection;

    public Restaurant() {
    }

    public Restaurant(Integer id) {
        this.id = id;
    }

    public Restaurant(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Collection<MenuItem> getMenuItemCollection() {
        return menuItemCollection;
    }

    public void setMenuItemCollection(Collection<MenuItem> menuItemCollection) {
        this.menuItemCollection = menuItemCollection;
    }

    @JsonIgnore
    public Collection<Vote> getVoteCollection() {
        return voteCollection;
    }

    public void setVoteCollection(Collection<Vote> voteCollection) {
        this.voteCollection = voteCollection;
    }

    @Override
    public String toString() {
        return "lctst.model.Restaurant[ id=" + id + " ]";
    }

}
