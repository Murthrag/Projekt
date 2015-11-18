package cz.muni.fi.pa165.s02.buildingMachineRentals.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Matus Backor
 */
@Entity
public class Revision implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private Date revisionDate;

    @NotNull
    private String nameOfReviser;

    public int getId() {
        return id;
    }

    public Date getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }

    public String getReviserName() {
        return nameOfReviser;
    }

    public void setReviserName(String nameOfReviser) {
        this.nameOfReviser = nameOfReviser;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.revisionDate);
        hash = 53 * hash + Objects.hashCode(this.nameOfReviser);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Revision other = (Revision) obj;
        if (!Objects.equals(this.revisionDate, other.revisionDate)) {
            return false;
        }
        if (!Objects.equals(this.nameOfReviser, other.nameOfReviser)) {
            return false;
        }
        return true;
    }

    

}
