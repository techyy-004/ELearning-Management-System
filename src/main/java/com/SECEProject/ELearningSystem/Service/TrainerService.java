package com.SECEProject.ELearningSystem.Service;

import com.SECEProject.ELearningSystem.Entity.Trainer;
import com.SECEProject.ELearningSystem.Repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public Trainer saveTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Optional<Trainer> getTrainerById(Integer tr_id) {
        return trainerRepository.findById(tr_id);
    }

    public Trainer updateTrainer(Integer tr_id, Trainer updatedTrainer) {
        return trainerRepository.findById(tr_id).map(trainer -> {
            trainer.setTr_name(updatedTrainer.getTr_name());
            trainer.setTr_email(updatedTrainer.getTr_email());
            trainer.setTr_phone(updatedTrainer.getTr_phone());
            trainer.setTr_password(updatedTrainer.getTr_password());
            trainer.setTr_institution(updatedTrainer.getTr_institution());
            trainer.setTr_specialization(updatedTrainer.getTr_specialization());
            return trainerRepository.save(trainer);
        }).orElseThrow(() -> new RuntimeException("Trainer not found with ID: " + tr_id));
    }

    public String deleteTrainer(Integer tr_id) {
        if (trainerRepository.existsById(tr_id)) {
            trainerRepository.deleteById(tr_id);
            return "Trainer deleted successfully!";
        } else {
            throw new RuntimeException("Trainer not found with ID: " + tr_id);
        }
    }
}
