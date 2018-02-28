package Entities;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Home implements Serializable{

    private Long id;
    private Double taille;
    private int nbPieces;
    private Personne personne;
    private List<IntelligentDevice> intelligentDevices = new ArrayList<IntelligentDevice>();

    public Home(Double taille, int nbPieces, Personne personne, List<IntelligentDevice> intelligentDevices) {
        this.taille = taille;
        this.nbPieces = nbPieces;
        this.personne = personne;
        this.intelligentDevices = intelligentDevices;
    }

    public Home() {
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Double getTaille() {
        return taille;
    }

    public void setTaille(Double taille) {
        this.taille = taille;
    }

    public int getNbPieces() {
        return nbPieces;
    }

    public void setNbPieces(int nbPieces) {
        this.nbPieces = nbPieces;
    }
    @ManyToOne
    @JsonBackReference
    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @OneToMany(mappedBy = "home", cascade = {CascadeType.ALL})
    @JsonManagedReference
    public List<IntelligentDevice> getIntelligentDevices() {
        return intelligentDevices;
    }

    public void setIntelligentDevices(List<IntelligentDevice> intelligentDevices) {
        this.intelligentDevices = intelligentDevices;
    }
/* @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department="
                + department.getName() + "]";
    }*/
}
