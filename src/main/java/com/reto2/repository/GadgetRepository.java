package com.reto2.repository;

import com.reto2.model.Gadget;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.reto2.repository.crud.GadgetCrudRepository;

/**
 *
 * @author DAVID BELTRAN
 */
@Repository
public class GadgetRepository {

    @Autowired
    private GadgetCrudRepository crudInterface;

    public List<Gadget> listAll() {
        return crudInterface.findAll();
    }

    public Optional<Gadget> getGadget(int id) {
        return crudInterface.findById(id);
    }

    public Gadget create(Gadget gadget) {
        return crudInterface.save(gadget);
    }

    public void update(Gadget gadget) {
        crudInterface.save(gadget);
    }

    public void delete(Gadget gadget) {
        crudInterface.delete(gadget);
    }
}
