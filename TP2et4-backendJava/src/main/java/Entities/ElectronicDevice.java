package Entities;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by othmane on 22/01/2018.
 */
@Entity
@DiscriminatorValue("E")
public class ElectronicDevice extends IntelligentDevice{
    //private Long id;

    private String label;

    public ElectronicDevice() {

    }

    public ElectronicDevice( String label) {
        super();
        this.label = label;
    }
//    @Id
//    @GeneratedValue
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }



    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
