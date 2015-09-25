package fr.treeptik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.treeptik.model.*;

@Repository
public interface NoteDAO extends JpaRepository<Note, Integer> {

	Note findById(int id);
}