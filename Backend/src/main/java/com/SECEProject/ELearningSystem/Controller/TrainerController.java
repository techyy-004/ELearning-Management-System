package com.SECEProject.ELearningSystem.Controller;

import com.SECEProject.ELearningSystem.Entity.Trainer;
import com.SECEProject.ELearningSystem.Service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @PostMapping
    public String createTrainer(@RequestBody Trainer trainer) {
        trainerService.saveTrainer(trainer);
        return "Trainer created successfully!";
    }

    @GetMapping
    public List<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    @GetMapping("/{tr_id}")
    public Optional<Trainer> getTrainerById(@PathVariable Integer tr_id) {
        return trainerService.getTrainerById(tr_id);
    }

    @PutMapping("/{tr_id}")
    public String updateTrainer(@PathVariable Integer tr_id, @RequestBody Trainer trainer) {
        trainerService.updateTrainer(tr_id, trainer);
        return "Trainer updated successfully!";
    }

    @DeleteMapping("/{tr_id}")
    public String deleteTrainer(@PathVariable Integer tr_id) {
        return trainerService.deleteTrainer(tr_id);
    }
}
