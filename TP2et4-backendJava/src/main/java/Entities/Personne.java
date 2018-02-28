package Entities;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Personne implements Serializable{

    private Long id;
    private String nom;
    private String prenom;
    private String mail;
    private List<Home> homes = new ArrayList<Home>();
    private List<Personne> friends = new ArrayList<Personne>();
    private List<IntelligentDevice> intelligentDevices=new ArrayList<IntelligentDevice>();

    public Personne(String nom, String prenom, String mail, List<Home> homes, List<Personne> friends,
                    List<IntelligentDevice> intelligentDevices) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.homes = homes;
        this.friends = friends;
        this.intelligentDevices = intelligentDevices;
    }

    public Personne() {
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    @OneToMany(mappedBy = "personne", cascade = {CascadeType.ALL})
//    @JsonProperty
    @JsonManagedReference
    public List<Home> getHomes() {
        return homes;
    }

    public void setHomes(List<Home> homes) {
        this.homes = homes;
    }

    @ManyToMany
    @JsonProperty
    public List<Personne> getFriends() {
        return friends;
    }

    @JsonIgnore
    public void setFriends(List<Personne> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "personne", cascade = {CascadeType.ALL})
    @JsonProperty
    public List<IntelligentDevice> getIntelligentDevices() {
        return intelligentDevices;
    }

    public void setIntelligentDevices(List<IntelligentDevice> intelligentDevices) {
        this.intelligentDevices = intelligentDevices;
    }
}

