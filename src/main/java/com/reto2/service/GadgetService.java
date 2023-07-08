package com.reto2.service;

import com.reto2.model.Gadget;
import com.reto2.repository.GadgetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAVID BELTRAN 
 */
@Service
public class GadgetService {

    @Autowired
    private GadgetRepository repositorio;

    public List<Gadget> listAll() {
        return repositorio.listAll();
    }

    public Optional<Gadget> getGadget(int id) {
        return repositorio.getGadget(id);
    }

    public Gadget create(Gadget gadget) {
        if (gadget.getId()== null) {
            return gadget;
        } else {
            return repositorio.create(gadget);
        }
    }

    public Gadget update(Gadget gadget) {

        if (gadget.getId()!= null) {
            Optional<Gadget> gadgetDB = repositorio.getGadget(gadget.getId());
            if (!gadgetDB.isEmpty()) {
                if (gadget.getBrand() != null) {
                    gadgetDB.get().setBrand(gadget.getBrand());
                }
                if (gadget.getCategory() != null) {
                    gadgetDB.get().setCategory(gadget.getCategory());
                }
                if (gadget.getName()!= null) {
                    gadgetDB.get().setName(gadget.getName());
                }
                if (gadget.getDescription() != null) {
                    gadgetDB.get().setDescription(gadget.getDescription());
                }
                if (gadget.getPrice() != 0.0) {
                    gadgetDB.get().setPrice(gadget.getPrice());
                }
                if (gadget.getQuantity() != 0) {
                    gadgetDB.get().setQuantity(gadget.getQuantity());
                }
                if (gadget.getPhotography() != null) {
                    gadgetDB.get().setPhotography(gadget.getPhotography());
                }
                gadgetDB.get().setAvailability(gadget.isAvailability());
                repositorio.update(gadgetDB.get());
                return gadgetDB.get();
            } else {
                return gadget;
            }
        } else {
            return gadget;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getGadget(id).map(supplement -> {
            repositorio.delete(supplement);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
