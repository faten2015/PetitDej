package fr.treeptik.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.treeptik.model.*;

@Repository
public interface PetitDejDAO extends JpaRepository<PetitDej, Integer> {

	PetitDej findById(int id);
}