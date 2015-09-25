package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.*;
import fr.treeptik.model.*;

@Service
public class TeamService {

	@Autowired
    private TeamDAO teamDao;

    public TeamService() {
	}
    
    public TeamService(TeamDAO teamDao) {
		this.teamDao = teamDao;
	}

	public Team findById(int id) {
        return teamDao.findById(id);
    }

	public List<Team> findAll() {
		return teamDao.findAll();
	}

	public Team save(Team drink) {
		return teamDao.save(drink);
	}

	public Team update(Team drink) {
		return teamDao.save(drink);
	}

	public void removeById(Integer id) {
		teamDao.delete(id);
	}
}