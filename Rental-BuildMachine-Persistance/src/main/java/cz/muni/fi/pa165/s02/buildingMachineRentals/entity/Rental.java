package cz.muni.fi.pa165.s02.buildingMachineRentals.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jan Pastrnak
 */
@Entity
public class Rental {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    private int id;
    
    @NotNull
    @Column(nullable = false, unique = false)
    private Date rentalDate;
        
    private Date returnDate;
    
    @ManyToOne
    @NotNull
    private Customer customer;
    
    @OneToOne
    @NotNull
    private Machine machine; 

    public Rental() {
    }

    public Rental(int id, Date rentalDate, Customer customer, Machine machine) {
        this.id = id;
        this.rentalDate = rentalDate;
        this.customer = customer;
        this.machine = machine;
    }
    
    public int getId() {
        return id;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
        
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Machine getMachine() {
        return machine;
    }    

     public void setMachine(Machine machine) {
        this.machine = machine;
    }
        
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.rentalDate);
        hash = 23 * hash + Objects.hashCode(this.customer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof  Rental)) {
            return false;
        }
        final Rental other = (Rental) obj;
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.machine, other.machine)) {
            return false;
        }
        if (!Objects.equals(this.rentalDate, other.rentalDate)) {
            return false;
        }
        if (!Objects.equals(this.returnDate, other.returnDate)) {
            return false;
        }        
        return true;
    }
    
    
}
