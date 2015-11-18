/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.s02.buildingMachineRentals.dao;

import cz.muni.fi.pa165.s02.buildingMachineRentals.entity.Machine;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
/**
 *
 * @author Adrian Elgyutt
 */
@Repository
public class MachineDaoImpl implements MachineDao {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addMachine(Machine m) {
        em.persist(m);
    }

    @Override
    public void deleteMachine(Machine m) {
        em.remove(m);
    }

    @Override
    public void updateMachine(Machine m) {
        em.merge(m);
    }

    @Override
    public Machine findMachineById(int id) {
        return em.find(Machine.class, id);
    }
    
}
