/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.s02.buildingMachineRentals.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

/**
 *
 * @author Adrian Elgyutt
 */
@Entity
public class Machine {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    private String type;
    
    private int machineNumber;
    
    private Double pricePerDay;
    
    @OneToOne
    @JoinTable(name="LAST_REVISON")
    private Revision lastRevision;
    
    public Machine(){
    }
      
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMachineNumber() {
        return machineNumber;
    }

    public void setMachineNumber(int machineNumber) {
        this.machineNumber = machineNumber;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Revision getLastRevision() {
        return lastRevision;
    }

    public void setLastRevision(Revision lastRevision) {
        this.lastRevision = lastRevision;
    }
    
    @Override
    public int hashCode(){
        final int prime = 47;
        int result = prime * machineNumber + (type == null ? 0 : type.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
	if (obj == null) return false;
        if (!(obj instanceof Machine)) return false;
        Machine other = (Machine) obj;
	if (type == null) {
		if (other.type != null) return false;
                if (this.machineNumber != other.getMachineNumber()){
                    return false;
                }
	} else if (!type.equals(other.getType())){
		return false;
        }
        return true;
    }
}
