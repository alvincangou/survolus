package com.mkyong.repositories;

import com.mkyong.model.Module;
import com.mkyong.model.Triggered;
import com.mkyong.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TriggeredRepository extends JpaRepository<Triggered, Long> {
    List<Triggered> findAllByModule(Module module);
}
