
package com.mkyong.repositories;

import com.mkyong.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    List<Utilisateur>findAllByLoginAndPassword(String login,String password);
}

