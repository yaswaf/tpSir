package Entities;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by othmane on 22/01/2018.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeAppareil",
        discriminatorType=DiscriminatorType.STRING,length=25)
public class IntelligentDevice implements Serializable{


    private Long id;
    private Home home;
    private Personne personne;
    public IntelligentDevice() {
    }

    public IntelligentDevice(Home home) {
        this.home = home;
    }
    @ManyToOne
    @JsonBackReference
    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    @ManyToOne
    @JsonIgnore
    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
