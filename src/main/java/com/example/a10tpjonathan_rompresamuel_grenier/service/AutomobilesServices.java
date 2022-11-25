package com.example.a10tpjonathan_rompresamuel_grenier.service;

import com.example.a10tpjonathan_rompresamuel_grenier.model.Automobile;
import com.example.a10tpjonathan_rompresamuel_grenier.repository.AutomobilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AutomobilesServices {
    @Autowired
    private AutomobilesRepository automobilesRepository;

    public List<Automobile> listerAutomobiles() {
        return automobilesRepository.findAll();
    }

    public void ajouterAutomobile(Automobile automobile) {
        automobilesRepository.save(automobile);
    }

    public Automobile trouverAutomobile(Integer id) {
        return automobilesRepository.findById(id).get();
    }


    public void supprimerAutomobiles(Integer id) {
        if (automobilesRepository.existsById(id)) {
            automobilesRepository.deleteById(id);
        }
    }

    public void updateProduct(Integer automobileId, int annee, String model, String motopropulsion, String transmission, String license, double prix) {
        if (automobilesRepository.existsById(automobileId)) {
            Automobile automobile = automobilesRepository.findById(automobileId).get();
            automobile.setAnnee(annee);
            automobile.setModel(model);
            automobile.setMotopropulsion(motopropulsion);
            automobile.setTransmission(transmission);
            automobile.setLicence(license);
            automobile.setPrix(prix);
        }
    }
}