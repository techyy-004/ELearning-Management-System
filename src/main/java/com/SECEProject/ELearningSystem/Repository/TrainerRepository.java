package com.SECEProject.ELearningSystem.Repository;

import com.SECEProject.ELearningSystem.Entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Integer> {}