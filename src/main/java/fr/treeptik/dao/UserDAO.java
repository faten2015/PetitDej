package fr.treeptik.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.treeptik.model.*;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
}
