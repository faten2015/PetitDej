package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.*;
import fr.treeptik.model.*;

@Service
public class ResponsableService {

	@Autowired
    private ResponsableDAO responsableDao;

    public ResponsableService() {
	}
    
    public ResponsableService(ResponsableDAO responsableDao) {
		this.responsableDao = responsableDao;
	}

	public Responsable findById(int id) {
        return responsableDao.findById(id);
    }

	public List<Responsable> findAll() {
		return responsableDao.findAll();
	}

	public Responsable save(Responsable drink) {
		return responsableDao.save(drink);
	}

	public Responsable update(Responsable drink) {
		return responsableDao.save(drink);
	}

	public void removeById(Integer id) {
		responsableDao.delete(id);
	}
}