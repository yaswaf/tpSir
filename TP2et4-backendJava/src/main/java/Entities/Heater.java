package Entities;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by othmane on 22/01/2018.
 */
@Entity
@DiscriminatorValue("H")
public class Heater extends IntelligentDevice{


    private String label;

    public Heater() {

    }

    public Heater( String label) {
        super();
        this.label = label;
    }




    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
