package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.*;
import fr.treeptik.model.*;

@Service
public class AgendaService {

	@Autowired
    private AgendaDAO agendaDao;

    public AgendaService() {
	}
    
    public AgendaService(AgendaDAO agendaDao) {
		this.agendaDao = agendaDao;
	}

	public Agenda findById(int id) {
        return agendaDao.findById(id);
    }

	public List<Agenda> findAll() {
		return agendaDao.findAll();
	}

	public Agenda save(Agenda drink) {
		return agendaDao.save(drink);
	}

	public Agenda update(Agenda drink) {
		return agendaDao.save(drink);
	}

	public void removeById(Integer id) {
		agendaDao.delete(id);
	}
}