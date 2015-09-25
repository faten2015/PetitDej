package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.*;
import fr.treeptik.model.*;

@Service
public class PetitDejService {

	@Autowired
    private PetitDejDAO petitDejDao;

    public PetitDejService() {
	}
    
    public PetitDejService(PetitDejDAO petitDejDao) {
		this.petitDejDao = petitDejDao;
	}

	public PetitDej findById(int id) {
        return petitDejDao.findById(id);
    }

	public List<PetitDej> findAll() {
		return petitDejDao.findAll();
	}

	public PetitDej save(PetitDej drink) {
		return petitDejDao.save(drink);
	}

	public PetitDej update(PetitDej drink) {
		return petitDejDao.save(drink);
	}

	public void removeById(Integer id) {
		petitDejDao.delete(id);
	}
}