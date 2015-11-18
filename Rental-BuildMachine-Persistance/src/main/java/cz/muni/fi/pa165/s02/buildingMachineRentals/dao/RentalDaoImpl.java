/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.s02.buildingMachineRentals.dao;

import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Rental;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Jan Pastrnak
 */
@Repository
@Transactional
public class RentalDaoImpl implements RentalDao {

    @PersistenceContext
    private EntityManager em;
        
    
    @Override
    public void addRental(Rental rent) {
        em.persist(rent);
    }

    @Override
    public void deleteRental(Rental rent) {
        em.remove(rent);
    }

    @Override
    public void updateRental(Rental rent) {
        em.merge(rent);
    }

    @Override
    public Rental findRental(int id) {
        return em.find(Rental.class, id);
    }
    
}
